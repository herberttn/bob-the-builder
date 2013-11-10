package edu.uniasselvi.ads24.db.conexao;

public class BancoDadosException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public BancoDadosException(EErrosBancoDados erro, String mensagem) {
		super(erro.getDescricaoErro() + "#" + mensagem);
	}
}
