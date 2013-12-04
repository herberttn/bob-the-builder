package edu.uniasselvi.ads24.bob.bean;

import java.io.Serializable;

import edu.uniasselvi.ads24.bob.interfaces.IDBCommands;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class CampoPK extends CampoInteger implements IDataDefinitionLanguage, IDBCommands, Serializable {

	private static final long serialVersionUID = 1L;

	public CampoPK() {
		this(-1, null, null, null, false, false, false, false, 0);
	}
	
	public CampoPK(int ID, String nome, String legenda, Tabela tabela, boolean obrigatorio, boolean excluido, boolean chavePrimaria, boolean integridade, int valorPadrao) {
		
		super(ID, nome, legenda, tabela, obrigatorio, excluido, chavePrimaria, integridade, valorPadrao);
		
		this.setTipo(3);
	}
	
	@Override
	public String ComandoGetAtributos() {
		return " PRIMARY KEY ";
	}

	@Override
	public String ComandoGetNotNUll() {
		return super.ComandoGetNotNUll();
	}

	@Override
	public String ComandoGetTipo() {
		return super.ComandoGetTipo();
	}	
	
	@Override
	public String toString() {
		return super.toString();
	}
}