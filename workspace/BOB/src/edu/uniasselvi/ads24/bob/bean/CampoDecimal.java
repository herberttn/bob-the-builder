package edu.uniasselvi.ads24.bob.bean;

import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.interfaces.IDBCommands;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class CampoDecimal extends CampoBase implements IDataDefinitionLanguage, IDBCommands {
	
	private int tamanho;
	private int precisaoDecimais; // Número de casas decimais

	public CampoDecimal() {
		this(-1, null, null, null, false, false, false, -1, -1);
	}

	public CampoDecimal(int ID, String nome, String legenda, Tabela tabela, boolean obrigatorio, boolean chavePrimaria, boolean excluido, int tamanho, int precisaoDecimais) {
		this.setID(ID);
		this.setNome(nome);
		this.setLegenda(legenda);
		this.setObrigatorio(obrigatorio);
		this.setExcluido(excluido);
		this.setChavePrimaria(chavePrimaria);
		this.setTabela(tabela);
		this.setTamanho(tamanho);
		this.setPrecisaoDecimais(precisaoDecimais);
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
		return " DECIMAL(" + getTamanho() + ", " + getPrecisaoDecimais() + ") ";
	}
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getPrecisaoDecimais() {
		return this.precisaoDecimais;
	}

	public void setPrecisaoDecimais(int precisaoDecimais) {
		this.precisaoDecimais = precisaoDecimais;
	}
}
