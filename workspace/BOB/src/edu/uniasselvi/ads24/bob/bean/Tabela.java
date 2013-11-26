package edu.uniasselvi.ads24.bob.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class Tabela extends RegistroBase implements IDataDefinitionLanguage {
	
	private String nome;
	private String legenda;
	private boolean porEmpresa;
	private boolean porFilial;

	public Tabela() {
		this(-1, null, null, false, false);
	}

	public Tabela(int ID, String nome, String legenda, boolean porEmpresa, boolean porFilial) {
		this.setID(ID);
		this.setNome(nome);
		this.setLegenda(legenda);
		this.setPorEmpresa(porEmpresa);
		this.setPorFilial(porFilial);
	}
	
	public Tabela(ResultSet resultset) throws SQLException {
		this.setID(resultset.getInt("ID"));
		this.setNome(resultset.getString("NOME"));
		this.setLegenda(resultset.getString("LEGENDA"));
		this.setPorEmpresa(resultset.getString("POREMPRESA").equals("S"));
		this.setPorFilial(resultset.getString("PORFILIAL").equals("S"));		
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
}
