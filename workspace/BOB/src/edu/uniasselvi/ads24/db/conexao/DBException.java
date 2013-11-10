package edu.uniasselvi.ads24.db.conexao;

public class DBException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DBException(EErrosDB erro, String mensagem) {
		super(erro.getDescricaoErro() + "#" + mensagem);
	}
}
