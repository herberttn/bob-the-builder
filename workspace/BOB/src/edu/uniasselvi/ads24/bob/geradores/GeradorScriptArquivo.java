package edu.uniasselvi.ads24.bob.geradores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.uniasselvi.ads24.bob.bean.CampoBase;
import edu.uniasselvi.ads24.bob.bean.Script;
import edu.uniasselvi.ads24.bob.bean.Tabela;
import edu.uniasselvi.ads24.bob.db.dao.ScriptDAO;
import edu.uniasselvi.ads24.bob.enumeradores.ETipoGeracao;
import edu.uniasselvi.ads24.bob.exceptions.BusinessExceptions;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.exceptions.GeradorComandoDBException;
import edu.uniasselvi.ads24.bob.main.DesignMenus;
import edu.uniasselvi.ads24.bob.utils.Serialization;

public class GeradorScriptArquivo {
	
	String filename;

	public GeradorScriptArquivo(String filename) {
		this.filename = filename;
	}
	
	public boolean exportarParaArquivo() throws DBException {
		
		ScriptDAO dao = new ScriptDAO();
		List<Script> list = dao.consultarTodos("ID");

		try {

			for (Script registro : list) {
				PrintWriter destino = new PrintWriter(new FileWriter(new File(this.filename), true), true);
				String temp = registro.getTipo() + "|" + registro.getComando();
				destino.println(temp.replace("\n", "||||"));
				destino.close();
			}
			
			System.out.println(list.size() + " comandos exportados.");

		} catch (IOException e) {
			System.out.println("Erro -> " + e);
			return false;
		}
		return true;
	}
	
	public boolean importarDeArquivo() throws GeradorComandoDBException, DBException, BusinessExceptions {
		
		Collection<Script> list = deserializarArquivo();
		
		if (list.size() <= 0)
			System.out.println("Nenhum comando encontrado no arquivo.");
		else
			System.out.println("Importando " + list.size() + " registros.");
		
		for (Script registro : list) {
			Object o = Serialization.Deserialize(registro.getComando());
			
			GeradorComandoDB gerador = new GeradorComandoDB(ETipoGeracao.fromInteger(registro.getTipo()), false);
			
			if (o instanceof Tabela)
				gerador.GerarEExecutar((Tabela)o);
			else
				if (o instanceof CampoBase)
					gerador.GerarEExecutar((CampoBase)o);
		}
		
		return true;
	}
	
	private Collection<Script> deserializarArquivo() throws BusinessExceptions {
		
		BufferedReader origem = null;
		Collection<Script> resultado = new ArrayList<Script>();
		try {
			String linha = "";
			origem = new BufferedReader(new FileReader(new File(this.filename)));
			
			while ((linha = origem.readLine().replace("||||", "\n")) != null) {
				
				Script temp = new Script();
				temp.setBobversion("1.0");
				int tipo = DesignMenus.TryParseInt(linha.substring(0, linha.indexOf("|")));
				String comando = linha.substring(linha.indexOf("|") + 1);
				
				temp.setComando(comando);
				temp.setDatahora(new Date());
				temp.setTipo(tipo);
				
				resultado.add(temp);
			}
			return resultado;
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado.");
		} catch (IOException e) {
			System.out.println("Erro -> " + e);
		} finally{
			if(origem != null){
				try {
					origem.close();
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
		return resultado;
	}	
}



