package edu.uniasselvi.ads24.bob.enumeradores;

public enum EBusinessExceptions {
	OPCAO_INVALIDA("Opção inválida"),
	VALOR_NAO_NUMERICO("O valor informado não é numérico");
	
	private final String descricaoErro;

	public String getDescricaoErro() {
		return descricaoErro;
	}
	
	private EBusinessExceptions(String descricaoErro) {
		this.descricaoErro = descricaoErro;
	}
}
