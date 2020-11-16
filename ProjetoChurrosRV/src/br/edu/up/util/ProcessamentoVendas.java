package br.edu.up.util;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dao.CardapioDAO;
import br.edu.up.dao.VendasDAO;
import br.up.edu.model.Cardapio;
import br.up.edu.model.Vendas;

public class ProcessamentoVendas {

	public static void Vendas(Scanner sc) {
		VendasDAO vendasDAO = new VendasDAO();

		int c = 0;

		do {
			
			System.out.println("-----------MENU VENDAS-----------");
			System.out.println("1 - NOVA VENDA");
			System.out.println("2 - EXCLUIR VENDA");
			System.out.println("3 - LISTAR");
			System.out.println("0 - SAIR");
			System.out.println();

			System.out.print("Qual opção deseja?: ");
			int menu = sc.nextInt();
			System.out.println();
			switch (menu) {
			case 1:

				CardapioDAO cardapioDAO = new CardapioDAO();
				List<Cardapio> listaDeCardapio = cardapioDAO.listar();
				for (Cardapio j : listaDeCardapio) {
					System.out.println(j);
				}
				System.out.println();
				sc.nextLine();
				System.out.println("----------NOVA VENDA------------");
				System.out.print("Digite o Nome: ");
				String nome_cliente = sc.nextLine();

				System.out.print("Digite a quantidade: ");
				int quantidade = sc.nextInt();
				
				sc.nextLine();
				System.out.print("Digite o produto: ");
				String produto_escolhido = sc.nextLine();
				
				System.out.print("Digite o Preço: ");
				double preco = sc.nextDouble();
				
				sc.nextLine();
				System.out.print("Deseja Adicionar uma obs [S/N]: ");
				String ob = sc.nextLine();
				
				String obs;
				
				if (ob.equals("s") || ob.equals("S")) {
					System.out.print("Digite a observação: ");
					obs = sc.nextLine();
				}else {
					obs = "SEM OBSERVAÇÃO";
				}
				

				Vendas vendas = new Vendas(nome_cliente, quantidade, produto_escolhido, obs, preco);
				vendasDAO.salvar(vendas);
				System.out.println();
				break;
			case 2:
				
				List<Vendas> listaDeVenda1 = vendasDAO.listar();
				for (Vendas f : listaDeVenda1) {
					System.out.println(f);
				}
				System.out.println();
				System.out.print("Qual vendas deseja excluir: ");
				int deletForne = sc.nextInt();

				vendasDAO.apagar(deletForne);
				
				System.out.println();
				List<Vendas> listaDeVenda2 = vendasDAO.listar();
				for (Vendas f : listaDeVenda2) {
					System.out.println(f);
				}
				System.out.println();
				break;
			case 3:
				
				List<Vendas> listaDeVenda = vendasDAO.listar();
				for (Vendas f : listaDeVenda) {
					System.out.println(f);
				}
				System.out.println();
				break;
			case 0:
				c = 1;
				break;
			default:
				System.out.println();
				System.out.println("ERRO: Digite uma opção valida");
				System.out.println();
				break;
			}

		} while (c == 0);
	}
}
