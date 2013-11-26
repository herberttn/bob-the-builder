package edu.uniasselvi.ads24.bob.db.dao;

import java.util.List;
import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.bob.bean.Script;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public class ScriptDAO extends BaseDAO implements IDataAccessObject {
	
	@Override
	public String TableName() {
		return "BOB.Z_SCRIPT";
	}
	
	@Override
	public String TableFields() {
		return "ID, TIPO, DATAHORA, COMANDO, BOBVERSION";
	}	

	public boolean CriarTabela() throws DBException {

		return super.CriarTabela(" ID INTEGER NOT NULL PRIMARY KEY, "
					+ " TIPO INTEGER NOT NULL, "
					+ " DATAHORA DATETIME NOT NULL, "
					+ " COMANDO VARCHAR(2048) NOT NULL, "
					+ " BOBVERSION VARCHAR(15) NOT NULL ");
	}
	
	public Script consultar(int ID) throws DBException {
		return super.consultar(Script.class, ID);
	}
	
	public List<Script> consultarVarios(String where) throws DBException {
		return super.consultarVarios(Script.class, where);
	}
	
	public List<Script> consultarTodos() throws DBException {
		return super.consultarTodos(Script.class);
	}
}
