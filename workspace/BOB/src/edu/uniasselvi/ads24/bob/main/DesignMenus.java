package edu.uniasselvi.ads24.bob.main;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uniasselvi.ads24.bob.bean.CampoBase;
import edu.uniasselvi.ads24.bob.bean.CampoDecimal;
import edu.uniasselvi.ads24.bob.bean.CampoInteger;
import edu.uniasselvi.ads24.bob.bean.CampoString;
import edu.uniasselvi.ads24.bob.bean.Tabela;
import edu.uniasselvi.ads24.bob.db.dao.TabelaDAO;
import edu.uniasselvi.ads24.bob.enumeradores.EBusinessExceptions;
import edu.uniasselvi.ads24.bob.exceptions.BusinessExceptions;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public final class DesignMenus {

	public static int menuPrincipal(BufferedReader teclado)
			throws BusinessExceptions, IOException {
		int opcaoEscolhida = -1;
		System.out
				.println("==================|BOB - The constructor|==================");
		System.out
				.println("|| 1 - Criar tabela                                      ||");
		System.out
				.println("|| 2 - Criar campo                                       ||");
		System.out
				.println("|| 3 - Listar tabelas                                    ||");
		System.out
				.println("|| 4 - Listar campos                                     ||");
		System.out
				.println("|| 5 - Listar scripts                                    ||");
		System.out
				.println("|| 0 - Sair                                              ||");
		System.out
				.println("||_______________________________________________________||");

		opcaoEscolhida = TryParseInt(teclado.readLine());

		if (opcaoEscolhida > 5)
			throw new BusinessExceptions(EBusinessExceptions.OPCAO_INVALIDA);

		return opcaoEscolhida;

	}

	public static Tabela menuCriarTabela(BufferedReader teclado)
			throws BusinessExceptions, IOException {
		Tabela tabela = new Tabela();
		System.out
				.println("==================|Criação TABELA|==================");
		System.out
				.println("|| Informe o nome da tabela                       ||");
		tabela.setNome(teclado.readLine());
		System.out
				.println("|| Informe uma legenda para exibição desta tabela ||");
		tabela.setLegenda(teclado.readLine());
		System.out
				.println("|| Tabela por EMPRESA(S/N)                        ||");

		tabela.setPorEmpresa((teclado.readLine().equalsIgnoreCase("S")));
		System.out
				.println("|| Tabela por FILIAL(S/N)                         ||");
		tabela.setPorFilial((teclado.readLine().equalsIgnoreCase("S")));
		return tabela;
	}

	public static int menuOpcoesTipoCampo(BufferedReader teclado)
			throws BusinessExceptions, IOException {
		int opcaoEscolhida = -1;
		System.out
				.println("==================|Criação Campo|==================");
		System.out
				.println("||Informe o tipo do campo                        ||");
		System.out
				.println("|| 1 - Integer                                   ||");
		System.out
				.println("|| 2 - String                                    ||");
		System.out
				.println("|| 3 - Decimal                                   ||");
		System.out
				.println("|| 4 - PK                                        ||");
		System.out
				.println("|| 5 - Tabela                                    ||");
		
		opcaoEscolhida = TryParseInt(teclado.readLine());

		if (opcaoEscolhida > 5)
			throw new BusinessExceptions(EBusinessExceptions.OPCAO_INVALIDA);

		return opcaoEscolhida;
	}

	private static void menuInformarCampoBase(BufferedReader teclado,
			CampoBase campoBase) throws BusinessExceptions, IOException {
		System.out
				.println("|| Informe um código único                       ||");
		campoBase.setID(TryParseInt(teclado.readLine()));
		System.out
				.println("|| Nome do campo                                 ||");
		campoBase.setNome(teclado.readLine());
		System.out
				.println("|| Legenda do campo                              ||");
		campoBase.setLegenda(teclado.readLine());
		System.out
				.println("|| Este campo deve ser obrigatóriamente preenchido?(S/N)");
		campoBase.setObrigatorio((teclado.readLine().equalsIgnoreCase("S")));
		System.out
				.println("|| Este campo é uma chave primária?(S/N)         ||");
		campoBase.setChavePrimaria((teclado.readLine().equalsIgnoreCase("S")));
	}

	public static CampoInteger menuInformarCampoInteger(BufferedReader teclado)
			throws BusinessExceptions, IOException {
		CampoInteger campoInteger = new CampoInteger();
		System.out
				.println("==================|Campo Integer|==================");
		menuInformarCampoBase(teclado, campoInteger);
		return campoInteger;
	}

	public static CampoString menuInformarCampoString(BufferedReader teclado)
			throws BusinessExceptions, IOException {
		CampoString campoString = new CampoString();
		System.out
				.println("==================|Campo String |==================");
		menuInformarCampoBase(teclado, campoString);
		System.out
				.println("|| Tamanho máximo para o campo                   ||");
		campoString.setTamanho(TryParseInt(teclado.readLine()));
		return campoString;
	}

	public static CampoDecimal menuInformarCampoDecimal(BufferedReader teclado)
			throws BusinessExceptions, IOException {
		CampoDecimal campoDecimal = new CampoDecimal();
		System.out
				.println("==================|Campo Decimal|==================");
		menuInformarCampoBase(teclado, campoDecimal);
		System.out
				.println("|| Informe a quantidade de casas decimais        ||");
		campoDecimal.setPrecisaoDecimais(TryParseInt(teclado.readLine()));
		return campoDecimal;
	}
	public static String menuListarTabelas() throws DBException
	{
		TabelaDAO tabelas = new TabelaDAO();
		List<Tabela> listTabelas;
		listTabelas = tabelas.consultarVarios("1=1");
		System.out.println("abc");
		for (Tabela tabela : listTabelas) {
			System.out.println("abc2");
			System.out.println(tabela.toString());			
		}
		
		return "";
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
