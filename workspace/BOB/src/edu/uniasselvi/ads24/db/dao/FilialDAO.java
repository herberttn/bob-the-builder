package edu.uniasselvi.ads24.db.dao;

import java.sql.Connection;
import java.sql.Statement;

import edu.uniasselvi.ads24.db.conexao.BancoDadosException;
import edu.uniasselvi.ads24.db.conexao.Conexao;

public class FilialDAO {

	public boolean CriarTabela() throws BancoDadosException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute(" CREATE TABLE BOB.FILIAIS ( "
					+ "     ID INTEGER NOT NULL PRIMARY KEY, "
					+ "     EMPRESA INTEGER, "
					+ "     NOME VARCHAR(100) NOT NULL, "
					+ "     CNPJ VARCHAR(14) NOT NULL, "
					+ "     INDEX BOB.FILIAIS.IDX_FK_FILIAIS_EMPRESA(EMPRESA ASC), "
					+ "     CONSTRAINT BOB.FILIAIS.FK_FILIAIS_EMPRESA FOREIGN KEY(EMPRESA) REFERENCES BOB.EMPRESAS(ID) ON DELETE NO ACTION ON UPDATE NO ACTION ); ");
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
			st.execute(" DROP TABLE BOB.FILIAIS; ");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
