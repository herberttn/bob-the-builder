package edu.uniasselvi.ads24.bob.testes;

import java.sql.Date;
import edu.uniasselvi.ads24.bob.bean.*;
import edu.uniasselvi.ads24.bob.db.dao.*;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public class TesteDBRegistrosInserirConsultarExcluir {

	public TesteDBRegistrosInserirConsultarExcluir() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws DBException {
		
		CampoDAO campoDAO = null;
		EmpresaDAO empresaDAO = null;
		FilialDAO filialDAO = null;
		ScriptDAO scriptDAO = null;
		TabelaDAO tabelaDAO = null;
		
		try {
		
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

			System.out.println("|---------------------------------------------------|");
			System.out.println("|               Insersão de registros               |");
			System.out.println("|---------------------------------------------------|");
			System.out.println("");
			System.out.println("|***************|");
			System.out.println("|     Tabela    |");
			System.out.println("|***************|");
			
			System.out.println("Criando objeto de registro");
			Tabela tabela = null;
			try {
				tabela = new Tabela(1, "TESTE1", "Legenda da tabela TESTE1", true, false);
				System.out.println(tabela);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("");		
			System.out.println("Inserindo registro no banco");		
			try {
				tabelaDAO.inserir(tabela);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("");		
			System.out.println("Consultando registro do banco");		
			try {
				Tabela teste = tabelaDAO.consultar(1);
				
				if (teste != null)
				{
					System.out.println(teste);			
				}
				else
					System.out.println("Registro não encontrado.");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			System.out.println("");		
			System.out.println("Alterando registro no banco");		
			try {
				tabela.setLegenda("legenda alterada");
				tabela.setNome("nome alterado");
				tabela.setPorEmpresa(false);
				tabela.setPorFilial(false);
				
				System.out.println(tabela);
				
				tabelaDAO.alterar(tabela);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("");		
			System.out.println("Consultando registro do banco");		
			try {
				Tabela teste = tabelaDAO.consultar(1);
				
				if (teste != null)
				{
					System.out.println(teste);			
				}
				else
					System.out.println("Registro não encontrado.");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			System.out.println("");		
			System.out.println("Excluindo registro do banco");		
			try {
				tabelaDAO.excluir(tabela);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("");		
			System.out.println("Consultando registro do banco");		
			try {
				Tabela teste = tabelaDAO.consultar(1);
				
				if (teste != null)
				{
					System.out.println(teste);			
				}
				else
					System.out.println("Registro não encontrado.");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			System.out.println("");
			System.out.println("|***************|");
			System.out.println("|     Script    |");
			System.out.println("|***************|");
			
			System.out.println("Criando objeto de registro");
			Script script = null;
			try {
				script = new Script(1, 1, new Date(1), "aosdhj", "1.0");
				System.out.println(script);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("");		
			System.out.println("Inserindo registro no banco");		
			try {
				scriptDAO.inserir(script);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("");		
			System.out.println("Consultando registro do banco");		
			try {
				Script teste = scriptDAO.consultar(1);
				
				if (teste != null)
				{
					System.out.println(teste);			
				}
				else
					System.out.println("Registro não encontrado.");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
			System.out.println("");		
			System.out.println("Excluindo registro do banco");		
			try {
				scriptDAO.excluir(script);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("");		
			System.out.println("Consultando registro do banco");		
			try {
				Script teste = scriptDAO.consultar(1);
				
				if (teste != null)
				{
					System.out.println(teste);			
				}
				else
					System.out.println("Registro não encontrado.");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		}
		finally {
			
			System.out.println("|---------------------------------------------------|");
			System.out.println("|                Exclusão das tabelas               |");
			System.out.println("|---------------------------------------------------|");			
			
			try {
				System.out.println("Excluindo tabela Z_SCRIPT.");
				scriptDAO.excluirTabela();
			} catch (DBException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
				
			try {
				System.out.println("Excluindo tabela FILIAIS.");
				filialDAO.excluirTabela();
			} catch (DBException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				System.out.println("Excluindo tabela EMPRESAS.");
				empresaDAO.excluirTabela();
			} catch (DBException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				System.out.println("Excluindo tabela Z_CAMPOS.");
				campoDAO.excluirTabela();
			} catch (DBException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				System.out.println("Excluindo tabela Z_TABELAS.");
				tabelaDAO.excluirTabela();
			} catch (DBException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println("Sucesso.");
	}
}
