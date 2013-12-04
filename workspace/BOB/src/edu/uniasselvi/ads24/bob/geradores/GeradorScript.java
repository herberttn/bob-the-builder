package edu.uniasselvi.ads24.bob.geradores;

import java.util.Date;
import edu.uniasselvi.ads24.bob.bean.CampoBase;
import edu.uniasselvi.ads24.bob.bean.Script;
import edu.uniasselvi.ads24.bob.bean.Tabela;
import edu.uniasselvi.ads24.bob.db.dao.ScriptDAO;
import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.utils.Serialization;

public class GeradorScript {

	ETipoGeracao tipo = ETipoGeracao.NENHUM;

	public GeradorScript(ETipoGeracao tipo) {
		this.tipo = tipo;
	}

	public void Gerar(Tabela tabela) throws DBException {
		
		Script script = new Script();
		
		script.setBobversion("1.0");
		script.setDatahora(new Date());
		script.setTipo(tipo.getIndex());
		script.setComando(Serialization.Serialize(tabela));		
		
		ScriptDAO dao = new ScriptDAO();
		dao.inserir(script);
	}

	public void Gerar(CampoBase campo) throws DBException {

		Script script = new Script();
		
		script.setBobversion("1.0");
		script.setDatahora(new Date());
		script.setTipo(tipo.getIndex());
		script.setComando(Serialization.Serialize(campo));		
		
		ScriptDAO dao = new ScriptDAO();
		dao.inserir(script);
	}
}
