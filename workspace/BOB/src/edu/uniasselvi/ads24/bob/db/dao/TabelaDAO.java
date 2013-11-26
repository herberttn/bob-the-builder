package edu.uniasselvi.ads24.bob.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.bob.enumeradores.EErrosDB;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.bean.Tabela;
import edu.uniasselvi.ads24.bob.db.conexao.Conexao;

public class TabelaDAO extends BaseDAO implements IDataAccessObject {

	@Override
	public String TableName() {
		return "BOB.Z_TABELAS";
	}

	public boolean CriarTabela() throws DBException {

		return super.CriarTabela(" ID INTEGER NOT NULL PRIMARY KEY, "
				+ " NOME VARCHAR(45) NOT NULL, "
				+ " LEGENDA VARCHAR(250) NOT NULL, "
				+ " POREMPRESA CHAR(1) NOT NULL, "
				+ " PORFILIAL CHAR(1) NOT NULL ");
	}
}