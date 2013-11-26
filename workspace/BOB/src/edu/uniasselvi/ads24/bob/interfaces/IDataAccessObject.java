package edu.uniasselvi.ads24.bob.interfaces;

import edu.uniasselvi.ads24.bob.exceptions.DBException;

public interface IDataAccessObject {

	public abstract String TableName();
	public abstract String TableFields();
	public abstract boolean CriarTabela() throws DBException;
	
	public boolean CriarTabela(String statement) throws DBException;
	public boolean ExcluirTabela() throws DBException;
}