package edu.uniasselvi.ads24.bob.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uniasselvi.ads24.bob.exceptions.DBException;

public class RegistroBase {

	private int id;
	
	public RegistroBase() {
		this(-1);		
	}
	
	public RegistroBase(int ID) {
		this.setID(ID);
	}
	
	public void loadResultSet(ResultSet resultset)  throws SQLException, DBException {
		
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
}
