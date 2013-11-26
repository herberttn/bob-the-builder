package edu.uniasselvi.ads24.bob.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class Script extends RegistroBase implements IDataDefinitionLanguage {
	
	private int tipo;
	private Date datahora;
	private String comando;
	private String bobversion;
	
	public Script() {
		this(-1, -1, null, null, null);	
	}
	
	public Script(int ID, int tipo, Date datahora, String comando, String bobversion) {
		this.setID(ID);
		this.setTipo(tipo);
		this.setDatahora(datahora);
		this.setComando(comando);
		this.setBobversion(bobversion);
	}	
	
	public Script(ResultSet resultset) throws SQLException {
		this.setID(resultset.getInt("ID"));
		this.setTipo(resultset.getInt("TIPO"));
		this.setDatahora(resultset.getDate("DATAHORA"));
		this.setComando(resultset.getString("COMANDO"));
		this.setBobversion(resultset.getString("BOBVERSION"));
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
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Date getDatahora() {
		return datahora;
	}

	public void setDatahora(Date datahora) {
		this.datahora = datahora;
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
}