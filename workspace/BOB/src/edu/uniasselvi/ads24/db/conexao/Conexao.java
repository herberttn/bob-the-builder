package edu.uniasselvi.ads24.db.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static Connection conn = null;

	public static Connection getConexao() throws BancoDadosException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOB", "root", "social");
			return conn;
		} catch (Exception e) {
			throw new BancoDadosException(EErrosBancoDados.ABRE_CONEXAO, e.getMessage());
		}
	}
	
	public static void closeConexao() throws BancoDadosException {
		try {
			if (conn instanceof Connection) {
				conn.close();
				conn = null;
			}
			return;
		} catch (Exception e) {
			throw new BancoDadosException(EErrosBancoDados.FECHA_CONEXAO, e.getMessage());
		}
	}
}
