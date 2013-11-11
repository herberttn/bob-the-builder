package edu.uniasselvi.ads24.bob.bean;

import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class CampoTabela extends CampoInteger implements IDataDefinitionLanguage {
	
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
	
	public CampoTabela() {
		// TODO Auto-generated constructor stub
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
		return super.ComandoGetTipo();
	}
}