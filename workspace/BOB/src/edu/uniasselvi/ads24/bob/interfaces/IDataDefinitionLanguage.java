package edu.uniasselvi.ads24.bob.interfaces;

import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;

public interface IDataDefinitionLanguage {

	public abstract void Criar();
	public abstract void Alterar();
	public abstract void Excluir();
	
	public String ComandoGerar(ETipoGeracao tipoGeracao);
	public String ComandoGetAtributos();
	public String ComandoGetNotNUll();
	public String ComandoGetTipo();
}