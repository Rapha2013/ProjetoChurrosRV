package br.edu.up.sistema;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dao.CardapioDAO;
import br.edu.up.dao.FornecedorDAO;
import br.edu.up.dao.VendasDAO;
import br.edu.up.util.ProcessamentoCardapio;
import br.edu.up.util.ProcessamentoFornecedores;
import br.edu.up.util.ProcessamentoMenu;
import br.edu.up.util.ProcessamentoRelatorio;
import br.edu.up.util.ProcessamentoVendas;
import br.up.edu.model.Cardapio;
import br.up.edu.model.Fornecedor;
import br.up.edu.model.Vendas;

public class Programa {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int i = 0;

		do {
			int valor = ProcessamentoMenu.Menu(sc);
			switch (valor) {
			case 1:
				ProcessamentoVendas.Vendas(sc);
				break;
			case 2:
				ProcessamentoFornecedores.Fornecedores(sc);
				break;
			case 3:
				ProcessamentoCardapio.Cardapio(sc);
				break;
			case 4:
				break;
			case 5:
				ProcessamentoRelatorio.Relatorio();
				break;
			case 0:
				i = 1;
				break;
			default:
				System.out.println("ERRO: OPÇÃO INVALIDA");
			}

		} while (i == 0);

	}

	



}
