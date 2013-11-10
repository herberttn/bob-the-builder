package edu.uniasselvi.ads24.bob.geradores;

import edu.uniasselvi.ads24.bob.bean.CampoBase;
import edu.uniasselvi.ads24.bob.bean.Tabela;
import edu.uniasselvi.ads24.bob.enumeradores.EErrosGeradorComandoDB;
import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.exceptions.GeradorComandoDBException;

public class GeradorComandoDB {

	ETipoGeracao tipo = ETipoGeracao.NENHUM;
	boolean gerarScript = false;

	public GeradorComandoDB(ETipoGeracao tipo, boolean gerarScript) {
		this.tipo = tipo;
		this.gerarScript = gerarScript;
	}

	public void Gerar(Tabela tabelaAntes, Tabela tabelaDepois) throws GeradorComandoDBException {

		String comando = null;

		switch (this.tipo) {
		
		case NENHUM:
			throw new GeradorComandoDBException(EErrosGeradorComandoDB.TIPO_NAO_DEFINIDO);
			
		case CRIACAO:
			comando = "CREATE TABLE " + tabelaAntes.getNome().toUpperCase() + " ( ID INTEGER NOT NULL PRIMARY KEY );";
			break;

		case ALTERACAO:
			comando = "ALTER TABLE BOB." + tabelaAntes.getNome().toUpperCase() + " RENAME TO BOB." + tabelaDepois.getNome().toUpperCase() + ";";
			break;

		case EXCLUSAO:
			comando = "DROP TABLE " + tabelaAntes.getNome().toUpperCase() + ";";
			break;

		default:
			break;
		}

		ExecutarComando(comando);

		if (this.gerarScript)
			GerarScript(tabelaAntes, tabelaDepois);
	}

	public void Gerar(CampoBase campoAntes, CampoBase campoDepois) throws GeradorComandoDBException {

		String comando = null;

		switch (this.tipo) {
		
		case NENHUM:
			throw new GeradorComandoDBException(EErrosGeradorComandoDB.TIPO_NAO_DEFINIDO);
			
		case CRIACAO:
			comando = " ALTER TABLE BOB." + campoAntes.getTabela().getNome().toUpperCase() 
			        + " ADD COLUMN " + campoAntes.getNome().toUpperCase();
			
			if (campoAntes.getObrigatorio())
				comando = comando + " NOT NULL ";
			
			
			
			        + " VARCHAR(45)";
			break;

		case ALTERACAO:
			comando = "";
			break;

		case EXCLUSAO:
			comando = "";
			break;

		default:
			break;
		}

		ExecutarComando(comando);

		if (this.gerarScript)
			GerarScript(campoAntes, campoDepois);
	}

	private void ExecutarComando(String comando) {

	}

	private void GerarScript(Tabela tabelaAntes, Tabela tabelaDepois) {
		GeradorScript geradorScript = new GeradorScript(this.tipo);
		geradorScript.Gerar(tabelaAntes, tabelaDepois);
	}

	private void GerarScript(CampoBase campoAntes, CampoBase campoDepois) {
		GeradorScript geradorScript = new GeradorScript(this.tipo);
		geradorScript.Gerar(campoAntes, campoDepois);
	}
}
