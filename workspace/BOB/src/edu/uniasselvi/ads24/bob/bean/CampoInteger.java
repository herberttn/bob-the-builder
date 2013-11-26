package edu.uniasselvi.ads24.bob.bean;

import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.interfaces.IDBCommands;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class CampoInteger extends CampoBase implements IDataDefinitionLanguage, IDBCommands {

	public CampoInteger() {
		this(-1, null, null, null, false, false, false, false);
	}
	
	public CampoInteger(int ID, String nome, String legenda, Tabela tabela, boolean obrigatorio, boolean excluido, boolean chavePrimaria, boolean integridade) {
		super(ID, nome, legenda, tabela, obrigatorio, excluido, chavePrimaria, integridade);
	}

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
