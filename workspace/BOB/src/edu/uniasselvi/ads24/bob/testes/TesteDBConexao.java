package edu.uniasselvi.ads24.bob.testes;

import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.db.conexao.Conexao;

public class TesteDBConexao {

	public static void main(String[] args) {

		System.out.println("Abrindo conexao.");
		try {
			Conexao.getConexao();
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Fechando conexao.");
		try {
			Conexao.closeConexao();
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Sucesso.");
	}
}
