package edu.uniasselvi.ads24.bob.db.dao;

import java.util.List;
import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.bob.bean.Tabela;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public class TabelaDAO extends BaseDAO implements IDataAccessObject {

	@Override
	public String tableName() {
		return "BOB.Z_TABELAS";
	}

	@Override
	public String tableFields() {
		return "ID, NOME, LEGENDA, POREMPRESA, PORFILIAL";
	}

	public boolean criarTabela() throws DBException {

		return super.criarTabela(" ID INTEGER NOT NULL PRIMARY KEY, "
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
	
	public boolean inserir(Tabela bean) throws DBException {
		return super.inserir(Tabela.class, bean);
	}
	
	public boolean inserirVarios(List<Tabela> beanList) throws DBException {
		return super.inserirVarios(Tabela.class, beanList);
	}
	
	public boolean alterar(Tabela bean) throws DBException {
		return super.alterar(Tabela.class, bean);
	}
	
	public boolean excluir(Tabela bean) throws DBException {
		return super.excluir(Tabela.class, bean);
	}
}