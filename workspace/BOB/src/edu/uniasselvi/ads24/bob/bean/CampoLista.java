package edu.uniasselvi.ads24.bob.bean;

import java.util.ArrayList;

public class CampoLista extends CampoInteger {
	private CampoListaItem assumirPadrao;
	private ArrayList<CampoListaItem> itens;

	public CampoLista(int ID, String nome, String legenda, 
			Tabela tabela,
			CampoListaItem assumirPadrao,
			ArrayList<CampoListaItem> itens,
			boolean obrigatorio,
			boolean chavePrimaria, boolean excluido) {
		super.setID(ID);
		super.setNome(nome);
		super.setLegenda(legenda);
		super.setObrigatorio(obrigatorio);
		super.setExcluido(excluido);
		super.setChavePrimaria(chavePrimaria);
		super.setTabela(tabela);		
		
		setAssumirPadrao(assumirPadrao);
		setItens(itens);
	}

	public void setAssumirPadrao(CampoListaItem assumirPadrao) {
		this.assumirPadrao = assumirPadrao;
	}

	public CampoListaItem getAssumirPadrao() {
		return this.assumirPadrao;
	}

	public void setItens(ArrayList<CampoListaItem> itens) {
		this.itens = itens;
	}

	public ArrayList<CampoListaItem> getItens() {
		return this.itens;
	}

}
