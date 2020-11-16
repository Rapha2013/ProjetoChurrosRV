package br.edu.up.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.up.edu.model.Fornecedor;
import br.up.edu.model.Vendas;

public class VendasDAO implements DAO<Vendas> {

	@Override
	public Vendas salvar(Vendas vendas) {
		try {

			String url = "jdbc:sqlite:C:\\Users\\rapha\\Documents\\Banco de dados SQL\\BancoDeDadosChurrosRV.db";
			Connection con = DriverManager.getConnection(url);
			String fornecedores = "insert into vendas (nome_cliente, quantidade, produto_escolhido, obs, preco) values (?, ?, ?, ?, ?);";
			PreparedStatement executor = con.prepareStatement(fornecedores);

			executor.setString(1, vendas.getNome_cliente());
			executor.setInt(2, vendas.getQuantidade());
			executor.setString(3, vendas.getProduto_escolhido());
			executor.setString(4, vendas.getObs());
			executor.setDouble(5, vendas.getPreco());

			executor.executeUpdate();
			executor.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Verifique seu banco de dados!" + e);
		}

		return vendas;
	}

	@Override
	public Vendas atualizar(Vendas vendas) {
		try {

			String url = "jdbc:sqlite:C:\\Users\\rapha\\Documents\\Banco de dados SQL\\BancoDeDadosChurrosRV.db";

			Connection con = DriverManager.getConnection(url);
			String atualizar = "update vendas set nome_cliente = ?, quantidade = ?, produto_escolhido = ?, obs = ?, preco = ? where id = ?;";
			PreparedStatement executor = con.prepareStatement(atualizar);

			executor.setString(1, vendas.getNome_cliente());
			executor.setInt(2, vendas.getQuantidade());
			executor.setString(3, vendas.getProduto_escolhido());
			executor.setString(4, vendas.getObs());
			executor.setDouble(5, vendas.getPreco());
			executor.setInt(6, vendas.getId());

			executor.executeUpdate();
			executor.close();
			con.close();
			return null;
		} catch (SQLException e) {
			System.out.println("ERRO: Verifique seu banco de dados!" + e);
		}
		return vendas;
	}

	@Override
	public Vendas buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vendas> listar() {
		
		List<Vendas> listaDeVendas = new ArrayList<>();

		String url = "jdbc:sqlite:C:\\Users\\rapha\\Documents\\Banco de dados SQL\\BancoDeDadosChurrosRV.db";

		try {

			Connection con = DriverManager.getConnection(url);

			Statement executor = con.createStatement();

			String fornecedores = "select * from vendas";

			ResultSet resultado = executor.executeQuery(fornecedores);

			while (resultado.next()) {
				int id = resultado.getInt("id");
				String nome_cliente = resultado.getString("nome_cliente");
				int quantidade = resultado.getInt("quantidade");
				String produto_escolhido = resultado.getString("produto_escolhido");
				String obs = resultado.getString("obs");
				Double preco = resultado.getDouble("preco");

				Vendas p = new Vendas(id, nome_cliente, quantidade, produto_escolhido, obs, preco);
				listaDeVendas.add(p);

			}

			executor.close();
			con.close();

			con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("ERRO: Verifique seu banco de dados!" + e);
		}

		return listaDeVendas;
	}

	@Override
	public void apagar(Integer id) {
		try {
			String url = "jdbc:sqlite:C:\\Users\\rapha\\Documents\\Banco de dados SQL\\BancoDeDadosChurrosRV.db";

			Connection con = DriverManager.getConnection(url);

			String delet = "delete from vendas where id = ?;";
			PreparedStatement executor = con.prepareStatement(delet);

			executor.setInt(1, id);
			executor.executeUpdate();
			executor.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("ERRO: Verifique seu banco de dados!" + e);
		}

	}

}
