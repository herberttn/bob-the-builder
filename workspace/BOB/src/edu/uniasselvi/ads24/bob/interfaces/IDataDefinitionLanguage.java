package edu.uniasselvi.ads24.bob.interfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.exceptions.GeradorComandoDBException;

public interface IDataDefinitionLanguage {

	public void Salvar() throws DBException, GeradorComandoDBException, SQLException;
	public void Excluir() throws DBException, GeradorComandoDBException, SQLException;
	
	public void loadFromResultSet(ResultSet resultset) throws SQLException, DBException;
	public void loadStatementParams(PreparedStatement preparedStatement) throws SQLException, DBException;
}