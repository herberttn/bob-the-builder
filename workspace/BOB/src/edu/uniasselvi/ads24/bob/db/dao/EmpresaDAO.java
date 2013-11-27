package edu.uniasselvi.ads24.bob.db.dao;

import java.util.List;
import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.bob.bean.Empresa;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public class EmpresaDAO extends BaseDAO implements IDataAccessObject {
	
	@Override
	public String tableName() {
		return "BOB.EMPRESAS";
	}

	@Override
	public String tableFields() {
		return "ID, NOME, CNPJ";
	}
		
	public boolean criarTabela() throws DBException {

		return super.criarTabela(" ID INTEGER NOT NULL PRIMARY KEY, "
					+ " NOME VARCHAR(100) NOT NULL, "
					+ " CNPJ VARCHAR(14) NOT NULL ");
	}
	
	public Empresa consultar(int ID) throws DBException {
		return super.consultar(Empresa.class, ID);
	}
	
	public List<Empresa> consultarVarios(String where) throws DBException {
		return super.consultarVarios(Empresa.class, where);
	}
	
	public List<Empresa> consultarTodos() throws DBException {
		return super.consultarTodos(Empresa.class);
	}
	
	public boolean inserir(Empresa bean) throws DBException {
		return super.inserir(Empresa.class, bean);
	}
	
	public boolean inserirVarios(List<Empresa> beanList) throws DBException {
		return super.inserirVarios(Empresa.class, beanList);
	}
	
	public boolean alterar(Empresa bean) throws DBException {
		return super.alterar(Empresa.class, bean);
	}
	
	public boolean excluir(Empresa bean) throws DBException {
		return super.excluir(Empresa.class, bean);
	}
}