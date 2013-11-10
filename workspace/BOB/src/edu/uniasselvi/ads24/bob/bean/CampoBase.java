package edu.uniasselvi.ads24.bob.bean;

import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class CampoBase implements IDataDefinitionLanguage{
	private int id;
	private String nome;
	private String legenda;
	private Tabela tabela;
	private boolean obrigatorio;
	private boolean excluido;
	private boolean chavePrimaria;

	public Tabela getTabela()
	{
		return this.tabela;
	}
	
	public void setTabela( Tabela tabela )
	{
		this.tabela = tabela;
	}

	public CampoBase(int ID, String nome, String legenda, Tabela tabela, boolean obrigatorio,
			boolean excluido, boolean chavePrimaria) {
		setID(ID);
		setNome(nome);
		setLegenda(legenda);
		setObrigatorio(obrigatorio);
		setExcluido(excluido);
		setChavePrimaria(chavePrimaria);
		setTabela(tabela);
	}
	
	public CampoBase() {
		this(-1, "Indefinido", "Indefinido", null, false, false, false);
	}

	public void setChavePrimaria(boolean chavePrimaria) {
		this.chavePrimaria = chavePrimaria;
	}

	public boolean getChavePrimaria() {
		return this.chavePrimaria;
	}

	public int getID() {
		return this.id;
	}

	public void setID(int ID) {
		this.id = ID;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLegenda() {
		return this.legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}

	public boolean getObrigatorio() {
		return this.obrigatorio;
	}

	public void setObrigatorio(boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}

	public boolean getExcluido() {
		return excluido;
	}

	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
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

}
