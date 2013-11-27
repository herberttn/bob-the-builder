package edu.uniasselvi.ads24.bob.testes;

import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.db.dao.CampoDAO;
import edu.uniasselvi.ads24.bob.db.dao.EmpresaDAO;
import edu.uniasselvi.ads24.bob.db.dao.FilialDAO;
import edu.uniasselvi.ads24.bob.db.dao.ScriptDAO;
import edu.uniasselvi.ads24.bob.db.dao.TabelaDAO;

public class TesteDBTabelasCriarExcluir {

	public static void main(String[] args) throws DBException {
		
		CampoDAO campoDAO = null;
		EmpresaDAO empresaDAO = null;
		FilialDAO filialDAO = null;
		ScriptDAO scriptDAO = null;
		TabelaDAO tabelaDAO = null;
		
		System.out.println("Instanciando objetos.");
		try {
			campoDAO = new CampoDAO();
			empresaDAO = new EmpresaDAO();
			filialDAO = new FilialDAO();
			scriptDAO = new ScriptDAO();
			tabelaDAO = new TabelaDAO();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Criando tabela Z_TABELAS.");
			tabelaDAO.criarTabela();

			System.out.println("Criando tabela Z_CAMPOS.");
			campoDAO.criarTabela();

			System.out.println("Criando tabela EMPRESAS.");
			empresaDAO.criarTabela();

			System.out.println("Criando tabela FILIAIS.");
			filialDAO.criarTabela();

			System.out.println("Criando tabela Z_SCRIPT.");
			scriptDAO.criarTabela();
		} catch (DBException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Excluindo tabela Z_SCRIPT.");
			scriptDAO.excluirTabela();
			
			System.out.println("Excluindo tabela FILIAIS.");
			filialDAO.excluirTabela();

			System.out.println("Excluindo tabela EMPRESAS.");
			empresaDAO.excluirTabela();

			System.out.println("Excluindo tabela Z_CAMPOS.");
			campoDAO.excluirTabela();

			System.out.println("Excluindo tabela Z_TABELAS.");
			tabelaDAO.excluirTabela();

		} catch (DBException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Sucesso.");
	}
}
