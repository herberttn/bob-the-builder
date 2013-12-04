package edu.uniasselvi.ads24.bob.geradores;

import java.sql.Connection;
import java.sql.Statement;
import edu.uniasselvi.ads24.bob.bean.CampoBase;
import edu.uniasselvi.ads24.bob.bean.CampoTabela;
import edu.uniasselvi.ads24.bob.bean.Tabela;
import edu.uniasselvi.ads24.bob.db.conexao.Conexao;
import edu.uniasselvi.ads24.bob.enumeradores.EErrosDB;
import edu.uniasselvi.ads24.bob.enumeradores.EErrosGeradorComandoDB;
import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.exceptions.GeradorComandoDBException;

public class GeradorComandoDB {

	ETipoGeracao tipo = ETipoGeracao.NENHUM;
	boolean gerarScript = false;

	public GeradorComandoDB(ETipoGeracao tipo, boolean gerarScript) {
		this.tipo = tipo;
		this.gerarScript = gerarScript;
	}

	public void GerarEExecutar(Tabela tabela) throws GeradorComandoDBException, DBException {

		String comando = "";

		switch (this.tipo) {
		
		case NENHUM:
			throw new GeradorComandoDBException(EErrosGeradorComandoDB.TIPO_NAO_DEFINIDO);
			
		case CRIACAO:
			comando = "CREATE TABLE " + tabela.getNome().toUpperCase() + " ( ID INTEGER NOT NULL PRIMARY KEY );";
			break;

		case EXCLUSAO:
			comando = "DROP TABLE " + tabela.getNome().toUpperCase() + ";";
			break;

		default:
			break;
		}

		ExecutarComando(comando);
		GerarScript(tabela);
	}

	public void GerarEExecutar(CampoBase campo) throws GeradorComandoDBException, DBException {

		String comando1 = "";
		String comando2 = "";

		switch (this.tipo) {
		
		case NENHUM:
			throw new GeradorComandoDBException(EErrosGeradorComandoDB.TIPO_NAO_DEFINIDO);
			
		case CRIACAO:

			comando1 = " ALTER TABLE " + campo.getTabela().getNome().toUpperCase() 
 			        + " ADD COLUMN " + campo.getNome().toUpperCase()
 			        + " " + campo.ComandoGetTipo() 
 			        + " " + campo.ComandoGetAtributos() 
			        + " " + campo.ComandoGetNotNUll();
			
			if (campo instanceof CampoTabela) {
				comando2 = " ALTER TABLE " + campo.getTabela().getNome().toUpperCase() 
				        + " ADD CONSTRAINT FK_" + campo.getTabela().getNome().toUpperCase() + "_" + campo.getNome().toUpperCase()
						+ " FOREIGN KEY (" + campo.getNome().toUpperCase() + ")"
						+ " REFERENCES " + ((CampoTabela)campo).getTabelaPai().getNome().toUpperCase() + "(ID);";
			}
			break;

		case EXCLUSAO:
			if (campo instanceof CampoTabela) {
				comando1 = "ALTER TABLE " + campo.getTabela().getNome().toUpperCase() + " DROP FOREIGN KEY FK_" + campo.getTabela().getNome().toUpperCase() + "_" + campo.getNome().toUpperCase();
			}
			
			comando2 = "ALTER TABLE " + campo.getTabela().getNome().toUpperCase() + " DROP COLUMN " + campo.getNome().toUpperCase();
			break;

		default:
			break;
		}

		ExecutarComando(comando1);
		ExecutarComando(comando2);
		GerarScript(campo);
	}

	private boolean ExecutarComando(String comando) throws DBException {
		
		if (comando.isEmpty())
			return true;
		
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute(comando);
			return true;

		} catch (Exception e) {
			throw new DBException(EErrosDB.EXECUCAO_COMANDO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	private void GerarScript(Tabela tabela) throws DBException {

		if (!this.gerarScript)
			return;

		GeradorScript geradorScript = new GeradorScript(this.tipo);
		geradorScript.Gerar(tabela);
	}

	private void GerarScript(CampoBase campo) throws DBException {
		
		if (!this.gerarScript)
			return;
		
		GeradorScript geradorScript = new GeradorScript(this.tipo);
		geradorScript.Gerar(campo);
	}
}
