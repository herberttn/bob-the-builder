package edu.uniasselvi.ads24.bob.db.dao;

import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public class FilialDAO extends BaseDAO implements IDataAccessObject {
	
	@Override
	public String TableName() {
		return "BOB.FILIAIS";
	}

	@Override
	public String TableFields() {
		return "ID, EMPRESA, NOME, CNPJ";
	}
	
	public boolean CriarTabela() throws DBException {

		return super.CriarTabela(" ID INTEGER NOT NULL PRIMARY KEY, "
					+ " EMPRESA INTEGER, "
					+ " NOME VARCHAR(100) NOT NULL, "
					+ " CNPJ VARCHAR(14) NOT NULL, "
					+ " INDEX BOB.FILIAIS.IDX_FK_FILIAIS_EMPRESA(EMPRESA ASC), "
					+ " CONSTRAINT BOB.FILIAIS.FK_FILIAIS_EMPRESA FOREIGN KEY(EMPRESA) REFERENCES BOB.EMPRESAS(ID) ON DELETE NO ACTION ON UPDATE NO ACTION ");
	}
}
