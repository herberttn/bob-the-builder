package edu.uniasselvi.ads24.bob.db.dao;

import java.util.List;
import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.bob.bean.CampoBase;
import edu.uniasselvi.ads24.bob.exceptions.DBException;

public class CampoDAO extends BaseDAO implements IDataAccessObject {

	@Override
	public String TableName() {
		return "BOB.Z_CAMPOS";
	}

	@Override
	public String TableFields() {
		return "ID, TABELA, NOME, LEGENDA, OBRIGATORIO, TIPO, EXCLUIDO, VALORPADRAOINTEGER, VALORPADRAOSTRING, VALORPADRAODATETIME, VALORPADRAODECIMAL, PESQUISATABELA, PESQUISACAMPO, EHPK, TEMINTEGRIDADE, TAMANHO, PRECISAO";
	}

	public boolean CriarTabela() throws DBException {

		return super.CriarTabela(" ID INTEGER NOT NULL PRIMARY KEY, "
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
						+ " PESQUISACAMPO INTEGER, "
						+ " EHPK CHAR(1) NOT NULL, "
						+ " TEMINTEGRIDADE CHAR(1) NOT NULL, "
						+ " TAMANHO INTEGER, "
						+ " PRECISAO INTEGER, "
						+ " INDEX BOB.Z_CAMPOS.IDX_FK_ZCAMPOS_TABELA(TABELA ASC), "
						+ " INDEX BOB.Z_CAMPOS.IDX_FK_ZCAMPOS_PESQUISATABELA(PESQUISATABELA ASC), "
						+ " INDEX BOB.Z_CAMPOS.IDX_FK_ZCAMPOS_PESQUISACAMPO(PESQUISACAMPO ASC), "
						+ " CONSTRAINT BOB.Z_CAMPOS.FK_ZCAMPOS_TABELA FOREIGN KEY(TABELA) REFERENCES BOB.Z_TABELAS(ID) ON DELETE NO ACTION ON UPDATE NO ACTION, "
						+ " CONSTRAINT BOB.Z_CAMPOS.FK_ZCAMPOS_PESQUISATABELA FOREIGN KEY(PESQUISATABELA) REFERENCES BOB.Z_TABELAS(ID) ON DELETE NO ACTION ON UPDATE NO ACTION, "
						+ " CONSTRAINT BOB.Z_CAMPOS.FK_ZCAMPOS_PESQUISACAMPO FOREIGN KEY(PESQUISACAMPO) REFERENCES BOB.Z_CAMPOS(ID) ON DELETE NO ACTION ON UPDATE NO ACTION ");
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
}
