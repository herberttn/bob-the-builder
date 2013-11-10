package edu.uniasselvi.ads24.testes;

import edu.uniasselvi.ads24.db.conexao.BancoDadosException;
import edu.uniasselvi.ads24.db.dao.CampoDAO;
import edu.uniasselvi.ads24.db.dao.CampoItemDAO;
import edu.uniasselvi.ads24.db.dao.EmpresaDAO;
import edu.uniasselvi.ads24.db.dao.FilialDAO;
import edu.uniasselvi.ads24.db.dao.ScriptDAO;
import edu.uniasselvi.ads24.db.dao.TabelaDAO;

public class TesteDBTabelasCriarExcluir {

	public static void main(String[] args) {
		
		CampoDAO campoDAO = null;
		CampoItemDAO campoItemDAO = null;
		EmpresaDAO empresaDAO = null;
		FilialDAO filialDAO = null;
		ScriptDAO scriptDAO = null;
		TabelaDAO tabelaDAO = null;

		System.out.println("Instanciando objetos.");
		try {
			campoDAO = new CampoDAO();
			campoItemDAO = new CampoItemDAO();
			empresaDAO = new EmpresaDAO();
			filialDAO = new FilialDAO();
			scriptDAO = new ScriptDAO();
			tabelaDAO = new TabelaDAO();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Criando tabela Z_TABELAS.");
			tabelaDAO.CriarTabela();

			System.out.println("Criando tabela Z_CAMPOS.");
			campoDAO.CriarTabela();

			System.out.println("Criando tabela Z_CAMPOITENS.");
			campoItemDAO.CriarTabela();

			System.out.println("Criando tabela EMPRESAS.");
			empresaDAO.CriarTabela();

			System.out.println("Criando tabela FILIAIS.");
			filialDAO.CriarTabela();

			System.out.println("Criando tabela Z_SCRIPT.");
			scriptDAO.CriarTabela();
		} catch (BancoDadosException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Excluindo tabela Z_SCRIPT.");
			scriptDAO.ExcluirTabela();
			
			System.out.println("Excluindo tabela FILIAIS.");
			filialDAO.ExcluirTabela();

			System.out.println("Excluindo tabela EMPRESAS.");
			empresaDAO.ExcluirTabela();

			System.out.println("Excluindo tabela Z_CAMPOITENS.");
			campoItemDAO.ExcluirTabela();

			System.out.println("Excluindo tabela Z_CAMPOS.");
			campoDAO.ExcluirTabela();

			System.out.println("Excluindo tabela Z_TABELAS.");
			tabelaDAO.ExcluirTabela();

		} catch (BancoDadosException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Sucesso.");
	}

}
