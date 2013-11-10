package edu.uniasselvi.ads24.bob.bean;

public class CampoString extends CampoBase {
	//Capacidade de armazenamento do campo string.
	private int tamanho;
	
	public CampoString(int ID, int tamanho, String nome,
			String legenda, boolean obrigatorio, boolean chavePrimaria,
			boolean excluido) {
		super.setID(ID);
		super.setNome(nome);
		super.setLegenda(legenda);
		super.setObrigatorio(obrigatorio);
		super.setExcluido(excluido);
		super.setChavePrimaria(chavePrimaria);
		
		setTamanho(tamanho);
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

}
