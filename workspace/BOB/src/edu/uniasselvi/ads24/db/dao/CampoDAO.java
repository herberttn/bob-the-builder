package edu.uniasselvi.ads24.db.dao;

import java.sql.Connection;
import java.sql.Statement;

import edu.uniasselvi.ads24.bob.interfaces.IDataAccessObject;
import edu.uniasselvi.ads24.db.conexao.DBException;
import edu.uniasselvi.ads24.db.conexao.Conexao;

public class CampoDAO implements IDataAccessObject {

	public boolean CriarTabela() throws DBException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute(" CREATE TABLE BOB.Z_CAMPOS ( "
					+ "     ID INTEGER NOT NULL PRIMARY KEY, "
					+ "     TABELA INTEGER NOT NULL, "
					+ "     NOME VARCHAR(45) NOT NULL, "
					+ "     LEGENDA VARCHAR(250) NOT NULL, "
					+ "     OBRIGATORIO CHAR(1) NOT NULL, "
					+ "     TIPO INTEGER NOT NULL, "
					+ "     EXCLUIDO CHAR(1) NOT NULL, "
					+ "     VALORPADRAOINTEGER INTEGER, "
					+ "     VALORPADRAOSTRING VARCHAR(200), "
					+ "     VALORPADRAODATETIME DATETIME, "
					+ "     VALORPADRAODECIMAL DECIMAL(15,4), "
					+ "     PESQUISATABELA INTEGER, "
					+ "     PESQUISACAMPO INTEGER, "
					+ "     EHPK CHAR(1) NOT NULL, "
					+ "     TEMINTEGRIDADE CHAR(1) NOT NULL, "
					+ "     TAMANHO INTEGER, "
					+ "     INDEX BOB.Z_CAMPOS.IDX_FK_ZCAMPOS_TABELA(TABELA ASC), "
					+ "     INDEX BOB.Z_CAMPOS.IDX_FK_ZCAMPOS_PESQUISATABELA(PESQUISATABELA ASC), "
					+ "     INDEX BOB.Z_CAMPOS.IDX_FK_ZCAMPOS_PESQUISACAMPO(PESQUISACAMPO ASC), "
					+ "     CONSTRAINT BOB.Z_CAMPOS.FK_ZCAMPOS_TABELA FOREIGN KEY(TABELA) REFERENCES BOB.Z_TABELAS(ID) ON DELETE NO ACTION ON UPDATE NO ACTION, "
					+ "     CONSTRAINT BOB.Z_CAMPOS.FK_ZCAMPOS_PESQUISATABELA FOREIGN KEY(PESQUISATABELA) REFERENCES BOB.Z_TABELAS(ID) ON DELETE NO ACTION ON UPDATE NO ACTION, "
					+ "     CONSTRAINT BOB.Z_CAMPOS.FK_ZCAMPOS_PESQUISACAMPO FOREIGN KEY(PESQUISACAMPO) REFERENCES BOB.Z_CAMPOS(ID) ON DELETE NO ACTION ON UPDATE NO ACTION ); ");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean ExcluirTabela() throws DBException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute(" DROP TABLE BOB.Z_CAMPOS; ");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
