package edu.uniasselvi.ads24.bob.db.dao;

import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
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
}