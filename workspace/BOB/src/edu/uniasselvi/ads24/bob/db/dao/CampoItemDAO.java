package edu.uniasselvi.ads24.bob.db.dao;

import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public class CampoItemDAO extends BaseDAO implements IDataAccessObject {
	
	@Override
	public String TableName() {
		return "BOB.Z_CAMPOITENS";
	}

	@Override
	public String TableFields() {
		return "ID, CAMPO, LEGENDA, VALOR";
	}
	
	public boolean CriarTabela() throws DBException {

		return super.CriarTabela(" ID INTEGER NOT NULL PRIMARY KEY, "
					+ " CAMPO INTEGER NOT NULL, "
					+ " LEGENDA VARCHAR(45) NOT NULL, "
					+ " VALOR INTEGER NOT NULL, "
					+ " INDEX BOB.Z_CAMPOITENS.IDX_FK_Z_CAMPOITENS_CAMPO(CAMPO ASC), "
					+ " CONSTRAINT BOB.Z_CAMPOITENS.FK_Z_CAMPOITENS_CAMPO FOREIGN KEY(CAMPO) REFERENCES BOB.Z_CAMPOS(ID) ON DELETE NO ACTION ON UPDATE NO ACTION ");
	}
}
