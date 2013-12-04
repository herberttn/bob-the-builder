package edu.uniasselvi.ads24.bob.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import edu.uniasselvi.ads24.bob.bean.CampoBase;
import edu.uniasselvi.ads24.bob.bean.CampoDecimal;
import edu.uniasselvi.ads24.bob.bean.CampoInteger;
import edu.uniasselvi.ads24.bob.bean.CampoPK;
import edu.uniasselvi.ads24.bob.bean.CampoString;
import edu.uniasselvi.ads24.bob.bean.CampoTabela;
import edu.uniasselvi.ads24.bob.bean.Tabela;
import edu.uniasselvi.ads24.bob.enumeradores.EBusinessExceptions;
import edu.uniasselvi.ads24.bob.exceptions.BusinessExceptions;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.exceptions.GeradorComandoDBException;
import edu.uniasselvi.ads24.bob.geradores.GeradorScriptArquivo;

public final class MenuMain {

	public static void main(String[] args) throws BusinessExceptions, IOException {
		
		try {
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			int opcaoDesejada = -1;

			do {
				try {
					Tabela tabela = null;
					CampoBase campo = null;
					GeradorScriptArquivo geradorScriptArquivo = null;
					
					opcaoDesejada = DesignMenus.menuPrincipal(teclado);
					
					switch (opcaoDesejada) {
					
					// 1 - Tabelas - Criar
					case 1:
						DesignMenus.limparConsole();
						CriarTabela(teclado);
						break;
						
					// 2 - Tabelas - Excluir
					case 2:
						DesignMenus.limparConsole();
						tabela = DesignMenus.escolherTabela(teclado);
						
						if (tabela != null)
							tabela.Excluir();
						break;
						
					// 3 - Tabelas - Listar
					case 3:
						DesignMenus.menuListarTabelas();
						break;
						
					// 4 - Campos - Criar 
					case 4:
						DesignMenus.limparConsole();
						tabela = DesignMenus.escolherTabela(teclado);
						
						if (tabela != null)
							CriarCampo(teclado, tabela);
						break;
						
					// 5 - Campos - Excluir
					case 5:
						DesignMenus.limparConsole();
						campo = DesignMenus.escolherCampo(teclado);
						
						if (campo != null)
							campo.Excluir();
						break;
						
					// 6 - Campos - Listar
					case 6:
						DesignMenus.menuListarCampos();
						break;

					// 7 - Scripts - Listar 
					case 7:
						DesignMenus.menuListarScripts();
						break;

					// 8 - Scripts - Importar
					case 8:
						geradorScriptArquivo = new GeradorScriptArquivo(DesignMenus.solicitarCaminhoArquivo(teclado));
						geradorScriptArquivo.importarDeArquivo();						
						break;

					// 9 - Scripts - Exportar script
					case 9:
						geradorScriptArquivo = new GeradorScriptArquivo(DesignMenus.solicitarCaminhoArquivo(teclado));
						geradorScriptArquivo.exportarParaArquivo();						
						break;
						
					// 0 - Sair						
					case 0:
						System.out.println("Até logo!");
						break;
						
					default:
						break;
					}
					
				} catch (BusinessExceptions e) {
					System.out.println("OPS! Houve um problema! :(~ " + e.getMessage());
					opcaoDesejada = 666;
				}

			} while (opcaoDesejada > 0);

		} catch (Exception e) {
			System.out.println("Houston, we have a problem! :/ " + e.getMessage());
		}
	}

	private static void CriarCampo(BufferedReader teclado, Tabela tabela) throws BusinessExceptions, IOException, DBException, GeradorComandoDBException, SQLException {
		
		int opcaoEscolhida = DesignMenus.menuOpcoesTipoCampo(teclado);
		
		switch (opcaoEscolhida) {
		
		// 1 - Integer
		case 1:
			CampoInteger campoInteger = DesignMenus.menuInformarCampoInteger(teclado);
			campoInteger.setTabela(tabela);
			campoInteger.Salvar();
			break;
			
		// 2 - String
		case 2:
			CampoString campoString = DesignMenus.menuInformarCampoString(teclado);
			campoString.setTabela(tabela);
			campoString.Salvar();
			break;
			
		// 3 - Decimal
		case 3:
			CampoDecimal campoDecimal = DesignMenus.menuInformarCampoDecimal(teclado);
			campoDecimal.setTabela(tabela);
			campoDecimal.Salvar();
			break;
			
		// 4 - PK
		case 4:
			CampoPK campoPK = DesignMenus.menuInformarCampoPK(teclado);
			campoPK.setTabela(tabela);
			campoPK.Salvar();
			break;
				
		// 5 - Tabela
		case 5:
			CampoTabela campoTabela = DesignMenus.menuInformarCampoTabela(teclado);
			campoTabela.setTabela(tabela);
			campoTabela.Salvar();
			break;

		default:
			throw new BusinessExceptions(EBusinessExceptions.OPCAO_INVALIDA);
		}

		System.out.println("Continuar cadastrando campos para esta tabela? (S/N)");
		
		if (teclado.readLine().equalsIgnoreCase("S"))
			CriarCampo(teclado, tabela);
	}

	private static void CriarTabela(BufferedReader teclado) throws BusinessExceptions, IOException, DBException, GeradorComandoDBException, SQLException {

		Tabela tabela = DesignMenus.menuCriarTabela(teclado);
		tabela.Salvar();
		
		System.out.println("Deseja cadastrar campos desta tabela? (S/N)");
		if (teclado.readLine().equalsIgnoreCase("S"))
			CriarCampo(teclado, tabela);
	}
}
