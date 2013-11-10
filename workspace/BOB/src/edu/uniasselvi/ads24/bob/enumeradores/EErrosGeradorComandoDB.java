package edu.uniasselvi.ads24.bob.enumeradores;

public enum EErrosGeradorComandoDB {

	TIPO_NAO_DEFINIDO("Tipo n�o definido para a gera��o do comando de banco de dados.");

	private final String descricaoErro;

	public String getDescricaoErro() {
		return descricaoErro;
	}

	private EErrosGeradorComandoDB(String descricaoErro) {
		this.descricaoErro = descricaoErro;
	}
}
