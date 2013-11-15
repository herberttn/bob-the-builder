package edu.uniasselvi.ads24.bob.enumeradores;

public enum EBusinessExceptions {
	OPCAO_INVALIDA("Op��o inv�lida"),
	VALOR_NAO_NUMERICO("O valor informado n�o � num�rico");
	
	private final String descricaoErro;

	public String getDescricaoErro() {
		return descricaoErro;
	}
	
	private EBusinessExceptions(String descricaoErro) {
		this.descricaoErro = descricaoErro;
	}
}
