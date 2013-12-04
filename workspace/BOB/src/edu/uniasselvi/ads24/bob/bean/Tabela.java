package edu.uniasselvi.ads24.bob.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import edu.uniasselvi.ads24.bob.db.dao.TabelaDAO;
import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.exceptions.GeradorComandoDBException;
import edu.uniasselvi.ads24.bob.geradores.GeradorComandoDB;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class Tabela extends RegistroBase implements IDataDefinitionLanguage, Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String legenda;
	private boolean porEmpresa;
	private boolean porFilial;

	public Tabela() {
		this(-1, null, null, false, false);
	}

	public Tabela(int ID, String nome, String legenda, boolean porEmpresa, boolean porFilial) {
		
		super(ID);
		
		this.setNome(nome);
		this.setLegenda(legenda);
		this.setPorEmpresa(porEmpresa);
		this.setPorFilial(porFilial);
	}
	
	@Override
	public void loadFromResultSet(ResultSet resultset) throws SQLException, DBException {
		
		super.loadFromResultSet(resultset);
		
		this.setNome(resultset.getString("NOME"));
		this.setLegenda(resultset.getString("LEGENDA"));
		this.setPorEmpresa(resultset.getString("POREMPRESA").equalsIgnoreCase("S"));
		this.setPorFilial(resultset.getString("PORFILIAL").equalsIgnoreCase("S"));	
	}

	@Override
	public void loadStatementParams(PreparedStatement preparedStatement) throws SQLException, DBException {
		
		super.loadStatementParams(preparedStatement);
		
		preparedStatement.setString(2, this.getNome());
		preparedStatement.setString(3, this.getLegenda());
		preparedStatement.setString(4, this.isPorEmpresa() ? "S" : "N");
		preparedStatement.setString(5, this.isPorFilial() ? "S" : "N");
	}	
	
	@Override
	public void Salvar() throws DBException, GeradorComandoDBException {
		
		TabelaDAO tabela = new TabelaDAO();
		
		if (tabela.consultarVarios("NOME = '" + getNome().toUpperCase() + "'", "ID").size() > 0)
			tabela.alterar(this);
		else
			tabela.inserir(this);
		
		GeradorComandoDB gerador = new GeradorComandoDB(ETipoGeracao.CRIACAO, true);
		gerador.GerarEExecutar(this);
	}

	@Override
	public void Excluir() throws DBException, GeradorComandoDBException {
		
		TabelaDAO tabela = new TabelaDAO();
		tabela.excluir(this);
		
		GeradorComandoDB gerador = new GeradorComandoDB(ETipoGeracao.EXCLUSAO, true);
		gerador.GerarEExecutar(this);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLegenda() {
		return legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}

	public boolean isPorEmpresa() {
		return porEmpresa;
	}

	public void setPorEmpresa(boolean porEmpresa) {
		this.porEmpresa = porEmpresa;
	}

	public boolean isPorFilial() {
		return porFilial;
	}

	public void setPorFilial(boolean porFilial) {
		this.porFilial = porFilial;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append("\nNome.....................: ").append(this.getNome());
		sb.append("\nLegenda..................: ").append(this.getLegenda());
		sb.append("\nPor empresa..............: ").append(this.isPorEmpresa() ? "Sim" : "Não");
		sb.append("\nPor filial...............: ").append(this.isPorFilial() ? "Sim" : "Não");
		
		return sb.toString();
	}
}
