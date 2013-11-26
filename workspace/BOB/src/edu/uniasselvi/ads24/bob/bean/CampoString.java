package edu.uniasselvi.ads24.bob.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.interfaces.IDBCommands;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class CampoString extends CampoBase implements IDataDefinitionLanguage, IDBCommands {

	private int tamanho; // Capacidade de armazenamento do campo string.
	
	public CampoString() {
		this(-1, null, null, null, false, false, false, false, -1);
	}

	public CampoString(int ID, String nome, String legenda, Tabela tabela, boolean obrigatorio, boolean chavePrimaria, boolean excluido, boolean integridade, int tamanho) {
		super(ID, nome, legenda, tabela, obrigatorio, excluido, chavePrimaria, integridade);
		this.setTamanho(tamanho);
	}
	
	@Override
	public void loadResultSet(ResultSet resultset)  throws SQLException, DBException {
		super.loadResultSet(resultset);
		this.setTamanho(resultset.getInt("TAMANHO"));
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
		return " VARCHAR(" + getTamanho() + ") ";
	}
	
	public int getTamanho() {
		return this.tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
}