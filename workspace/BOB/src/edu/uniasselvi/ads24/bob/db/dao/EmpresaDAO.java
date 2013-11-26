package edu.uniasselvi.ads24.bob.db.dao;

import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public class EmpresaDAO extends BaseDAO implements IDataAccessObject {
	
	@Override
	public String TableName() {
		return "BOB.EMPRESAS";
	}

	@Override
	public String TableFields() {
		return "ID, NOME, CNPJ";
	}
		
	public boolean CriarTabela() throws DBException {

		return super.CriarTabela(" ID INTEGER NOT NULL PRIMARY KEY, "
					+ " NOME VARCHAR(100) NOT NULL, "
					+ " CNPJ VARCHAR(14) NOT NULL ");
	}
}