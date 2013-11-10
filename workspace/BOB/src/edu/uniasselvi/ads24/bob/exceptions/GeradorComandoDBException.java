package edu.uniasselvi.ads24.bob.exceptions;

import edu.uniasselvi.ads24.bob.enumeradores.EErrosGeradorComandoDB;


public class GeradorComandoDBException extends Exception {

	private static final long serialVersionUID = 1L;

	public GeradorComandoDBException(EErrosGeradorComandoDB erro) {
		super(erro.getDescricaoErro());
	}
	
	public GeradorComandoDBException(EErrosGeradorComandoDB erro, String mensagem) {
		super(erro.getDescricaoErro() + "#" + mensagem);
	}
}
