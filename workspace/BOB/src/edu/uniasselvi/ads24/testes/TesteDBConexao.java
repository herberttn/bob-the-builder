package edu.uniasselvi.ads24.testes;

import edu.uniasselvi.ads24.db.conexao.BancoDadosException;
import edu.uniasselvi.ads24.db.conexao.Conexao;

public class TesteDBConexao {

	public static void main(String[] args) {

		System.out.println("Abrindo conexao.");
		try {
			Conexao.getConexao();
		} catch (BancoDadosException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Fechando conexao.");
		try {
			Conexao.closeConexao();
		} catch (BancoDadosException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Sucesso.");
	}
}
