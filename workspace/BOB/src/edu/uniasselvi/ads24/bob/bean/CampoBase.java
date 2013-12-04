package edu.uniasselvi.ads24.bob.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uniasselvi.ads24.bob.db.dao.CampoDAO;
import edu.uniasselvi.ads24.bob.db.dao.TabelaDAO;
import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.exceptions.GeradorComandoDBException;
import edu.uniasselvi.ads24.bob.geradores.GeradorComandoDB;
import edu.uniasselvi.ads24.bob.interfaces.IDBCommands;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class CampoBase extends RegistroBase implements IDataDefinitionLanguage, IDBCommands, Serializable {

	private static final long serialVersionUID = 1L;

	private int tipo;
	private Tabela tabela;
	private String nome;
	private String legenda;
	private boolean obrigatorio;
	private boolean excluido;
	private boolean chavePrimaria;
	private boolean integridade;

	public CampoBase() {
		this(-1, null, null, null, false, false, false, false);
	}

	public CampoBase(int ID, String nome, String legenda, Tabela tabela, boolean obrigatorio, boolean excluido, boolean chavePrimaria, boolean integridade) {
		
		super(ID);
		this.setTipo(0);
				
		this.setNome(nome);
		this.setLegenda(legenda);
		this.setTabela(tabela);
		this.setObrigatorio(obrigatorio);
		this.setExcluido(excluido);
		this.setChavePrimaria(chavePrimaria);
		this.setIntegridade(integridade);
	}

	@Override
	public void loadFromResultSet(ResultSet resultset) throws SQLException, DBException {
		
		super.loadFromResultSet(resultset);
		
		this.setTipo(resultset.getInt("TIPO"));
		this.setNome(resultset.getString("NOME"));
		this.setLegenda(resultset.getString("LEGENDA"));
		TabelaDAO dao = new TabelaDAO();
		this.setTabela(dao.consultar(resultset.getInt("TABELA")));
		this.setObrigatorio(resultset.getString("OBRIGATORIO").equalsIgnoreCase("S"));
		this.setExcluido(resultset.getString("EXCLUIDO").equalsIgnoreCase("S"));
		this.setChavePrimaria(resultset.getString("EHPK").equalsIgnoreCase("S"));
		this.setIntegridade(resultset.getString("TEMINTEGRIDADE").equalsIgnoreCase("S"));
	}
	
	@Override
	public void loadStatementParams(PreparedStatement preparedStatement) throws SQLException, DBException {
		
		super.loadStatementParams(preparedStatement);
		
		preparedStatement.setInt(2, this.getTabela().getID()); // TABELA 
		preparedStatement.setString(3, this.getNome()); // NOME
		preparedStatement.setString(4, this.getLegenda()); // LEGENDA
		preparedStatement.setString(5, this.isObrigatorio() ? "S" : "N"); // OBRIGATORIO
		preparedStatement.setInt(6, this.getTipo()); // TIPO
		preparedStatement.setString(7, this.isExcluido() ? "S" : "N"); // EXCLUIDO
		preparedStatement.setNull(8, java.sql.Types.INTEGER); // VALORPADRAOINTEGER
		preparedStatement.setNull(9, java.sql.Types.VARCHAR); // VALORPADRAOSTRING
		preparedStatement.setNull(10, java.sql.Types.DATE); // VALORPADRAODATETIME
		preparedStatement.setNull(11, java.sql.Types.DECIMAL); // VALORPADRAODECIMAL
		preparedStatement.setNull(12, java.sql.Types.INTEGER); // PESQUISATABELA
		preparedStatement.setString(13, "N"); // EHPK
		preparedStatement.setString(14, this.isIntegridade() ? "S" : "N"); // TEMINTEGRIDADE
		preparedStatement.setNull(15, java.sql.Types.INTEGER); // TAMANHO
		preparedStatement.setNull(16, java.sql.Types.INTEGER); // PRECISAO
	}	
	
	@Override
	public void Salvar() throws DBException, GeradorComandoDBException, SQLException {
		
		CampoDAO dao = new CampoDAO();
		dao.resetSavepoint();
		
		GeradorComandoDB gerador = new GeradorComandoDB(ETipoGeracao.CRIACAO, true);
		gerador.GerarEExecutar(this);
		
		if (dao.consultarVarios("NOME = '" + getNome().toUpperCase() + "' AND TABELA = " + getTabela().getID(), "ID").size() > 0)
			dao.alterar(this);
		else
			dao.inserir(this);
	}
	
	@Override
	public void Excluir() throws DBException, GeradorComandoDBException, SQLException {
		
		CampoDAO dao = new CampoDAO();
		dao.resetSavepoint();
		
		GeradorComandoDB gerador = new GeradorComandoDB(ETipoGeracao.EXCLUSAO, true);
		gerador.GerarEExecutar(this);
		
		dao.excluir(this);
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
	
	public int getTipo() {
		return tipo;
	}

	protected void setTipo(int tipo) {
		this.tipo = tipo;
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

	public boolean isChavePrimaria() {
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
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder(super.toString());

		sb.append("\nTabela (ID - Nome).......: ").append(this.getTabela().getID() + " - " + this.getTabela().getNome());
		sb.append("\nNome.....................: ").append(this.getNome());
		sb.append("\nLegenda..................: ").append(this.getLegenda());
		sb.append("\nObrigatório..............: ").append(this.isObrigatorio() ? "Sim" : "Não");
		sb.append("\nExcluído.................: ").append(this.isExcluido() ? "Sim" : "Não");
		sb.append("\nChave primária...........: ").append(this.isChavePrimaria() ? "Sim" : "Não");
		sb.append("\nTem integridade..........: ").append(this.isIntegridade() ? "Sim" : "Não");
		
		return sb.toString();
	}	
}