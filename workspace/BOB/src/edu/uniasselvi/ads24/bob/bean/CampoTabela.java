package edu.uniasselvi.ads24.bob.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uniasselvi.ads24.bob.db.dao.TabelaDAO;
import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.interfaces.IDBCommands;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class CampoTabela extends CampoInteger implements IDataDefinitionLanguage, IDBCommands {
	
	private Tabela tabelaPai;
	
	public CampoTabela() {
		this(-1, null, null, null, false, false, false, false, null);
	}

	public CampoTabela(int ID, String nome, String legenda, Tabela tabela, boolean obrigatorio, boolean chavePrimaria, boolean excluido, boolean integridade, Tabela tabelaPai) {
		super(ID, nome, legenda, tabela, obrigatorio, excluido, chavePrimaria, integridade);
		this.setTabelaPai(tabelaPai);
	}
	
	@Override
	public void loadResultSet(ResultSet resultset)  throws SQLException, DBException {
		super.loadResultSet(resultset);
		TabelaDAO dao = new TabelaDAO();
		this.setTabelaPai(dao.consultar(Tabela.class, resultset.getInt("PESQUISATABELA")));		
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
		return super.ComandoGetTipo();
	}
	
	public Tabela getTabelaPai() {
		return tabelaPai;
	}

	public void setTabelaPai(Tabela tabelaPai) {
		this.tabelaPai = tabelaPai;
	}
}