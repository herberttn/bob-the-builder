package edu.uniasselvi.ads24.bob.db.dao;

import java.util.Arrays;
import java.util.List;
import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.bob.bean.*;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public class CampoDAO extends BaseDAO implements IDataAccessObject {

	@Override
	public String tableName() {
		return "BOB.Z_CAMPOS";
	}

	@Override
	public String tableFields() {
		return "ID, TABELA, NOME, LEGENDA, OBRIGATORIO, TIPO, EXCLUIDO, VALORPADRAOINTEGER, VALORPADRAOSTRING, VALORPADRAODATETIME, VALORPADRAODECIMAL, PESQUISATABELA, EHPK, TEMINTEGRIDADE, TAMANHO, PRECISAO";
	}

	public boolean criarTabela() throws DBException {

		return super.criarTabela(" ID INTEGER NOT NULL PRIMARY KEY, "
						+ " TABELA INTEGER NOT NULL, "
						+ " NOME VARCHAR(45) NOT NULL, "
						+ " LEGENDA VARCHAR(250) NOT NULL, "
						+ " OBRIGATORIO CHAR(1) NOT NULL, "
						+ " TIPO INTEGER NOT NULL, "
						+ " EXCLUIDO CHAR(1) NOT NULL, "
						+ " VALORPADRAOINTEGER INTEGER, "
						+ " VALORPADRAOSTRING VARCHAR(200), "
						+ " VALORPADRAODATETIME DATETIME, "
						+ " VALORPADRAODECIMAL DECIMAL(15,4), "
						+ " PESQUISATABELA INTEGER, "
						+ " EHPK CHAR(1) NOT NULL, "
						+ " TEMINTEGRIDADE CHAR(1) NOT NULL, "
						+ " TAMANHO INTEGER, "
						+ " PRECISAO INTEGER, "
						+ " INDEX BOB.Z_CAMPOS.IDX_FK_ZCAMPOS_TABELA(TABELA ASC), "
						+ " INDEX BOB.Z_CAMPOS.IDX_FK_ZCAMPOS_PESQUISATABELA(PESQUISATABELA ASC), "
						+ " CONSTRAINT BOB.Z_CAMPOS.FK_ZCAMPOS_TABELA FOREIGN KEY(TABELA) REFERENCES BOB.Z_TABELAS(ID) ON DELETE NO ACTION ON UPDATE NO ACTION, "
						+ " CONSTRAINT BOB.Z_CAMPOS.FK_ZCAMPOS_PESQUISATABELA FOREIGN KEY(PESQUISATABELA) REFERENCES BOB.Z_TABELAS(ID) ON DELETE NO ACTION ON UPDATE NO ACTION, ");
	}
	
	public CampoBase consultar(int ID) throws DBException {
		return super.consultar(CampoBase.class, ID);
	}
	
	public List<CampoBase> consultarVarios(String where) throws DBException {
		return super.consultarVarios(CampoBase.class, where);
	}
	
	public List<CampoBase> consultarTodos() throws DBException {
		return super.consultarTodos(CampoBase.class);
	}
	
	public boolean inserir(CampoBase bean) throws DBException {
		return super.inserir(CampoBase.class, bean);
	}
	
	public boolean inserir(CampoDecimal bean) throws DBException {
		return super.inserir(CampoDecimal.class, bean);
	}
	
	public boolean inserir(CampoInteger bean) throws DBException {
		return super.inserir(CampoInteger.class, bean);
	}
	
	public boolean inserir(CampoPK bean) throws DBException {
		return super.inserir(CampoPK.class, bean);
	}
	
	public boolean inserir(CampoString bean) throws DBException {
		return super.inserir(CampoString.class, bean);
	}
	
	public boolean inserir(CampoTabela bean) throws DBException {
		return super.inserir(CampoTabela.class, bean);
	}
	
	public boolean inserirVarios(CampoBase[] beanList) throws DBException {
		return super.inserirVarios(CampoBase.class, Arrays.asList(beanList));
	}
	
	public boolean inserirVarios(CampoDecimal[] beanList) throws DBException {
		return super.inserirVarios(CampoDecimal.class, Arrays.asList(beanList));
	}
	
	public boolean inserirVarios(CampoInteger[] beanList) throws DBException {
		return super.inserirVarios(CampoInteger.class, Arrays.asList(beanList));
	}
	
	public boolean inserirVarios(CampoPK[] beanList) throws DBException {
		return super.inserirVarios(CampoPK.class, Arrays.asList(beanList));
	}
	
	public boolean inserirVarios(CampoString[] beanList) throws DBException {
		return super.inserirVarios(CampoString.class, Arrays.asList(beanList));
	}
	
	public boolean inserirVarios(CampoTabela[] beanList) throws DBException {
		return super.inserirVarios(CampoTabela.class, Arrays.asList(beanList));
	}
	
	public boolean alterar(CampoBase bean) throws DBException {
		return super.alterar(CampoBase.class, bean);
	}
	
	public boolean alterar(CampoDecimal bean) throws DBException {
		return super.alterar(CampoDecimal.class, bean);
	}
	
	public boolean alterar(CampoInteger bean) throws DBException {
		return super.alterar(CampoInteger.class, bean);
	}
	
	public boolean alterar(CampoPK bean) throws DBException {
		return super.alterar(CampoPK.class, bean);
	}
	
	public boolean alterar(CampoString bean) throws DBException {
		return super.alterar(CampoString.class, bean);
	}
	
	public boolean alterar(CampoTabela bean) throws DBException {
		return super.alterar(CampoTabela.class, bean);
	}
	
	public boolean excluir(CampoBase bean) throws DBException {
		return super.excluir(CampoBase.class, bean);
	}
	
	public boolean excluir(CampoDecimal bean) throws DBException {
		return super.excluir(CampoDecimal.class, bean);
	}
	
	public boolean excluir(CampoInteger bean) throws DBException {
		return super.excluir(CampoInteger.class, bean);
	}
	
	public boolean excluir(CampoPK bean) throws DBException {
		return super.excluir(CampoPK.class, bean);
	}
	
	public boolean excluir(CampoString bean) throws DBException {
		return super.excluir(CampoString.class, bean);
	}
	
	public boolean excluir(CampoTabela bean) throws DBException {
		return super.excluir(CampoTabela.class, bean);
	}
}
