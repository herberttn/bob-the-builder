package edu.uniasselvi.ads24.bob.db.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

import edu.uniasselvi.ads24.bob.enumeradores.EErrosDB;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public class Conexao {
	
	private static Connection conn = null;

	public static Connection getConexao() throws DBException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOB", "root", "social");
			return conn;
		} catch (Exception e) {
			throw new DBException(EErrosDB.ABRIR_CONEXAO, e.getMessage());
		}
	}
	
	public static void closeConexao() throws DBException {
		try {
			if (conn instanceof Connection) {
				conn.close();
				conn = null;
			}
			return;
		} catch (Exception e) {
			throw new DBException(EErrosDB.FECHAR_CONEXAO, e.getMessage());
		}
	}
}
