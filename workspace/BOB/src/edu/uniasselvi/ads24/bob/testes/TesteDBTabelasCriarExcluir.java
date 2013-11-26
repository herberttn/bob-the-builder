package edu.uniasselvi.ads24.bob.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import edu.uniasselvi.ads24.bob.enumeradores.EErrosDB;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.bean.Tabela;
import edu.uniasselvi.ads24.bob.db.conexao.Conexao;
import edu.uniasselvi.ads24.bob.db.dao.CampoDAO;
import edu.uniasselvi.ads24.bob.db.dao.EmpresaDAO;
import edu.uniasselvi.ads24.bob.db.dao.FilialDAO;
import edu.uniasselvi.ads24.bob.db.dao.ScriptDAO;
import edu.uniasselvi.ads24.bob.db.dao.TabelaDAO;

public class TesteDBTabelasCriarExcluir {

	public static void main(String[] args) throws DBException {
		
		CampoDAO campoDAO = null;
		EmpresaDAO empresaDAO = null;
		FilialDAO filialDAO = null;
		ScriptDAO scriptDAO = null;
		TabelaDAO tabelaDAO = null;
		
		System.out.println("Instanciando objetos.");
		try {
			campoDAO = new CampoDAO();
			empresaDAO = new EmpresaDAO();
			filialDAO = new FilialDAO();
			scriptDAO = new ScriptDAO();
			tabelaDAO = new TabelaDAO();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Criando tabela Z_TABELAS.");
			tabelaDAO.CriarTabela();

			System.out.println("Criando tabela Z_CAMPOS.");
			campoDAO.CriarTabela();

			System.out.println("Criando tabela EMPRESAS.");
			empresaDAO.CriarTabela();

			System.out.println("Criando tabela FILIAIS.");
			filialDAO.CriarTabela();

			System.out.println("Criando tabela Z_SCRIPT.");
			scriptDAO.CriarTabela();
		} catch (DBException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		
		
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO Z_TABELAS (ID, NOME, LEGENDA, POREMPRESA, PORFILIAL) VALUES (?, ?, ?, ?, ?);");
			pst.setInt(1, 1);
			pst.setString(2, "teste");
			pst.setString(3, "teste legenda");
			pst.setString(4, "S");
			pst.setString(5, "N");
			
			if (pst.executeUpdate() > 0)
				System.out.println("Inserido.");
			else
				System.out.println("Não inserido.");
		} catch (Exception e) {
			throw new DBException(EErrosDB.INSERIR_DADOS, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}		
		
		
		Tabela teste = tabelaDAO.consultar(1);
		
		if (teste != null)
		{
			System.out.println(teste.getNome());			
		}
		else
			System.out.println("nada");
		
		
		
		
		

		try {
			System.out.println("Excluindo tabela Z_SCRIPT.");
			scriptDAO.ExcluirTabela();
			
			System.out.println("Excluindo tabela FILIAIS.");
			filialDAO.ExcluirTabela();

			System.out.println("Excluindo tabela EMPRESAS.");
			empresaDAO.ExcluirTabela();

			System.out.println("Excluindo tabela Z_CAMPOS.");
			campoDAO.ExcluirTabela();

			System.out.println("Excluindo tabela Z_TABELAS.");
			tabelaDAO.ExcluirTabela();

		} catch (DBException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Sucesso.");
	}

}
