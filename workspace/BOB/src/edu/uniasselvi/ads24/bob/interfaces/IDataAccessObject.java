package edu.uniasselvi.ads24.bob.interfaces;

import edu.uniasselvi.ads24.db.conexao.DBException;

public interface IDataAccessObject {
	public boolean CriarTabela() throws DBException;
	public boolean ExcluirTabela() throws DBException;
}
