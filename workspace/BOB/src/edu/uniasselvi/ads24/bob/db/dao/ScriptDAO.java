package edu.uniasselvi.ads24.bob.db.dao;

import java.sql.Connection;
import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.db.conexao.Conexao;

public class ScriptDAO extends BaseDAO implements IDataAccessObject {
	
	@Override
	public String TableName() {
		return "BOB.Z_SCRIPT";
	}

	public boolean CriarTabela() throws DBException {

		return super.CriarTabela(" ID INTEGER NOT NULL PRIMARY KEY, "
					+ " TIPO INTEGER NOT NULL, "
					+ " DATAHORA DATETIME NOT NULL, "
					+ " COMANDO VARCHAR(2048) NOT NULL, "
					+ " BOBVERSION VARCHAR(15) NOT NULL ");
	}
}
