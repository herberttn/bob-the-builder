package edu.uniasselvi.ads24.bob.db.dao;

import java.sql.Connection;
import java.sql.Statement;
import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.db.conexao.Conexao;

public class TabelaDAO implements IDataAccessObject {

	public boolean CriarTabela() throws DBException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute(" CREATE TABLE BOB.Z_TABELAS ( "
					+ "     ID INTEGER NOT NULL PRIMARY KEY, "
					+ "     NOME VARCHAR(45) NOT NULL, "
					+ "     LEGENDA VARCHAR(250) NOT NULL, "
					+ "     POREMPRESA CHAR(1) NOT NULL, "
					+ "     PORFILIAL CHAR(1) NOT NULL ); ");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean ExcluirTabela() throws DBException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute(" DROP TABLE BOB.Z_TABELAS; ");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
