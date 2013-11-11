package edu.uniasselvi.ads24.bob.bean;

import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class Tabela implements IDataDefinitionLanguage {
	
	private int ID;
	private String nome;
	private String legenda;
	private boolean porEmpresa;
	private boolean porFilial;

	public Tabela() {
		this(-1, "Indeterminado", "Indeterminado", false, false);
	}

	public Tabela(int ID, String nome, String legenda, boolean porEmpresa,
			boolean porFilial) {
		setID(ID);
		setNome(nome);
		setLegenda(legenda);
		setPorEmpresa(porEmpresa);
		setPorFilial(porFilial);
	}

	public void setPorFilial(boolean porFilial) {
		this.porFilial = porFilial;
	}

	public boolean getPorFilial() {
		return this.porFilial;
	}

	public void setPorEmpresa(boolean porEmpresa) {
		this.porEmpresa = porEmpresa;
	}

	public boolean getPorEmpresa() {
		return this.porEmpresa;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}

	public String getLegenda() {
		return this.legenda;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "";
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
		return null;
	}

	@Override
	public String ComandoGetAtributos() {
		return null;
	}

	@Override
	public String ComandoGetNotNUll() {
		return null;
	}

	@Override
	public String ComandoGetTipo() {
		return null;
	}
}
