package edu.uniasselvi.ads24.bob.testes;

public class TesteHerancaFilho extends TesteHerancaPai {
	
	@Override
	public String GetComando() {
		return super.GetComando() + ", do filho";
	}
}
