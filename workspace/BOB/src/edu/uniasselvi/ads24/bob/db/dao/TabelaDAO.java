package edu.uniasselvi.ads24.bob.db.dao;

import java.util.List;
import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.bob.bean.Tabela;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public class TabelaDAO extends BaseDAO implements IDataAccessObject {

	@Override
	public String TableName() {
		return "BOB.Z_TABELAS";
	}

	@Override
	public String TableFields() {
		return "ID, NOME, LEGENDA, POREMPRESA, PORFILIAL";
	}

	public boolean CriarTabela() throws DBException {

		return super.CriarTabela(" ID INTEGER NOT NULL PRIMARY KEY, "
				+ " NOME VARCHAR(45) NOT NULL, "
				+ " LEGENDA VARCHAR(250) NOT NULL, "
				+ " POREMPRESA CHAR(1) NOT NULL, "
				+ " PORFILIAL CHAR(1) NOT NULL ");
	}
	
	public Tabela consultar(int ID) throws DBException {
		return super.consultar(Tabela.class, ID);
	}
	
	public List<Tabela> consultarVarios(String where) throws DBException {
		return super.consultarVarios(Tabela.class, where);
	}
	
	public List<Tabela> consultarTodos() throws DBException {
		return super.consultarTodos(Tabela.class);
	}
}