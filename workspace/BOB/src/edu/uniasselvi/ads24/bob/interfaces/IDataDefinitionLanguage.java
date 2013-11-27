package edu.uniasselvi.ads24.bob.interfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public interface IDataDefinitionLanguage {

	public abstract void Salvar() throws DBException;
	public abstract void Excluir() throws DBException;
	
	public void loadFromResultSet(ResultSet resultset) throws SQLException, DBException;
	public void loadStatementParams(PreparedStatement preparedStatement) throws SQLException, DBException;
}