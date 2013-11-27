package edu.uniasselvi.ads24.bob.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uniasselvi.ads24.bob.db.dao.CampoDAO;
import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.interfaces.IDBCommands;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class CampoDecimal extends CampoBase implements IDataDefinitionLanguage, IDBCommands {
	
	private double valorPadrao;
	private int tamanho;
	private int precisaoDecimais; // Número de casas decimais

	public CampoDecimal() {
		this(-1, null, null, null, false, false, false, false, 0, -1, -1);
	}

	public CampoDecimal(int ID, String nome, String legenda, Tabela tabela, boolean obrigatorio, boolean chavePrimaria, boolean excluido, boolean integridade, double valorPadrao, int tamanho, int precisaoDecimais) {
		
		super(ID, nome, legenda, tabela, obrigatorio, excluido, chavePrimaria, integridade);
		
		this.setValorPadrao(valorPadrao);
		this.setTamanho(tamanho);
		this.setPrecisaoDecimais(precisaoDecimais);
	}
	
	@Override
	public void loadFromResultSet(ResultSet resultset)  throws SQLException, DBException {
		
		super.loadFromResultSet(resultset);
		
		this.setValorPadrao(resultset.getDouble("VALORPADRAODECIMAL"));
		this.setTamanho(resultset.getInt("TAMANHO"));
		this.setPrecisaoDecimais(resultset.getInt("PRECISAO"));
	}
	
	@Override
	public void loadStatementParams(PreparedStatement preparedStatement) throws SQLException, DBException {
		
		super.loadStatementParams(preparedStatement);
		
		preparedStatement.setDouble(11, this.getValorPadrao()); // VALORPADRAODECIMAL
		preparedStatement.setInt(15, this.getTamanho()); // TAMANHO
		preparedStatement.setInt(16, this.getPrecisaoDecimais()); // PRECISAO
	}	

	@Override
	public void Salvar() throws DBException {
		CampoDAO campo = new CampoDAO();
		if (campo.consultarVarios("NOME = '"+getNome()+"' AND TABELA = " + getTabela().getID()).size() > 0)
			campo.alterar(this);
		else
			campo.inserir(this);		
	}

	@Override
	public void Excluir() throws DBException {
		CampoDAO campo = new CampoDAO();
		campo.excluir(this);
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
	
	public double getValorPadrao() {
		return valorPadrao;
	}

	public void setValorPadrao(double valorPadrao) {
		this.valorPadrao = valorPadrao;
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
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder(super.toString());

		sb.append("\nValor padrão.............: ").append(this.getValorPadrao());
		sb.append("\nTamanho..................: ").append(this.getTamanho());
		sb.append("\nPrecisão.................: ").append(this.getPrecisaoDecimais());

		return sb.toString();
	}
}
