package edu.uniasselvi.ads24.bob.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.uniasselvi.ads24.bob.bean.CampoBase;
import edu.uniasselvi.ads24.bob.bean.CampoDecimal;
import edu.uniasselvi.ads24.bob.bean.CampoInteger;
import edu.uniasselvi.ads24.bob.bean.CampoString;
import edu.uniasselvi.ads24.bob.bean.Tabela;
import edu.uniasselvi.ads24.bob.exceptions.BusinessExceptions;

public final class MenuMain {

	public static void main(String[] args) throws BusinessExceptions,
			IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));

		int opcaoDesejada = DesignMenus.menuPrincipal(teclado);
		while (opcaoDesejada > 0) {
			switch (opcaoDesejada) {
			case 1:
				DesignMenus.limparConsole();
				CriarTabela(teclado);
				break;
			case 2:
				DesignMenus.limparConsole();
				break;
			default:
				break;
			}
			opcaoDesejada = DesignMenus.menuPrincipal(teclado);
		}
	}

	private static void CriarCampo(BufferedReader teclado, Tabela tabela)
			throws BusinessExceptions, IOException {
		int opcaoEscolhida = DesignMenus.menuOpcoesTipoCampo(teclado);

		switch (opcaoEscolhida) {
		case 1:
			CampoInteger campoInteger = DesignMenus
					.menuInformarCampoInteger(teclado);
			campoInteger.setTabela(tabela);
			break;
		case 2:
			CampoString campoString = DesignMenus
					.menuInformarCampoString(teclado);
			campoString.setTabela(tabela);
			break;
		case 3:
			CampoDecimal campoDecimal = DesignMenus
					.menuInformarCampoDecimal(teclado);
			campoDecimal.setTabela(tabela);
			break;
		default:
			break;
		}

	}

	private static void CriarTabela(BufferedReader teclado)
			throws BusinessExceptions, IOException {

		Tabela tabela = DesignMenus.menuCriarTabela(teclado);
		System.out.println("Deseja cadastrar campos desta tabela?(S/N)");
		if (teclado.readLine().equalsIgnoreCase("S")) {
			CriarCampo(teclado, tabela);
		}
	}

}
