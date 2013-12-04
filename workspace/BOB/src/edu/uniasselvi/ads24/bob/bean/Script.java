package edu.uniasselvi.ads24.bob.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class Script extends RegistroBase implements IDataDefinitionLanguage, Serializable {

	private static final long serialVersionUID = 1L;
	
	private int tipo;
	private Date datahora;
	private String comando;
	private String bobversion;
	
	public Script() {
		this(-1, -1, null, null, null);	
	}
	
	public Script(int ID, int tipo, Date datahora, String comando, String bobversion) {
		
		super(ID);
		
		this.setTipo(tipo);
		this.setDatahora(datahora);
		this.setComando(comando);
		this.setBobversion(bobversion);
	}	
	
	@Override
	public void loadFromResultSet(ResultSet resultset) throws SQLException, DBException {
		
		super.loadFromResultSet(resultset);
		
		this.setTipo(resultset.getInt("TIPO"));
		this.setDatahora(resultset.getDate("DATAHORA"));
		this.setComando(resultset.getString("COMANDO"));
		this.setBobversion(resultset.getString("BOBVERSION"));
	}
	
	@Override
	public void loadStatementParams(PreparedStatement preparedStatement) throws SQLException, DBException {
		
		super.loadStatementParams(preparedStatement);
		
		preparedStatement.setInt(2, this.getTipo());
		preparedStatement.setDate(3, new java.sql.Date(this.getDatahora().getTime()));
		preparedStatement.setString(4, this.getComando());
		preparedStatement.setString(5, this.getBobversion());
	}	

	@Override
	public void Salvar() {

		
		// TODO Auto-generated method stub
	}

	@Override
	public void Excluir() {
		// TODO Auto-generated method stub
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Date getDatahora() {
		return datahora;
	}

	public void setDatahora(java.util.Date date) {
		this.datahora = date;
	}

	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}

	public String getBobversion() {
		return bobversion;
	}

	public void setBobversion(String bobversion) {
		this.bobversion = bobversion;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder(super.toString());

		sb.append("\nTipo.....................: ").append(this.getTipo());
		sb.append("\nData/Hora................: ").append(this.getDatahora());
		sb.append("\nComando..................: ").append(this.getComando());
		sb.append("\nVersão do BOB............: ").append(this.getBobversion());
		
		return sb.toString();
	}
}