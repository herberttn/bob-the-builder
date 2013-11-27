package edu.uniasselvi.ads24.bob.interfaces;

import edu.uniasselvi.ads24.bob.exceptions.DBException;

public interface IDataAccessObject {

	public abstract String tableName();
	public abstract String tableFields();
	
	public abstract boolean criarTabela() throws DBException;
	
	public boolean criarTabela(String statement) throws DBException;
	public boolean excluirTabela() throws DBException;
}