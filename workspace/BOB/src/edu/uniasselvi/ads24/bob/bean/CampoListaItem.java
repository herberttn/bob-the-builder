package edu.uniasselvi.ads24.bob.bean;

public class CampoListaItem {
	private String legenda;
	private int valor;
	
	public CampoListaItem(String legenda, int valor)
	{
		setLegenda(legenda);
		setValor(valor);
	}
	
	public CampoListaItem()
	{
		this("Indefinido",-1);
	}
	
	public void setValor(int valor)
	{
		this.valor = valor;
	}
	
	public int getValor()
	{
		return this.valor;
	}
	
	public String getLegenda()
	{
		return this.legenda;
	}
	public void setLegenda(String legenda)
	{
		this.legenda = legenda;
	}

}
