package edu.uniasselvi.ads24.bob.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import edu.uniasselvi.ads24.bob.exceptions.DBException;

public class RegistroBase implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	public RegistroBase() {
		this(-1);		
	}
	
	public RegistroBase(int ID) {
		this.setID(ID);
	}
	
	public void loadFromResultSet(ResultSet resultset)  throws SQLException, DBException {
		this.setID(resultset.getInt("ID"));
	}
	
	public void loadStatementParams(PreparedStatement preparedStatement) throws SQLException, DBException {
		preparedStatement.setInt(1, this.getID()); // ID
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "ID.......................: " + this.getID();
	}
}
