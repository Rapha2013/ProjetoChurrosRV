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

public class FornecedorDAO implements DAO<Fornecedor> {

	@Override
	public Fornecedor salvar(Fornecedor fornecedor) {

		try {
			
			String url = "jdbc:sqlite:C:\\Users\\rapha\\Documents\\Banco de dados SQL\\BancoDeDadosChurrosRV.db";
			Connection con = DriverManager.getConnection(url);
			String fornecedores = "insert into fornecedores (nome, telefone, produto_fornecido, endereco, preco) values (?, ?, ?, ?, ?);";
			PreparedStatement executor = con.prepareStatement(fornecedores);

			executor.setString(1, fornecedor.getNome());
			executor.setString(2, fornecedor.getTelefone());
			executor.setString(3, fornecedor.getProduto_fornecido());
			executor.setString(4, fornecedor.getEndereco());
			executor.setDouble(5, fornecedor.getPreco());

			executor.executeUpdate();
			executor.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Verifique seu banco de dados!" + e);
		}

		return fornecedor;
	}

	@Override
	public Fornecedor atualizar(Fornecedor fornecedor) {

		try {

			String url = "jdbc:sqlite:C:\\Users\\rapha\\Documents\\Banco de dados SQL\\BancoDeDadosChurrosRV.db";

			Connection con = DriverManager.getConnection(url);
			String fornecedores = "update fornecedores set nome = ?, telefone = ?, produto_fornecido = ?, endereco = ?, preco = ? where id = ?;";
			PreparedStatement executor = con.prepareStatement(fornecedores);

			executor.setString(1, fornecedor.getNome());
			executor.setString(2, fornecedor.getTelefone());
			executor.setString(3, fornecedor.getProduto_fornecido());
			executor.setString(4, fornecedor.getEndereco());
			executor.setDouble(5, fornecedor.getPreco());
			executor.setInt(6, fornecedor.getId());

			executor.executeUpdate();
			executor.close();
			con.close();
			return null;
		} catch (SQLException e) {
			System.out.println("ERRO: Verifique seu banco de dados!" + e);
		}
		return fornecedor;
	}

	@Override
	public Fornecedor buscarPorId(Integer id) {

		

		return null;
	}

	@Override
	public List<Fornecedor> listar() {

		List<Fornecedor> listaDeFornecedores = new ArrayList<>();
		
		String url = "jdbc:sqlite:C:\\Users\\rapha\\Documents\\Banco de dados SQL\\BancoDeDadosChurrosRV.db";

		try {

			Connection con = DriverManager.getConnection(url);

			Statement executor = con.createStatement();

			String fornecedores = "select * from fornecedores";

			ResultSet resultado = executor.executeQuery(fornecedores);

			while (resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");
				String telefone = resultado.getString("telefone");
				String produto_fornecido = resultado.getString("produto_fornecido");
				String endereco = resultado.getString("endereco");
				Double preco = resultado.getDouble("preco");

				Fornecedor p = new Fornecedor(id, nome, telefone, produto_fornecido, endereco, preco);
				listaDeFornecedores.add(p);

			}

			executor.close();
			con.close();

			con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("ERRO: Verifique seu banco de dados!" + e);
		}

		return listaDeFornecedores;
	}

	@Override
	public void apagar(Integer id) {

		try {
			String url = "jdbc:sqlite:C:\\Users\\rapha\\Documents\\Banco de dados SQL\\BancoDeDadosChurrosRV.db";

			Connection con;

			con = DriverManager.getConnection(url);

			String fornecedores = "delete from fornecedores where id = ?;";
			PreparedStatement executor = con.prepareStatement(fornecedores);

			executor.setInt(1, id);

			executor.executeUpdate();
			executor.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("ERRO: Verifique seu banco de dados!" + e);
		}
	}

}
