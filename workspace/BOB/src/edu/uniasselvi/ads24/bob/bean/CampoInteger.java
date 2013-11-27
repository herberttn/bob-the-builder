package edu.uniasselvi.ads24.bob.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.interfaces.IDBCommands;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class CampoInteger extends CampoBase implements IDataDefinitionLanguage, IDBCommands {
	
	private int valorPadrao;

	public CampoInteger() {
		this(-1, null, null, null, false, false, false, false, 0);
	}
	
	public CampoInteger(int ID, String nome, String legenda, Tabela tabela, boolean obrigatorio, boolean excluido, boolean chavePrimaria, boolean integridade, int valorPadrao) {
		
		super(ID, nome, legenda, tabela, obrigatorio, excluido, chavePrimaria, integridade);
		
		this.setValorPadrao(valorPadrao);
	}
	
	@Override
	public void loadFromResultSet(ResultSet resultset)  throws SQLException, DBException {
		
		super.loadFromResultSet(resultset);
		
		this.setValorPadrao(resultset.getInt("VALORPADRAOINTEGER"));
	}
	
	@Override
	public void loadStatementParams(PreparedStatement preparedStatement) throws SQLException, DBException {
		
		super.loadStatementParams(preparedStatement);
		
		preparedStatement.setInt(8, this.getValorPadrao()); // VALORPADRAOINTEGER
	}

	@Override
	public void Salvar() {
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
		return " INTEGER ";
	}

	public int getValorPadrao() {
		return valorPadrao;
	}

	public void setValorPadrao(int valorPadrao) {
		this.valorPadrao = valorPadrao;
	}	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder(super.toString());

		sb.append("\nValor padrão.............: ").append(this.getValorPadrao());

		return sb.toString();
	}
}
