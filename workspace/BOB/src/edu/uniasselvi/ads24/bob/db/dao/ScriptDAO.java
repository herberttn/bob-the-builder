package edu.uniasselvi.ads24.bob.db.dao;

import java.util.List;
import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.bob.bean.Script;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public class ScriptDAO extends BaseDAO implements IDataAccessObject {
	
	@Override
	public String tableName() {
		return "BOB.Z_SCRIPT";
	}
	
	@Override
	public String tableFields() {
		return "ID, TIPO, DATAHORA, COMANDO, BOBVERSION";
	}	

	public boolean criarTabela() throws DBException {

		return super.criarTabela(" ID INTEGER NOT NULL PRIMARY KEY, "
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
	
	public boolean inserir(Script bean) throws DBException {
		return super.inserir(Script.class, bean);
	}
	
	public boolean inserirVarios(List<Script> beanList) throws DBException {
		return super.inserirVarios(Script.class, beanList);
	}
	
	public boolean alterar(Script bean) throws DBException {
		return super.alterar(Script.class, bean);
	}
	
	public boolean excluir(Script bean) throws DBException {
		return super.excluir(Script.class, bean);
	}
}
