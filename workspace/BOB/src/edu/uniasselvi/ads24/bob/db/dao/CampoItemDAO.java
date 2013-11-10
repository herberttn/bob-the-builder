package edu.uniasselvi.ads24.bob.db.dao;

import java.sql.Connection;
import java.sql.Statement;
import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.db.conexao.Conexao;

public class CampoItemDAO implements IDataAccessObject {

	public boolean CriarTabela() throws DBException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute(" CREATE TABLE BOB.Z_CAMPOITENS ( "
					+ "     ID INTEGER NOT NULL PRIMARY KEY, "
					+ "     CAMPO INTEGER NOT NULL, "
					+ "     LEGENDA VARCHAR(45) NOT NULL, "
					+ "     VALOR INTEGER NOT NULL, "
					+ "     INDEX BOB.Z_CAMPOITENS.IDX_FK_Z_CAMPOITENS_CAMPO(CAMPO ASC), "
					+ "     CONSTRAINT BOB.Z_CAMPOITENS.FK_Z_CAMPOITENS_CAMPO FOREIGN KEY(CAMPO) REFERENCES BOB.Z_CAMPOS(ID) ON DELETE NO ACTION ON UPDATE NO ACTION ); ");
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
			st.execute(" DROP TABLE BOB.Z_CAMPOITENS; ");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
