package br.edu.up.util;

import java.util.Scanner;

public class ProcessamentoMenu {

	public static int Menu(Scanner sc) {
		System.out.println("\nSistema Comercial de Controle de Vendas Churros RV");
		System.out.println("\n");
		System.out.print("                           --MENU--          ");
		System.out.println("\n                  ----------------------------");
		System.out.println("                  |     1 - Vendas           |");
		System.out.println("                  |     2 - Fornecedores     |");
		System.out.println("                  |     3 - Cardapio         |");
		System.out.println("                  |     4 - Compras          |");
		System.out.println("                  |     5 - Relatório Geral  |");
		System.out.println("                  |     0 - Sair             |");
		System.out.println("                  ----------------------------\n");
		System.out.println();

		System.out.print("Digite a opção desejada: ");
		int valor = sc.nextInt();
		System.out.println();
		return valor;
	}
	
}
