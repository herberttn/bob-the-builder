package edu.uniasselvi.ads24.bob.bean;

import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.interfaces.IDBCommands;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class CampoInteger extends CampoBase implements IDataDefinitionLanguage, IDBCommands {

	@Override
	public void Criar() {
		// TODO Auto-generated method stub
	}

	@Override
	public void Alterar() {
		// TODO Auto-generated method stub
	}

	@Override
	public void Excluir() {
		// TODO Auto-generated method stub
	}

	@Override
	public String ComandoGerar(ETipoGeracao tipoGeracao) {
		return super.ComandoGerar(tipoGeracao);
	}

	@Override
	public String ComandoGetAtributos() {
		return super.ComandoGetAtributos();
	}

	@Override
	public String ComandoGetNotNUll() {
		return super.ComandoGetNotNUll();
	}

	@Override
	public String ComandoGetTipo() {
		return " INTEGER ";
	}
}
