package edu.uniasselvi.ads24.bob.enumeradores;

public enum EErrosDB {
	
	ABRIR_CONEXAO("Falha ao conectar com banco de dados."),
	FECHAR_CONEXAO("Falha ao fechar a conexão com o banco de dados."),
	CRIAR_TABELA("Falha ao criar a tabela no banco de dados."),
	EXCLUIR_TABELA("Falha ao excluir a tabela no banco de dados."),
	INSERIR_DADOS("Falha ao inserir dados na tabela."),
	ROLLBACK("Falha ao executar o rollback."),
	CONSULTAR("Falha ao consultar dados na tabela.");
	
	private final String descricaoErro;

	public String getDescricaoErro() {
		return descricaoErro;
	}
	
	private EErrosDB(String descricaoErro) {
		this.descricaoErro = descricaoErro;
	}
}
