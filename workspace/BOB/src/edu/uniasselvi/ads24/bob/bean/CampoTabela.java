package edu.uniasselvi.ads24.bob.bean;

public class CampoTabela extends CampoInteger {
	private Tabela tabela;
	private boolean integridade;
	
	public CampoTabela(int ID, Tabela tabela, String nome,
			String legenda, Tabela tabelaPai, boolean integridade, boolean obrigatorio, boolean chavePrimaria,
			boolean excluido) {
		super.setID(ID);
		super.setNome(nome);
		super.setLegenda(legenda);
		super.setObrigatorio(obrigatorio);
		super.setExcluido(excluido);
		super.setChavePrimaria(chavePrimaria);
		super.setTabela(tabelaPai);

		SetTabela(tabela);
		setIntegridade(integridade);
	}
	
	public void setIntegridade(boolean integridade)
	{
		this.integridade = integridade;
	}
	
	public boolean getIntegridade()
	{
		return this.integridade;
	}
	
	public Tabela getTabela()
	{
		return this.tabela;
	}
	public void SetTabela(Tabela tabela)
	{
		this.tabela = tabela;
	}
	

}
