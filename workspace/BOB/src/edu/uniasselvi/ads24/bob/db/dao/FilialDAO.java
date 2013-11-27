package edu.uniasselvi.ads24.bob.db.dao;

import java.util.List;
import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.bob.bean.Filial;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public class FilialDAO extends BaseDAO implements IDataAccessObject {
	
	@Override
	public String tableName() {
		return "BOB.FILIAIS";
	}

	@Override
	public String tableFields() {
		return "ID, EMPRESA, NOME, CNPJ";
	}
	
	public boolean criarTabela() throws DBException {

		return super.criarTabela(" ID INTEGER NOT NULL PRIMARY KEY, "
					+ " EMPRESA INTEGER, "
					+ " NOME VARCHAR(100) NOT NULL, "
					+ " CNPJ VARCHAR(14) NOT NULL, "
					+ " INDEX BOB.FILIAIS.IDX_FK_FILIAIS_EMPRESA(EMPRESA ASC), "
					+ " CONSTRAINT BOB.FILIAIS.FK_FILIAIS_EMPRESA FOREIGN KEY(EMPRESA) REFERENCES BOB.EMPRESAS(ID) ON DELETE NO ACTION ON UPDATE NO ACTION ");
	}
	
	public Filial consultar(int ID) throws DBException {
		return super.consultar(Filial.class, ID);
	}
	
	public List<Filial> consultarVarios(String where) throws DBException {
		return super.consultarVarios(Filial.class, where);
	}
	
	public List<Filial> consultarTodos() throws DBException {
		return super.consultarTodos(Filial.class);
	}
	
	public boolean inserir(Filial bean) throws DBException {
		return super.inserir(Filial.class, bean);
	}
	
	public boolean inserirVarios(List<Filial> beanList) throws DBException {
		return super.inserirVarios(Filial.class, beanList);
	}
	
	public boolean alterar(Filial bean) throws DBException {
		return super.alterar(Filial.class, bean);
	}
	
	public boolean excluir(Filial bean) throws DBException {
		return super.excluir(Filial.class, bean);
	}
}
