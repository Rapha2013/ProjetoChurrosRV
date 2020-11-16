package br.edu.up.util;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dao.FornecedorDAO;
import br.up.edu.model.Fornecedor;

public class ProcessamentoFornecedores {

	public static void Fornecedores(Scanner sc) {

		FornecedorDAO fornecedorDAO = new FornecedorDAO();

		int i = 0;

		do {

			System.out.println("-----------MENU FORNECEDORES-----------");
			System.out.println("1 - ADICIONAR");
			System.out.println("2 - EDITAR");
			System.out.println("3 - APAGAR");
			System.out.println("4 - LISTAR");
			System.out.println("0 - SAIR");
			System.out.println();

			System.out.print("Qual opção deseja?: ");
			int menu = sc.nextInt();
			System.out.println();
			switch (menu) {
			case 1:
				System.out.println();
				sc.nextLine();
				System.out.println("----------ADICIONAR------------");
				System.out.print("Digite o Nome: ");
				String nome = sc.nextLine();

				System.out.print("Digite o telefone: ");
				String telefone = sc.nextLine();

				System.out.print("Digite o Produto Fornecido: ");
				String produto_fornecido = sc.nextLine();

				System.out.print("Digite o Endereço: ");
				String endereco = sc.nextLine();

				System.out.print("Digite o Preço: ");
				double preco = sc.nextDouble();

				Fornecedor fornecedor = new Fornecedor(nome, telefone, produto_fornecido, endereco, preco);
				fornecedorDAO.salvar(fornecedor);
				
				System.out.println();
				List<Fornecedor> listaDeFornecedores2 = fornecedorDAO.listar();
				for (Fornecedor f : listaDeFornecedores2) {
					System.out.println(f);
				}
				System.out.println();
				break;

			case 2:
				System.out.println();
				List<Fornecedor> listaDeFornecedores3 = fornecedorDAO.listar();
				for (Fornecedor f : listaDeFornecedores3) {
					System.out.println(f);
				}
				System.out.println();
				System.out.println("---------------EDITAR------------------");
				System.out.print("Digite o ID: ");
				int id = sc.nextInt();

				sc.nextLine();
				System.out.print("Digite o Nome: ");
				String nome2 = sc.nextLine();

				System.out.print("Digite o telefone: ");
				String telefone2 = sc.nextLine();

				sc.nextLine();
				System.out.print("Digite o Produto Fornecido: ");
				String produto_fornecido2 = sc.nextLine();

				System.out.print("Digite o Endereço: ");
				String endereco2 = sc.nextLine();

				System.out.print("Digite o Preço: ");
				double preco2 = sc.nextDouble();

				Fornecedor fornecedor2 = new Fornecedor(id, nome2, telefone2, produto_fornecido2, endereco2, preco2);
				fornecedorDAO.atualizar(fornecedor2);
				System.out.println();
				List<Fornecedor> listaDeFornecedores4 = fornecedorDAO.listar();
				for (Fornecedor f : listaDeFornecedores4) {
					System.out.println(f);
				}
				
				System.out.println();
				break;

			case 3:
				List<Fornecedor> listaDeFornecedores = fornecedorDAO.listar();
				for (Fornecedor f : listaDeFornecedores) {
					System.out.println(f);
				}
				
				System.out.println();
				System.out.println("---------APAGAR------------");
				System.out.print("Qual fornecedore deseja apagar? ");
				int deletForne = sc.nextInt();

				fornecedorDAO.apagar(deletForne);
				
				System.out.println();
				List<Fornecedor> listaDeFornecedores6 = fornecedorDAO.listar();
				for (Fornecedor f : listaDeFornecedores6) {
					System.out.println(f);
				}
				System.out.println();
				break;
			case 4:
				
				List<Fornecedor> listaDeFornecedor = fornecedorDAO.listar();
				for (Fornecedor f : listaDeFornecedor) {
					System.out.println(f);
				}
				System.out.println();
				break;
			case 0:
				i = 1;
				
				break;
			default:
				System.out.println("ERRO: Digite uma opção valida");

			}

		} while (i == 0);
	}

}
