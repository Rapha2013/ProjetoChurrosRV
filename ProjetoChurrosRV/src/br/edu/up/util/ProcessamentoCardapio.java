package br.edu.up.util;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dao.CardapioDAO;
import br.up.edu.model.Cardapio;

public class ProcessamentoCardapio {

	public static void Cardapio(Scanner sc) {

		CardapioDAO cardapioDAO = new CardapioDAO();

		int c = 0;

		do {

			System.out.println("-----------MENU CARDAPIO-----------");
			System.out.println("1 - ADICIONAR");
			System.out.println("2 - EDITAR");
			System.out.println("3 - APAGAR");
			System.out.println("4 - LISTAR");
			System.out.println("0 - SAIR");
			System.out.println();

			System.out.print("Qual opção deseja: ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				System.out.println();
				List<Cardapio> listaDeCardapio = cardapioDAO.listar();
				for (Cardapio j : listaDeCardapio) {
					System.out.println(j);
				}
				sc.nextLine();
				System.out.println();
				System.out.println("----------ADICIONAR------------");
				System.out.print("Digite o Nome: ");
				String nome = sc.nextLine();

				System.out.print("Digite a descrição: ");
				String descricao = sc.nextLine();

				System.out.print("Digite o Preço: ");
				double preco = sc.nextDouble();

				Cardapio cardapio = new Cardapio(nome, descricao, preco);
				cardapioDAO.salvar(cardapio);
				System.out.println();
				break;
				
			case 2:
				System.out.println();
				List<Cardapio> listaDeCardapio3 = cardapioDAO.listar();
				for (Cardapio j : listaDeCardapio3) {
					System.out.println(j);
				}
				System.out.println();
				System.out.println("---------------EDITAR------------------");
				System.out.print("Digite o ID: ");
				int id = sc.nextInt();

				sc.nextLine();
				System.out.print("Digite o Nome: ");
				String nome2 = sc.nextLine();

				System.out.print("Digite a descrição: ");
				String descricao2 = sc.nextLine();

				System.out.print("Digite o Preço: ");
				double preco2 = sc.nextDouble();

				Cardapio cardapio2 = new Cardapio(id, nome2, descricao2, preco2);
				cardapioDAO.atualizar(cardapio2);
				System.out.println();
				break;

			case 3:
				System.out.println();
				System.out.println("--------CARDAPIO-----------");
				List<Cardapio> listaDeCardapio2 = cardapioDAO.listar();
				for (Cardapio j : listaDeCardapio2) {
					System.out.println(j);
				}
				System.out.println();
				System.out.print("Qual opção deseja apagar? ");
				int deletForne = sc.nextInt();
				
				cardapioDAO.apagar(deletForne);
				System.out.println();
				break;
			case 4:
				System.out.println();
				System.out.println("----------LISTA DE CARDAPIO-------------");
				List<Cardapio> listaDeCardapio4 = cardapioDAO.listar();
				for (Cardapio j : listaDeCardapio4) {
					System.out.println(j);
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
