package edu.uniasselvi.ads24.bob.main;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.uniasselvi.ads24.bob.bean.Tabela;

public final class MenuMain {

	public static void main(String[] args) throws RuntimeException, IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));

		int opcaoDesejada = menuPrincipal(teclado);

		switch (opcaoDesejada) {
		case 1:
			limparConsole();
			menuCriarTabela(teclado);

			break;
		case 2:
			limparConsole();

			break;
		default:
			break;
		}
		menuPrincipal(teclado);
	}

	private static String menuCriarCampo(BufferedReader teclado) {
		return "";
	}

	private static String menuCriarCampo(BufferedReader teclado, Tabela tabela) throws RuntimeException, IOException {
		int opcaoEscolhida = -1; 
		System.out.println("---------------|Criação CAMPO|---------------");
		System.out.println("Informe o tipo do campo");
		System.out.println("1 - Integer ");
		System.out.println("2 - String ");
		System.out.println("3 - Decimal ");
		System.out.println("4 - Lista ");
		System.out.println("5 - PK ");
		System.out.println("6 - Tabela ");
		opcaoEscolhida = Integer.parseInt(teclado.readLine());
		
		return "";
	}

	private static String menuCriarTabela(BufferedReader teclado)
			throws IOException {
		Tabela tabela = new Tabela();
		System.out.println("---------------|Criação TABELA|---------------");
		System.out.println("Informe o nome da tabela: ");
		tabela.setNome(teclado.readLine());
		System.out.println("Informe uma legenda para exibição desta tabela: ");
		tabela.setLegenda(teclado.readLine());
		System.out.print("Está tabela é por EMPRESA(S/N): ");
		tabela.setPorEmpresa((teclado.readLine() == "S"));
		System.out.print("Está tabela é por FILIAL(S/N): ");
		tabela.setPorFilial((teclado.readLine() == "S"));

		System.out.print("Deseja criar os campos desta tabela(S/N)?");
		if (teclado.readLine() == "S") {
			menuCriarCampo(teclado, tabela);
		}

		return "Tabela criada com sucesso!";
	}

	private static int menuPrincipal(BufferedReader teclado) {
		System.out
				.println("---------------|BOB - The constructor|---------------");
		System.out.println("1 - Criar tabela");
		System.out.println("2 - Criar campo");
		System.out.println("3 - Listar tabelas");
		System.out.println("4 - Listar campos");
		System.out.println("5 - Listar scripts");
		int opcaoEscolhida = -1;
		try {
			opcaoEscolhida = Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException | IOException e) {
			limparConsole();
			System.out.println("Opção inválida, informe um número de 1 a 5!");
			System.out.println();
			opcaoEscolhida = menuPrincipal(teclado);
		}

		return opcaoEscolhida;
	}

	private static void limparConsole() {
		for (int i = 0; i < 100; ++i)
			System.out.println();
	}

}
