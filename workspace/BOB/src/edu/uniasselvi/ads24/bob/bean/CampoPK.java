package edu.uniasselvi.ads24.bob.bean;

import edu.uniasselvi.ads24.bob.db.dao.CampoDAO;
import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.interfaces.IDBCommands;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class CampoPK extends CampoInteger implements IDataDefinitionLanguage, IDBCommands {

	public CampoPK() {
		this(-1, null, null, null, false, false, false, false, 0);
	}
	
	public CampoPK(int ID, String nome, String legenda, Tabela tabela, boolean obrigatorio, boolean excluido, boolean chavePrimaria, boolean integridade, int valorPadrao) {
		
		super(ID, nome, legenda, tabela, obrigatorio, excluido, chavePrimaria, integridade, valorPadrao);
	}
	
	@Override
	public void Salvar() throws DBException {
		CampoDAO campo = new CampoDAO();
		if (campo.consultarVarios("NOME = '"+getNome()+"' AND TABELA = " + getTabela().getID()).size() > 0)
			campo.alterar(this);
		else
			campo.inserir(this);		
	}

	@Override
	public void Excluir() throws DBException {
		CampoDAO campo = new CampoDAO();
		campo.excluir(this);
	}

	@Override
	public String ComandoGerar(ETipoGeracao tipoGeracao) {
		return super.ComandoGerar(tipoGeracao);
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