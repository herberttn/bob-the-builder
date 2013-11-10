package edu.uniasselvi.ads24.bob.testes;

public class Filho extends Pai {
	
	@Override
	public String GetComando() {
		return super.GetComando() + ", do filho";
	}
}
