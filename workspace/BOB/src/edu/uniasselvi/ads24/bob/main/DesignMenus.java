package edu.uniasselvi.ads24.bob.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import edu.uniasselvi.ads24.bob.bean.CampoBase;
import edu.uniasselvi.ads24.bob.bean.CampoDecimal;
import edu.uniasselvi.ads24.bob.bean.CampoInteger;
import edu.uniasselvi.ads24.bob.bean.CampoPK;
import edu.uniasselvi.ads24.bob.bean.CampoString;
import edu.uniasselvi.ads24.bob.bean.CampoTabela;
import edu.uniasselvi.ads24.bob.bean.Script;
import edu.uniasselvi.ads24.bob.bean.Tabela;
import edu.uniasselvi.ads24.bob.db.dao.CampoDAO;
import edu.uniasselvi.ads24.bob.db.dao.ScriptDAO;
import edu.uniasselvi.ads24.bob.db.dao.TabelaDAO;
import edu.uniasselvi.ads24.bob.enumeradores.EBusinessExceptions;
import edu.uniasselvi.ads24.bob.exceptions.BusinessExceptions;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public final class DesignMenus {

	public static int menuPrincipal(BufferedReader teclado) throws BusinessExceptions, IOException {
		
		int opcaoEscolhida = -1;
		
		System.out.println("||=================| BOB - O construtor |=================||");
		System.out.println("|| 1 - Tabelas - Criar                                    ||");
		System.out.println("|| 2 - Tabelas - Excluir                                  ||");
		System.out.println("|| 3 - Tabelas - Listar                                   ||");
		System.out.println("|| 4 - Campos - Criar                                     ||");
		System.out.println("|| 5 - Campos - Excluir                                   ||");
		System.out.println("|| 6 - Campos - Listar                                    ||");
		System.out.println("|| 7 - Scripts - Listar                                   ||");
		System.out.println("|| 8 - Scripts - Importar                                 ||");
		System.out.println("|| 9 - Scripts - Exportar                                 ||");
		System.out.println("|| 0 - Sair                                               ||");
		System.out.println("||________________________________________________________||");

		opcaoEscolhida = TryParseInt(teclado.readLine());

		if ((opcaoEscolhida > 9) || (opcaoEscolhida < 0))
			throw new BusinessExceptions(EBusinessExceptions.OPCAO_INVALIDA);

		return opcaoEscolhida;

	}

	public static Tabela menuCriarTabela(BufferedReader teclado) throws BusinessExceptions, IOException {
		
		Tabela tabela = new Tabela();
		
		System.out.println("||=================| Criação de tabela |==================||");
		System.out.println("|| Informe o nome da tabela                               ||");
		tabela.setNome(teclado.readLine());
		
		System.out.println("|| Informe uma legenda para exibição desta tabela         ||");
		tabela.setLegenda(teclado.readLine());
		
		System.out.println("|| Tabela por empresa? (S/N)                              ||");
		tabela.setPorEmpresa((teclado.readLine().equalsIgnoreCase("S")));
		
		System.out.println("|| Tabela por filial? (S/N)                               ||");
		tabela.setPorFilial((teclado.readLine().equalsIgnoreCase("S")));
		
		return tabela;
	}

	public static int menuOpcoesTipoCampo(BufferedReader teclado) throws BusinessExceptions, IOException {
		
		int opcaoEscolhida = -1;
		
		System.out.println("||==================| Criação de campo |==================||");
		System.out.println("|| Informe o tipo do campo                                ||");
		System.out.println("||    1 - Integer                                         ||");
		System.out.println("||    2 - String                                          ||");
		System.out.println("||    3 - Decimal                                         ||");
		System.out.println("||    4 - PK                                              ||");
		System.out.println("||    5 - Tabela                                          ||");
		System.out.println("||    0 - Sair                                            ||");
		
		opcaoEscolhida = TryParseInt(teclado.readLine());

		if ((opcaoEscolhida > 5) || (opcaoEscolhida < 0))
			throw new BusinessExceptions(EBusinessExceptions.OPCAO_INVALIDA);

		return opcaoEscolhida;
	}

	private static void menuInformarCampoBase(BufferedReader teclado, CampoBase campoBase) throws BusinessExceptions, IOException {
		
		System.out.println("|| Nome do campo                                          ||");
		campoBase.setNome(teclado.readLine());
		
		System.out.println("|| Legenda do campo                                       ||");
		campoBase.setLegenda(teclado.readLine());
		
		System.out.println("|| Este campo deve ser obrigatóriamente preenchido? (S/N) ||");
		campoBase.setObrigatorio((teclado.readLine().equalsIgnoreCase("S")));
		
		System.out.println("|| Este campo é uma chave primária? (S/N)                 ||");
		campoBase.setChavePrimaria((teclado.readLine().equalsIgnoreCase("S")));
	}

	public static CampoInteger menuInformarCampoInteger(BufferedReader teclado) throws BusinessExceptions, IOException {
		
		CampoInteger campoInteger = new CampoInteger();
		
		System.out.println("||=================| Campo tipo Integer |=================||");
		menuInformarCampoBase(teclado, campoInteger);
		
		return campoInteger;
	}

	public static CampoString menuInformarCampoString(BufferedReader teclado) throws BusinessExceptions, IOException {
		
		CampoString campoString = new CampoString();
		
		System.out.println("||=================| Campo tipo String |==================||");
		menuInformarCampoBase(teclado, campoString);
		
		System.out.println("|| Tamanho máximo para o campo                            ||");
		campoString.setTamanho(TryParseInt(teclado.readLine()));
		
		return campoString;
	}

	public static CampoDecimal menuInformarCampoDecimal(BufferedReader teclado) throws BusinessExceptions, IOException {
		
		CampoDecimal campoDecimal = new CampoDecimal();
		
		System.out.println("||=================| Campo tipo Decimal |=================||");
		menuInformarCampoBase(teclado, campoDecimal);
		
		System.out.println("|| Informe o tamanho                                      ||");
		campoDecimal.setTamanho(TryParseInt(teclado.readLine()));
		
		System.out.println("|| Informe a precisão                                     ||");
		campoDecimal.setPrecisaoDecimais(TryParseInt(teclado.readLine()));
		
		return campoDecimal;
	}
	
	public static CampoPK menuInformarCampoPK(BufferedReader teclado) throws BusinessExceptions, IOException {
		
		CampoPK campoPK = new CampoPK();
		
		System.out.println("||===================| Campo tipo PK |====================||");
		menuInformarCampoBase(teclado, campoPK);
		
		return campoPK;
	}

	public static CampoTabela menuInformarCampoTabela(BufferedReader teclado) throws BusinessExceptions, IOException, DBException {
		
		CampoTabela campoTabela = new CampoTabela();
		
		System.out.println("||=================| Campo tipo Tabela |==================||");
		menuInformarCampoBase(teclado, campoTabela);

		System.out.println("|| Escolha a tabela para o relacionamento (FK)            ||");
		campoTabela.setTabelaPai(escolherTabela(teclado));
		
		return campoTabela;
	}

	public static void menuListarTabelas() throws DBException {
		
		TabelaDAO dao = new TabelaDAO();
		List<Tabela> list = dao.consultarTodos("ID");

		if (list.size() <= 0)
			System.out.println("Nenhuma tabela encontrada.");
		else
			System.out.println("ID\t\tNome\t\tLegenda");

		for (Tabela tabela : list) {
			System.out.println(tabela.getID() + "\t\t" + tabela.getNome().toUpperCase() + "\t\t" + tabela.getLegenda());
		}
	}
	
	public static void menuListarCampos() throws DBException {
		
		CampoDAO dao = new CampoDAO();
		List<CampoBase> list = dao.consultarTodos("TABELA, ID");
		
		if (list.size() <= 0)
			System.out.println("Nenhum campo encontrado.");
		else
			System.out.println("ID\t\tTabela\t\tNome\t\tLegenda");

		for (CampoBase campo : list) {
			System.out.println(campo.getID() + "\t\t" + campo.getTabela().getNome().toUpperCase() + "\t\t" + campo.getNome().toUpperCase() + "\t\t" + campo.getLegenda());
		}
	}
	
	public static void menuListarScripts() throws DBException {
		
		ScriptDAO dao = new ScriptDAO();
		List<Script> list = dao.consultarTodos("ID");

		if (list.size() <= 0)
			System.out.println("Nenhum script encontrado.");
		else
			System.out.println("ID\t\tVersão do BOB\t\tData//hora\t\tComando");

		for (Script script : list) {
			System.out.println(script.getID() + "\t\t" + script.getBobversion() + "\t\t" + script.getDatahora() + "\t\t" + script.getComando());
		}
	}
	
	public static Tabela escolherTabela(BufferedReader teclado) throws DBException, BusinessExceptions, IOException {
		
		String likeText = JOptionPane.showInputDialog("Digite o nome da tabela para busca parcial:"); 

		TabelaDAO dao = new TabelaDAO();
		List<Tabela> list = dao.consultarVarios("UPPER(NOME) LIKE '%" + likeText + "%'", "ID");
		
		if (list.size() <= 0)
			JOptionPane.showMessageDialog(null, "Nenhuma tabela encontrada para o filtro informado.");
		else
			System.out.println("ID\t\tNome\t\tLegenda");

		for (Tabela tabela : list) {
			System.out.println(tabela.getID() + "\t\t" + tabela.getNome() + "\t\t" + tabela.getLegenda());
		}
		
		int idEscolhido = 0;
		do {
		
			System.out.println();
			System.out.print("Informe o ID da tabela desejada (ou 0 para sair):");
			idEscolhido = TryParseInt(teclado.readLine());
			
			if (idEscolhido == 0)
				return null;
			
			for (Tabela tabela : list) {
				if (tabela.getID() == idEscolhido)
					return tabela;
			}
			
		} while (idEscolhido != 0);
		
		return null;
	}
	
	public static CampoBase escolherCampo(BufferedReader teclado) throws DBException, BusinessExceptions, IOException {
		
		Tabela tabela = escolherTabela(teclado);
		
		CampoDAO dao = new CampoDAO();
		List<CampoBase> list = dao.consultarVarios("TABELA = " + tabela.getID(), "ID");
		
		if (list.size() <= 0)
			System.out.println("Nenhum campo encontrado nesta tabela.");
		else
			System.out.println("ID\t\tNome\t\tLegenda");

		for (CampoBase campo : list) {
			System.out.println(campo.getID() + "\t\t" + campo.getNome() + "\t\t" + campo.getLegenda());
		}
		
		int idEscolhido = 0;
		do {
		
			System.out.println();
			System.out.print("Informe o ID do campo desejado (ou 0 para sair):");
			idEscolhido = TryParseInt(teclado.readLine());
			
			if (idEscolhido == 0)
				return null;
			
			for (CampoBase campo : list) {
				if (campo.getID() == idEscolhido)
					return campo;
			}
			
		} while (idEscolhido != 0);
		
		return null;
	}
	
	public static String solicitarCaminhoArquivo(BufferedReader teclado) throws IOException {
		
		System.out.println("||===============| Exportação de script |=================||");
		System.out.println("|| Informe o caminho do arquivo a ser criado              ||");
		return teclado.readLine();
	}
	
	public static void limparConsole() {
		
		for (int i = 0; i < 100; ++i)
			System.out.println();
	}

	public static int TryParseInt(String str) throws BusinessExceptions {
		
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			throw new BusinessExceptions(EBusinessExceptions.VALOR_NAO_NUMERICO);
		}
	}
}
