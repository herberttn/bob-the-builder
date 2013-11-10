package edu.uniasselvi.ads24.bob.geradores;

import edu.uniasselvi.ads24.bob.bean.CampoBase;
import edu.uniasselvi.ads24.bob.bean.Tabela;
import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;

public class GeradorScript {

	ETipoGeracao tipo = ETipoGeracao.NENHUM;

	public GeradorScript(ETipoGeracao tipo) {
		this.tipo = tipo;
	}

	public void Gerar(Tabela tabelaAntes, Tabela tabelaDepois) {

	}

	public void Gerar(CampoBase campoAntes, CampoBase campoDepois) {

	}
}
