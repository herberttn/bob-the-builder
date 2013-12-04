package edu.uniasselvi.ads24.bob.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uniasselvi.ads24.bob.db.dao.TabelaDAO;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.interfaces.IDBCommands;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class CampoTabela extends CampoInteger implements IDataDefinitionLanguage, IDBCommands, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Tabela tabelaPai;
	
	public CampoTabela() {
		this(-1, null, null, null, false, false, false, false, 0, null);
	}

	public CampoTabela(int ID, String nome, String legenda, Tabela tabela, boolean obrigatorio, boolean chavePrimaria, boolean excluido, boolean integridade, int valorPadrao, Tabela tabelaPai) {
		
		super(ID, nome, legenda, tabela, obrigatorio, excluido, chavePrimaria, integridade, valorPadrao);
		
		this.setTipo(5);

		this.setTabelaPai(tabelaPai);
	}
	
	@Override
	public void loadFromResultSet(ResultSet resultset)  throws SQLException, DBException {
		
		super.loadFromResultSet(resultset);
		
		TabelaDAO dao = new TabelaDAO();
		this.setTabelaPai(dao.consultar(resultset.getInt("PESQUISATABELA")));		
	}	
	
	@Override
	public void loadStatementParams(PreparedStatement preparedStatement) throws SQLException, DBException {
		
		super.loadStatementParams(preparedStatement);
		
		preparedStatement.setInt(12, this.getTabelaPai().getID()); // PESQUISATABELA
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
		return super.ComandoGetTipo();
	}
	
	public Tabela getTabelaPai() {
		return tabelaPai;
	}

	public void setTabelaPai(Tabela tabelaPai) {
		this.tabelaPai = tabelaPai;
	}	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder(super.toString());

		sb.append("\nTabela pai (ID - Nome)...: ").append(this.getTabelaPai().getID() + " - " + this.getTabelaPai().getNome());

		return sb.toString();
	}
}