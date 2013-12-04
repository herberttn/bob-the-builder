package edu.uniasselvi.ads24.bob.testes;

import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.db.dao.CampoDAO;
import edu.uniasselvi.ads24.bob.db.dao.EmpresaDAO;
import edu.uniasselvi.ads24.bob.db.dao.FilialDAO;
import edu.uniasselvi.ads24.bob.db.dao.ScriptDAO;
import edu.uniasselvi.ads24.bob.db.dao.TabelaDAO;

public class TesteDBTabelasCriar {
	
	public static void main(String[] args) throws DBException {
		
		CampoDAO campoDAO = new CampoDAO();
		EmpresaDAO empresaDAO = new EmpresaDAO();
		FilialDAO filialDAO = new FilialDAO();
		ScriptDAO scriptDAO = new ScriptDAO();
		TabelaDAO tabelaDAO = new TabelaDAO();
		
		System.out.println("|---------------------------------------------------|");
		System.out.println("|                Criação das tabelas                |");
		System.out.println("|---------------------------------------------------|");
		
		System.out.println("Criando tabela Z_TABELAS.");
		try {
			tabelaDAO.criarTabela();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Criando tabela Z_CAMPOS.");
		try {
			campoDAO.criarTabela();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Criando tabela EMPRESAS.");
		try {
			empresaDAO.criarTabela();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Criando tabela FILIAIS.");
		try {
			filialDAO.criarTabela();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Criando tabela Z_SCRIPT.");
		try {
			scriptDAO.criarTabela();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Fim.");
	}
}
