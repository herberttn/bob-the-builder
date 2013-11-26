package edu.uniasselvi.ads24.bob.interfaces;

import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;

public interface IDBCommands {

	public String ComandoGerar(ETipoGeracao tipoGeracao);
	public String ComandoGetAtributos();
	public String ComandoGetNotNUll();
	public String ComandoGetTipo();
}