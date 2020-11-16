package br.edu.up.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.up.edu.model.Cardapio;

public class CardapioDAO implements DAO<Cardapio> {

	@Override
	public Cardapio salvar(Cardapio cardapio) {

		try {

			String url = "jdbc:sqlite:C:\\Users\\rapha\\Documents\\Banco de dados SQL\\BancoDeDadosChurrosRV.db";
			Connection con = DriverManager.getConnection(url);
			String listar = "insert into cardapio (nome, descricao, preco) values (?, ?, ?);";
			PreparedStatement executor = con.prepareStatement(listar);

			executor.setString(1, cardapio.getNome());
			executor.setString(2, cardapio.getDescricao());
			executor.setDouble(3, cardapio.getPreco());

			executor.executeUpdate();
			executor.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Verifique seu banco de dados!" + e);
		}

		return cardapio;
	}

	@Override
	public Cardapio atualizar(Cardapio cardapio) {
		try {

			String url = "jdbc:sqlite:C:\\Users\\rapha\\Documents\\Banco de dados SQL\\BancoDeDadosChurrosRV.db";

			Connection con = DriverManager.getConnection(url);
			String atualizar = "update cardapio set nome = ?, descricao = ?, preco = ? where id = ?;";
			PreparedStatement executor = con.prepareStatement(atualizar);

			executor.setString(1, cardapio.getNome());
			executor.setString(2, cardapio.getDescricao());
			executor.setDouble(3, cardapio.getPreco());
			executor.setInt(4, cardapio.getId());

			executor.executeUpdate();
			executor.close();
			con.close();
			return null;
		} catch (SQLException e) {
			System.out.println("ERRO: Verifique seu banco de dados!" + e);
		}
		return cardapio;
	}

	@Override
	public Cardapio buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cardapio> listar() {
		List<Cardapio> listaDeCardapio = new ArrayList<>();

		String url = "jdbc:sqlite:C:\\Users\\rapha\\Documents\\Banco de dados SQL\\BancoDeDadosChurrosRV.db";

		try {

			Connection con = DriverManager.getConnection(url);

			Statement executor = con.createStatement();

			String cardapio = "select * from cardapio";

			ResultSet resultado = executor.executeQuery(cardapio);

			while (resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");
				String descricao = resultado.getString("descricao");
				Double preco = resultado.getDouble("preco");

				Cardapio j = new Cardapio(id, nome, descricao, preco);
				listaDeCardapio.add(j);

			}

			executor.close();
			con.close();

			con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("ERRO: Verifique seu banco de dados! ---- " + e);
		}

		return listaDeCardapio;
	}

	@Override
	public void apagar(Integer id) {

		try {
			String url = "jdbc:sqlite:C:\\Users\\rapha\\Documents\\Banco de dados SQL\\BancoDeDadosChurrosRV.db";

			Connection con = DriverManager.getConnection(url);

			String delet = "delete from cardapio where id = ?;";
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
