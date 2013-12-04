package edu.uniasselvi.ads24.bob.testes;

import edu.uniasselvi.ads24.bob.db.dao.CampoDAO;
import edu.uniasselvi.ads24.bob.db.dao.EmpresaDAO;
import edu.uniasselvi.ads24.bob.db.dao.FilialDAO;
import edu.uniasselvi.ads24.bob.db.dao.ScriptDAO;
import edu.uniasselvi.ads24.bob.db.dao.TabelaDAO;

public class TesteDBTabelasExcluir {

	public static void main(String[] args) {
		
		CampoDAO campoDAO = new CampoDAO();
		EmpresaDAO empresaDAO = new EmpresaDAO();
		FilialDAO filialDAO = new FilialDAO();
		ScriptDAO scriptDAO = new ScriptDAO();
		TabelaDAO tabelaDAO = new TabelaDAO();
		
		System.out.println("|---------------------------------------------------|");
		System.out.println("|                Exclusão das tabelas               |");
		System.out.println("|---------------------------------------------------|");			
		
		try {
			System.out.println("Excluindo tabela Z_SCRIPT.");
			scriptDAO.excluirTabela();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
		try {
			System.out.println("Excluindo tabela FILIAIS.");
			filialDAO.excluirTabela();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Excluindo tabela EMPRESAS.");
			empresaDAO.excluirTabela();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Excluindo tabela Z_CAMPOS.");
			campoDAO.excluirTabela();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Excluindo tabela Z_TABELAS.");
			tabelaDAO.excluirTabela();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Fim.");
	}

}
