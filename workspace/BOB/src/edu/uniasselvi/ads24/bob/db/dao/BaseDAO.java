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

	@Override
	public abstract String tableName();

	@Override
	public abstract String tableFields();

	@Override
	public abstract boolean criarTabela() throws DBException;

	@Override
	public boolean criarTabela(String fields) throws DBException {

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

	protected <T> T instanciarEPreencher(Class<T> clazz, ResultSet resultSet) throws InstantiationException, IllegalAccessException, SQLException, DBException {
		T temp = clazz.newInstance();
		((RegistroBase) temp).loadFromResultSet(resultSet);
		return temp;
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

	public <T> List<T> consultarVarios(Class<T> clazz, String where) throws DBException {
		
		Connection conexao = Conexao.getConexao();
		try {
			List<T> lista = new ArrayList<T>();
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT " + tableFields() + " FROM "
					+ tableName() + " WHERE " + where + ";");

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
	
	protected <T> List<T> consultarTodos(Class<T> clazz) throws DBException {

		Connection conexao = Conexao.getConexao();
		try {
			List<T> lista = new ArrayList<T>();
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT " + tableFields() + " FROM "
					+ tableName() + ";");

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
		
		// Repete um ? para cada campo
//		return String.format("%0" + (fields.length - 1) + "d", 0).replace("0", "?, ") + "?";
	}
	
	protected <T> boolean inserir(Class<T> clazz, T bean) throws DBException {
		
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO " + tableName() 
					+ " (" + tableFields() + ") " 
					+ "VALUES (" + buildStatementParams() + ");");
			
			((RegistroBase) bean).loadStatementParams(pst);
			
			return pst.executeUpdate() > 0;
			
		} catch (Exception e) {
			throw new DBException(EErrosDB.INSERIR_DADOS, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}	

	protected <T> boolean inserirVarios(Class<T> clazz, List<T> beanList) throws DBException {
		
		Connection conexao = Conexao.getConexao();
		Savepoint sv = null;
		try {
			conexao.setAutoCommit(false);
			sv = conexao.setSavepoint();
			
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO " + tableName() 
					+ " (" + tableFields() + ") " 
					+ "VALUES (" + buildStatementParams() + ");");
			
			for (T bean : beanList) {
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
			
			PreparedStatement pst = conexao.prepareStatement("UPDATE " + tableName() 
					+ " SET " + temp
					+ " WHERE ID = ?;");
			
			((RegistroBase) bean).loadStatementParams(pst);
			pst.setInt(fieldCount + 1, ((RegistroBase) bean).getID());
			
			return pst.executeUpdate() > 0;
			
		} catch (Exception e) {
			throw new DBException(EErrosDB.ALTERAR_DADOS, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	protected <T> boolean excluir(Class<T> clazz, T bean) throws DBException {
		
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM " + tableName() 
					+ " WHERE ID = ?;");
			
			pst.setInt(1, ((RegistroBase) bean).getID());
			
			return pst.executeUpdate() > 0;
			
		} catch (Exception e) {
			throw new DBException(EErrosDB.EXCLUIR_DADOS, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}	
}