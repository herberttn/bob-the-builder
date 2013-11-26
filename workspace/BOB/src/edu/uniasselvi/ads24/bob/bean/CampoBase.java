package edu.uniasselvi.ads24.bob.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uniasselvi.ads24.bob.db.dao.TabelaDAO;
import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.interfaces.IDBCommands;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public abstract class CampoBase extends RegistroBase implements IDataDefinitionLanguage, IDBCommands {

	private String nome;
	private String legenda;
	private Tabela tabela;
	private boolean obrigatorio;
	private boolean excluido;
	private boolean chavePrimaria;
	private boolean integridade;	

	public CampoBase() {
		this(-1, null, null, null, false, false, false, false);
	}

	public CampoBase(int ID, String nome, String legenda, Tabela tabela, boolean obrigatorio, boolean excluido, boolean chavePrimaria, boolean integridade) {
		super(ID);
		this.setNome(nome);
		this.setLegenda(legenda);
		this.setTabela(tabela);
		this.setObrigatorio(obrigatorio);
		this.setExcluido(excluido);
		this.setChavePrimaria(chavePrimaria);
		this.setIntegridade(integridade);
	}
	
	@Override
	public void loadResultSet(ResultSet resultset) throws SQLException, DBException {
		this.setID(resultset.getInt("ID"));
		this.setNome(resultset.getString("NOME"));
		this.setLegenda(resultset.getString("LEGENDA"));
		TabelaDAO dao = new TabelaDAO();
		this.setTabela(dao.consultar(resultset.getInt("TABELA")));
		this.setObrigatorio(resultset.getString("OBRIGATORIO").equals("S"));
		this.setExcluido(resultset.getString("EXCLUIDO").equals("S"));
		this.setChavePrimaria(resultset.getString("EHPK").equals("S"));
		this.setIntegridade(resultset.getString("TEMINTEGRIDADE").equals("S"));
	}
	
	@Override
	public abstract void Criar();

	@Override
	public abstract void Alterar();

	@Override
	public abstract void Excluir();

	@Override
	public String ComandoGerar(ETipoGeracao tipoGeracao) {

		String comando = "ALTER TABLE " + getTabela().getNome().toUpperCase();

		switch (tipoGeracao) {
		case NENHUM:
			return null;

		case CRIACAO:
			comando = comando + " ADD COLUMN " + getNome().toUpperCase()
					+ ComandoGetTipo() 
					+ ComandoGetNotNUll()
					+ ComandoGetAtributos();
			break;

		case ALTERACAO:
			comando = comando + " CHANGE COLUMN " + getNome().toUpperCase()
					+ ComandoGetTipo() 
					+ ComandoGetNotNUll()
					+ ComandoGetAtributos();
			break;

		case EXCLUSAO:
			comando = comando + " DROP COLUMN " + getNome().toUpperCase();
			break;

		default:
			return null;
		}

		return comando;
	}

	@Override
	public String ComandoGetAtributos() {
		return "";
	}

	@Override
	public String ComandoGetNotNUll() {
		if (isObrigatorio())
			return " NOT NULL ";

		return "";
	}

	@Override
	public String ComandoGetTipo() {
		return "";
	}
	
	public Tabela getTabela() {
		return this.tabela;
	}

	public void setTabela(Tabela tabela) {
		this.tabela = tabela;
	}
	
	public void setChavePrimaria(boolean chavePrimaria) {
		this.chavePrimaria = chavePrimaria;
	}

	public boolean getChavePrimaria() {
		return this.chavePrimaria;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLegenda() {
		return this.legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}

	public boolean isObrigatorio() {
		return this.obrigatorio;
	}

	public void setObrigatorio(boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}

	public boolean isExcluido() {
		return excluido;
	}
	
	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
	}
	
	public boolean isIntegridade() {
		return integridade;
	}

	public void setIntegridade(boolean integridade) {
		this.integridade = integridade;
	}	
}