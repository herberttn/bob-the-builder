package edu.uniasselvi.ads24.bob.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public abstract String TableName();

	@Override
	public abstract String TableFields();

	@Override
	public abstract boolean CriarTabela() throws DBException;

	@Override
	public boolean CriarTabela(String fields) throws DBException {

		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE " + TableName() + " (" + fields + ");");
			return true;

		} catch (Exception e) {
			throw new DBException(EErrosDB.CRIAR_TABELA, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean ExcluirTabela() throws DBException {

		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("DROP TABLE " + TableName() + ";");
			return true;

		} catch (Exception e) {
			throw new DBException(EErrosDB.EXCLUIR_TABELA, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	private <T> T instanciarEPreencher(Class<T> clazz, ResultSet resultSet)
			throws InstantiationException, IllegalAccessException,
			SQLException, DBException {
		T temp = clazz.newInstance();
		((RegistroBase) temp).loadResultSet(resultSet);
		return temp;
	}

	public <T> T consultar(Class<T> clazz, int ID) throws DBException {

		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT "
					+ TableFields() + "  FROM " + TableName()
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

	public <T> List<T> consultarTodos(Class<T> clazz) throws DBException {

		Connection conexao = Conexao.getConexao();
		try {
			List<T> lista = new ArrayList<T>();
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT " + TableFields() + " FROM "
					+ TableName() + ";");

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
}
