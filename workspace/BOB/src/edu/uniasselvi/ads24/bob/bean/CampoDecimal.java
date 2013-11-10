package edu.uniasselvi.ads24.bob.bean;

public class CampoDecimal extends CampoBase {
	// Número de casas decimais;
	private int precisaoDecimais;

	public CampoDecimal(int ID, int precisaoDecimais, String nome,
			String legenda, Tabela tabela, boolean obrigatorio, boolean chavePrimaria,
			boolean excluido) {
		super.setID(ID);
		super.setNome(nome);
		super.setLegenda(legenda);
		super.setObrigatorio(obrigatorio);
		super.setExcluido(excluido);
		super.setChavePrimaria(chavePrimaria);
		super.setTabela(tabela);
		
		setPrecisaoDecimais(precisaoDecimais);
	}

	public int getPrecisaoDecimais() {
		return this.precisaoDecimais;
	}

	public void setPrecisaoDecimais(int precisaoDecimais) {
		this.precisaoDecimais = precisaoDecimais;
	}

}
