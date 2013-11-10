package edu.uniasselvi.ads24.db.dao;

import java.sql.Connection;
import java.sql.Statement;

import edu.uniasselvi.ads24.db.conexao.BancoDadosException;
import edu.uniasselvi.ads24.db.conexao.Conexao;

public class EmpresaDAO {

	public boolean CriarTabela() throws BancoDadosException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute(" CREATE TABLE BOB.EMPRESAS ( "
					+ "     ID INTEGER NOT NULL PRIMARY KEY, "
					+ "     NOME VARCHAR(100) NOT NULL, "
					+ "     CNPJ VARCHAR(14) NOT NULL ); ");
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
			st.execute(" DROP TABLE BOB.EMPRESAS; ");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
