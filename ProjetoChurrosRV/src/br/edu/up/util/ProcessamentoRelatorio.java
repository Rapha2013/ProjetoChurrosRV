package br.edu.up.util;

import java.util.List;

import br.edu.up.dao.CardapioDAO;
import br.edu.up.dao.FornecedorDAO;
import br.edu.up.dao.VendasDAO;
import br.up.edu.model.Cardapio;
import br.up.edu.model.Fornecedor;
import br.up.edu.model.Vendas;

public class ProcessamentoRelatorio {
	
	public static void Relatorio() {
		System.out.println("Gerando relatório......");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ex) {
			System.out.println("ERRO: Verifique seu código!");
		}
		System.out.println("--------------RELATÓRIO VENDAS----------------");
		VendasDAO vendasDAO = new VendasDAO();
		List<Vendas> listaDeVenda1 = vendasDAO.listar();
		for (Vendas f : listaDeVenda1) {
			System.out.println(f);
		}
		System.out.println();
		System.out.println("--------------RELATÓRIO FORNECEDORES----------------");
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		List<Fornecedor> listaDeFornecedores2 = fornecedorDAO.listar();
		for (Fornecedor f : listaDeFornecedores2) {
			System.out.println(f);
		}
		System.out.println();
		System.out.println("--------------RELATÓRIO CARDAPIO----------------");
		CardapioDAO cardapioDAO = new CardapioDAO();
		List<Cardapio> listaDeCardapio = cardapioDAO.listar();
		for (Cardapio j : listaDeCardapio) {
			System.out.println(j);
		}
	}
}
