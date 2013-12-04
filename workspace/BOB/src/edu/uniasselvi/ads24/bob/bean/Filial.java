package edu.uniasselvi.ads24.bob.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uniasselvi.ads24.bob.db.dao.EmpresaDAO;
import edu.uniasselvi.ads24.bob.exceptions.DBException;
import edu.uniasselvi.ads24.bob.interfaces.IDataDefinitionLanguage;

public class Filial extends RegistroBase implements IDataDefinitionLanguage, Serializable {

	private static final long serialVersionUID = 1L;

	private Empresa empresa;
	private String nome;
	private String cnpj;
	
	public Filial() {
		this(-1, null, null, null);
	}

	public Filial(int ID, Empresa empresa, String nome, String cnpj) {
		
		super(ID);
		
		this.setEmpresa(empresa);
		this.setNome(nome);
		this.setCnpj(cnpj);
	}
	
	@Override
	public void loadFromResultSet(ResultSet resultset) throws SQLException, DBException {
		
		super.loadFromResultSet(resultset);
		
		EmpresaDAO dao = new EmpresaDAO();
		this.setEmpresa(dao.consultar(resultset.getInt("EMPRESA")));
		this.setNome(resultset.getString("NOME"));
		this.setCnpj(resultset.getString("CNPJ"));	
	}

	@Override
	public void loadStatementParams(PreparedStatement preparedStatement) throws SQLException, DBException {
		
		super.loadStatementParams(preparedStatement);
		
		preparedStatement.setInt(2, this.getEmpresa().getID()); // EMPRESA
		preparedStatement.setString(3, this.getNome()); // NOME
		preparedStatement.setString(4, this.getCnpj()); // CNPJ
	}

	@Override
	public void Salvar() {
		// TODO Auto-generated method stub
	}

	@Override
	public void Excluir() {
		// TODO Auto-generated method stub
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append("\nEmpresa (ID - CNPJ)......: ").append(this.getEmpresa().getID() + " - " + this.getEmpresa().getCnpj());
		sb.append("\nNome.....................: ").append(this.getNome());
		sb.append("\nCNPJ.....................: ").append(this.getCnpj());
		
		return sb.toString();
	}
}
