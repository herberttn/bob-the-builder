package edu.uniasselvi.ads24.db.dao;

import java.sql.Connection;
import java.sql.Statement;

import edu.uniasselvi.ads24.db.conexao.BancoDadosException;
import edu.uniasselvi.ads24.db.conexao.Conexao;

public class ScriptDAO {

	public boolean CriarTabela() throws BancoDadosException {
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
	
	public boolean ExcluirTabela() throws BancoDadosException {
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
