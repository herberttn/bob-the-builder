package edu.uniasselvi.ads24.bob.testes;

public class TesteLoko {

	public static void main(String[] args) {
		
		Pai obj = new Pai();
		System.out.println(obj.GetComando());
		
		obj = new Filho();
		System.out.println(obj.GetComando());
		
		obj = new Neto();
		System.out.println(obj.GetComando());
	}

}