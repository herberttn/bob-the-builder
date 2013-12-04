package edu.uniasselvi.ads24.bob.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.uniasselvi.ads24.bob.bean.RegistroBase;
import edu.uniasselvi.ads24.bob.db.conexao.Conexao;
import edu.uniasselvi.ads24.bob.enumeradores.EErrosDB;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;

public abstract class BaseDAO implements IDataAccessObject {
	
	Savepoint sv = null;
	
	public void setSavepoint() throws SQLException, DBException {
		if (this.sv == null)
			this.sv = Conexao.getConexao().setSavepoint();
	}
	
	public void resetSavepoint() throws SQLException, DBException {
		this.sv = Conexao.getConexao().setSavepoint();
	}
	
	@Override
	public abstract String tableName();

	@Override
	public abstract String tableFields();

	@Override
	public abstract boolean criarTabela() throws DBException;

	@Override
	public boolean excluirTabela() throws DBException {

		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("DROP TABLE " + tableName() + ";");
			return true;

		} catch (Exception e) {
			throw new DBException(EErrosDB.EXCLUIR_TABELA, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	protected boolean criarTabela(String fields) throws DBException {

		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE " + tableName() + " (" + fields + ");");
			return true;

		} catch (Exception e) {
			throw new DBException(EErrosDB.CRIAR_TABELA, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	protected <T> T consultar(Class<T> clazz, int ID) throws DBException {

		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT "
					+ tableFields() + "  FROM " + tableName()
					+ " WHERE ID = ?;");
			pst.setInt(1, ID);
			ResultSet rs = pst.executeQuery();

			if (rs.first()) {
				return instanciarEPreencher(clazz, rs);
			}
			return null;

		} catch (Exception e) {
			throw new DBException(EErrosDB.CONSULTAR, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	protected <T> List<T> consultarVarios(Class<T> clazz, String where, String orderby) throws DBException {
		
		Connection conexao = Conexao.getConexao();
		try {
			List<T> lista = new ArrayList<T>();
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT " + tableFields() + " FROM "
					+ tableName() + " WHERE " + where + " ORDER BY " + orderby.toUpperCase() + ";");

			while (rs.next()) {
				lista.add(instanciarEPreencher(clazz, rs));
			}
			return lista;

		} catch (Exception e) {
			throw new DBException(EErrosDB.CONSULTAR, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	protected <T> List<T> consultarTodos(Class<T> clazz, String orderby) throws DBException {

		Connection conexao = Conexao.getConexao();
		try {
			List<T> lista = new ArrayList<T>();
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT " + tableFields() + " FROM "
					+ tableName() + " ORDER BY " + orderby.toUpperCase() + ";");

			while (rs.next()) {
				lista.add(instanciarEPreencher(clazz, rs));
			}
			return lista;

		} catch (Exception e) {
			throw new DBException(EErrosDB.CONSULTAR, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	protected <T> boolean inserir(Class<T> clazz, T bean) throws DBException {
		
		Connection conexao = Conexao.getConexao();
		try {
			conexao.setAutoCommit(false);
			this.setSavepoint();
			
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO " + tableName() 
					+ " (" + tableFields() + ") " 
					+ "VALUES (" + buildStatementParams() + ");");
			
			garantirIDUnico(((RegistroBase) bean), this.tableName());
			((RegistroBase) bean).loadStatementParams(pst);
			
			if (pst.executeUpdate() > 0) {
				conexao.commit();
				return true;
			}
			return false;
			
		} catch (Exception e) {
			try {
				conexao.rollback(sv);
			} catch (Exception r) {
				throw new DBException(EErrosDB.ROLLBACK, r.getMessage());
			}
				throw new DBException(EErrosDB.INSERIR_DADOS, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}	

	protected <T> boolean inserirVarios(Class<T> clazz, List<T> beanList) throws DBException {
		
		Connection conexao = Conexao.getConexao();
		try {
			conexao.setAutoCommit(false);
			this.setSavepoint();
			
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO " + tableName() 
					+ " (" + tableFields() + ") " 
					+ "VALUES (" + buildStatementParams() + ");");
			
			for (T bean : beanList) {
				garantirIDUnico(((RegistroBase) bean), this.tableName());
				((RegistroBase) bean).loadStatementParams(pst);
				pst.executeUpdate();
			}
			conexao.commit();
			return true;
			
		} catch (Exception e) {
			try {
				conexao.rollback(sv);
			} catch (Exception r) {
				throw new DBException(EErrosDB.ROLLBACK, r.getMessage());
			}
				throw new DBException(EErrosDB.INSERIR_DADOS, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	protected <T> boolean alterar(Class<T> clazz, T bean) throws DBException {
		
		Connection conexao = Conexao.getConexao();
		try {
			String[] fields = splitFieldNames();
			int fieldCount = 0;
			
			String temp = "";
			for (String field : fields) {
				if (!field.isEmpty())
				{
					fieldCount++;
					if (temp.isEmpty())
						temp = field + " = ?";
					else
						temp = temp + ", " + field + " = ?";
				}
			}
			
			conexao.setAutoCommit(false);
			this.setSavepoint();
			
			PreparedStatement pst = conexao.prepareStatement("UPDATE " + tableName() 
					+ " SET " + temp
					+ " WHERE ID = ?;");
			
			((RegistroBase) bean).loadStatementParams(pst);
			pst.setInt(fieldCount + 1, ((RegistroBase) bean).getID());
			
			if (pst.executeUpdate() > 0) {
				conexao.commit();
				return true;
			}
			return false;
			
		} catch (Exception e) {
			try {
				conexao.rollback(sv);
			} catch (Exception r) {
				throw new DBException(EErrosDB.ROLLBACK, r.getMessage());
			}
				throw new DBException(EErrosDB.INSERIR_DADOS, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	protected <T> boolean excluir(Class<T> clazz, T bean) throws DBException {
		
		Connection conexao = Conexao.getConexao();
		try {
			conexao.setAutoCommit(false);
			this.setSavepoint();
			
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM " + tableName() 
					+ " WHERE ID = ?;");
			
			pst.setInt(1, ((RegistroBase) bean).getID());
			
			if (pst.executeUpdate() > 0) {
				conexao.commit();
				return true;
			}
			return false;
			
		} catch (Exception e) {
			try {
				conexao.rollback(sv);
			} catch (Exception r) {
				throw new DBException(EErrosDB.ROLLBACK, r.getMessage());
			}
				throw new DBException(EErrosDB.INSERIR_DADOS, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	private void garantirIDUnico(RegistroBase bean, String tableName) throws DBException {
		
		// Gera novo ID quando não informado
		if (bean.getID() <= 0) {
			bean.setID(gerarID(tableName));
		} else {
			// Gera um novo ID quando o informado já existe
			if (consultar(bean.getClass(), bean.getID()) != null)
				bean.setID(gerarID(tableName));
		}
	}
	
	private int gerarID(String tableName) throws DBException {
		
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT IFNULL(MAX(ID), 0) AS TEMP FROM " + tableName() + ";");

			if (rs.first()) {
				return rs.getInt("TEMP") + 1;
			}
			return 1;

		} catch (Exception e) {
			throw new DBException(EErrosDB.GERAR_ID, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}	
	}
	
	private <T> T instanciarEPreencher(Class<T> clazz, ResultSet resultSet) throws InstantiationException, IllegalAccessException, SQLException, DBException {
		T temp = clazz.newInstance();
		((RegistroBase) temp).loadFromResultSet(resultSet);
		return temp;
	}

	private String[] splitFieldNames() {
		// Com a string de campos, cria um array
		return tableFields().split("[[^a-z]&&[^A-Z]]");
	}
	
	private String buildStatementParams() {
		
		// Com a string de campos, cria um array
		String[] fields = splitFieldNames();
		
		String temp = "";
		
		for (String field : fields) {
			if (!field.isEmpty())
			{
				if (temp.isEmpty())
					temp = "?";
				else
					temp = temp + ", ?";
			}					
		}
		return temp;
	}
	
	protected Savepoint getSv() {
		return sv;
	}
}