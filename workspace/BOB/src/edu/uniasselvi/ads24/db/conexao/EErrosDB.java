package edu.uniasselvi.ads24.db.conexao;

public enum EErrosDB {
	
	ABRE_CONEXAO("Falha ao conectar com banco de dados."),
	FECHA_CONEXAO("Falha ao fechar a conexão com o banco de dados.");
	
	private final String descricaoErro;

	public String getDescricaoErro() {
		return descricaoErro;
	}
	
	private EErrosDB(String descricaoErro) {
		this.descricaoErro = descricaoErro;
	}
}
