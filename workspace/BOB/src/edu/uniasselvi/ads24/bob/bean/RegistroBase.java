package edu.uniasselvi.ads24.bob.bean;

import java.sql.ResultSet;

public class RegistroBase {

	private int id;
	
	public RegistroBase() {
		this(-1);		
	}
	
	public RegistroBase(int ID) {
		this.setID(ID);
	}
	
	public void loadResultSet(ResultSet resultSet)
	{
		
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
}
