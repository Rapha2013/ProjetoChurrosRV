package br.up.edu.model;

public class Vendas {

	private int id;
	private String nome_cliente;
	private int quantidade;
	private String produto_escolhido;
	private String obs;
	private double preco;

	public Vendas() {

	}

	public Vendas(String nome_cliente, int quantidade, String produto_escolhido, String obs, double preco) {
		super();
		this.nome_cliente = nome_cliente;
		this.quantidade = quantidade;
		this.produto_escolhido = produto_escolhido;
		this.obs = obs;
		this.preco = preco;
	}

	public Vendas(int id, String nome_cliente, int quantidade, String produto_escolhido, String obs, double preco) {
		super();
		this.id = id;
		this.nome_cliente = nome_cliente;
		this.quantidade = quantidade;
		this.produto_escolhido = produto_escolhido;
		this.obs = obs;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getProduto_escolhido() {
		return produto_escolhido;
	}

	public void setProduto_escolhido(String produto_escolhido) {
		this.produto_escolhido = produto_escolhido;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "ID: " + id + "\t Nome do Cliente: " + nome_cliente + "\t Quantidade: " + quantidade
				+ "\t Produto Escolhido: " + produto_escolhido + "\t Observação: " + obs + "\t Preco: " + preco;
	}

}
