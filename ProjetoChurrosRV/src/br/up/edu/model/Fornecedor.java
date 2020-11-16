package br.up.edu.model;

public class Fornecedor {

	private int id;
	private String nome;
	private String telefone;
	private String produto_fornecido;
	private String endereco;
	private double preco;

	public Fornecedor() {

	}


	public Fornecedor(String produto_fornecido, double preco) {
		super();
		this.produto_fornecido = produto_fornecido;
		this.preco = preco;
	}


	public Fornecedor(String nome, String telefone, String produto_fornecido, String endereco, double preco) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.produto_fornecido = produto_fornecido;
		this.endereco = endereco;
		this.preco = preco;
	}

	public Fornecedor(int id, String nome, String telefone, String produto_fornecido, String endereco, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.produto_fornecido = produto_fornecido;
		this.endereco = endereco;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getProduto_fornecido() {
		return produto_fornecido;
	}

	public void setProduto_fornecido(String produto_fornecido) {
		this.produto_fornecido = produto_fornecido;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "ID: " + id + " Nome: " + nome + "\t Telefone: " + telefone + "\t Produtos Fornecidos: "
				+ produto_fornecido + "\t Endereço: " + endereco + "\t Preco: R$" + preco;
	}

}
