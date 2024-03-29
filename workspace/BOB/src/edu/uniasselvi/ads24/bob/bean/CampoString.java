package edu.uniasselvi.ads24.bob.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.interfaces.IDBCommands;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class CampoString extends CampoBase implements IDataDefinitionLanguage, IDBCommands, Serializable {

	private static final long serialVersionUID = 1L;

	private String valorPadrao;
	private int tamanho; // Capacidade de armazenamento do campo string.
	
	public CampoString() {
		this(-1, null, null, null, false, false, false, false, null, -1);
	}

	public CampoString(int ID, String nome, String legenda, Tabela tabela, boolean obrigatorio, boolean chavePrimaria, boolean excluido, boolean integridade, String valorPadrao, int tamanho) {
		
		super(ID, nome, legenda, tabela, obrigatorio, excluido, chavePrimaria, integridade);
		
		this.setTipo(4);

		this.setValorPadrao(valorPadrao);
		this.setTamanho(tamanho);
	}
	
	@Override
	public void loadFromResultSet(ResultSet resultset)  throws SQLException, DBException {
		
		super.loadFromResultSet(resultset);
		
		this.setValorPadrao(resultset.getString("VALORPADRAOSTRING"));
		this.setTamanho(resultset.getInt("TAMANHO"));
	}
	
	@Override
	public void loadStatementParams(PreparedStatement preparedStatement) throws SQLException, DBException {
		
		super.loadStatementParams(preparedStatement);
		
		preparedStatement.setString(9, this.getValorPadrao()); // VALORPADRAOSTRING
		preparedStatement.setInt(15, this.getTamanho()); // TAMANHO
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
		return " VARCHAR(" + getTamanho() + ") ";
	}
	
	public String getValorPadrao() {
		return valorPadrao;
	}

	public void setValorPadrao(String valorPadrao) {
		this.valorPadrao = valorPadrao;
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder(super.toString());

		sb.append("\nValor padr�o.............: ").append(this.getValorPadrao());
		sb.append("\nTamanho..................: ").append(this.getTamanho());

		return sb.toString();
	}
}