package edu.uniasselvi.ads24.bob.bean;

import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.interfaces.IDBCommands;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class CampoTabela extends CampoInteger implements IDataDefinitionLanguage, IDBCommands {
	
	private Tabela tabelaPai;
	
	public CampoTabela() {
		this(-1, null, null, null, false, false, false, null, false);
		
	}

	public CampoTabela(int ID, String nome, String legenda, Tabela tabela, boolean obrigatorio, boolean chavePrimaria, boolean excluido, Tabela tabelaPai, boolean integridade) {
		this.setID(ID);
		this.setNome(nome);
		this.setTabela(tabela);		
		this.setLegenda(legenda);
		this.setObrigatorio(obrigatorio);
		this.setExcluido(excluido);
		this.setChavePrimaria(chavePrimaria);
		this.setTabelaPai(tabelaPai);
		this.setIntegridade(integridade);
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
	
	public boolean getIntegridade()
	{
		return this.integridade;
	}
	
	public void setIntegridade(boolean integridade)
	{
		this.integridade = integridade;
	}
	
	public Tabela getTabelaPai() {
		return tabelaPai;
	}

	public void setTabelaPai(Tabela tabelaPai) {
		this.tabelaPai = tabelaPai;
	}
}