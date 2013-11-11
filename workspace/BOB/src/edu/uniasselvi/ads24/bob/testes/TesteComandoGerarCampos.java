package edu.uniasselvi.ads24.bob.testes;

import edu.uniasselvi.ads24.bob.bean.*;
import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;

public class TesteComandoGerarCampos {

	public static void main(String[] args) {
		
		DoCampo(new CampoDecimal());
		DoCampo(new CampoInteger());
		DoCampo(new CampoPK());
		DoCampo(new CampoString());
		DoCampo(new CampoTabela());
	}
	
	private static void DoCampo(CampoBase campo) {
		
		System.out.println("");
		System.out.println(campo.getClass().getSimpleName());
		
		campo.setTabela(new Tabela(1, campo.getClass().getSimpleName() + "_TABELA", campo.getClass().getName(), true, false));
		campo.setNome(campo.getClass().getSimpleName() + "_CAMPO");
		
		System.out.println(campo.ComandoGerar(ETipoGeracao.NENHUM));
		System.out.println(campo.ComandoGerar(ETipoGeracao.CRIACAO));
		System.out.println(campo.ComandoGerar(ETipoGeracao.ALTERACAO));
		System.out.println(campo.ComandoGerar(ETipoGeracao.EXCLUSAO));
	}
}
