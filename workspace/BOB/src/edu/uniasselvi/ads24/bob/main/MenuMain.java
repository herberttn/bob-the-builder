package edu.uniasselvi.ads24.bob.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class MenuMain {

	public static void main(String[] args) throws RuntimeException, IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		int opcaoDesejada = 0;
		System.out.println("---------------|BOB - The constructor|---------------");
		System.out.println("1 - Criar tabela");
		System.out.println("2 - Criar campo");
		System.out.println("3 - Listar tabelas");
		System.out.println("4 - Listar campos");
		System.out.println("5 - Listar scripts");
		
		opcaoDesejada = Integer.parseInt(teclado.readLine());
		
		System.out.println("Opção escolhida: " + opcaoDesejada);
	}

}
