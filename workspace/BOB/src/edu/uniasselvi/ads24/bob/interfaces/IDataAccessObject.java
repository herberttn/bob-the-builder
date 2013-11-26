package edu.uniasselvi.ads24.bob.interfaces;

import java.util.List;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public interface IDataAccessObject {

	public abstract String TableName();
	public abstract boolean CriarTabela() throws DBException;
	
	public boolean CriarTabela(String statement) throws DBException;
	public boolean ExcluirTabela() throws DBException;
	
	public <T> T consultar(int ID) throws DBException;
	public <T> List<T> consultarTodos() throws DBException;
}