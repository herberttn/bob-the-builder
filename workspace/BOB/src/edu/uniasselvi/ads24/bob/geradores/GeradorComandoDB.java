package edu.uniasselvi.ads24.bob.geradores;

import edu.uniasselvi.ads24.bob.bean.CampoBase;
import edu.uniasselvi.ads24.bob.bean.Tabela;
import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;

public class GeradorComandoDB {

	ETipoGeracao tipo = ETipoGeracao.NENHUM;
	boolean gerarScript = false;

	public GeradorComandoDB(ETipoGeracao tipo, boolean gerarScript) {
		this.tipo = tipo;
		this.gerarScript = gerarScript;
	}

	public void Gerar(Tabela tabela) {
		if (this.gerarScript)
			GerarScript(tabela);
	}

	public void Gerar(CampoBase campo) {
		if (this.gerarScript)
			GerarScript(campo);
	}

	private void GerarScript(Tabela tabela) {
		GeradorScript geradorScript = new GeradorScript(this.tipo);
		geradorScript.Gerar(tabela);
	}

	private void GerarScript(CampoBase campo) {
		GeradorScript geradorScript = new GeradorScript(this.tipo);
		geradorScript.Gerar(campo);
	}
}
