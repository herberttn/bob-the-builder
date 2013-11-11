package edu.uniasselvi.ads24.bob.testes;

public class TesteHeranca {

	public static void main(String[] args) {
		
		TesteHerancaPai obj = new TesteHerancaPai();
		System.out.println(obj.GetComando());
		
		obj = new TesteHerancaFilho();
		System.out.println(obj.GetComando());
		
		obj = new TesteHerancaNeto();
		System.out.println(obj.GetComando());
	}

}