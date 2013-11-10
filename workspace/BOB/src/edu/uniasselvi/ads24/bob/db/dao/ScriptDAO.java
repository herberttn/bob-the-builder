package edu.uniasselvi.ads24.bob.db.dao;

import java.sql.Connection;
import java.sql.Statement;
import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.db.conexao.Conexao;

public class ScriptDAO implements IDataAccessObject {

	public boolean CriarTabela() throws DBException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute(" CREATE TABLE BOB.Z_SCRIPT ( "
					+ "     ID INTEGER NOT NULL PRIMARY KEY, "
					+ "     TIPO INTEGER NOT NULL, "
					+ "     DATAHORA DATETIME NOT NULL, "
					+ "     COMANDO VARCHAR(2048) NOT NULL, "
					+ "     BOBVERSION VARCHAR(15) NOT NULL ); ");
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
			st.execute(" DROP TABLE BOB.Z_SCRIPT; ");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
