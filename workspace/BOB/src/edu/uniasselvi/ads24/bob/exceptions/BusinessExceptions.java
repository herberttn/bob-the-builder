package edu.uniasselvi.ads24.bob.exceptions;

import edu.uniasselvi.ads24.bob.enumeradores.EBusinessExceptions;

public class BusinessExceptions extends Exception {

	private static final long serialVersionUID = 1L;
	
	public BusinessExceptions(EBusinessExceptions erro)
	{
		super(erro.getDescricaoErro());
	}
	public BusinessExceptions(EBusinessExceptions erro, String mensagem)
	{
		super(erro.getDescricaoErro() + "#" + mensagem);
	}
}
