package br.com.inatel.pos.dm102.bo;

import java.util.Scanner;

public class Principal {
	
	public void menu (){
				
		Scanner in = new Scanner(System.in);

			int option = 0;
			
			while (option != 5){
				
				System.out.println(" * 1 - Cadastro Cliente");
				System.out.println(" * 2 - Cadastro Serviço");
				System.out.println(" * 3 - Listar Clientes");
				System.out.println(" * 4 - Pesquisar Serviço");
				System.out.println(" * 5 - Sair");
				
				option = Integer.parseInt(in.nextLine());
				
				switch (option) {
					
				case 1: {
					Customer customer = new Customer ();
					customer.newClient();
					break;
					}
				case 2: {
					ServiceCalls serviceCalls = new ServiceCalls();
					serviceCalls.registerService();
				}
				case 3: {
					Customer customer = new Customer();
					customer.listClients();					
				}
				case 4: {
					ServiceCalls serviceCalls = new ServiceCalls();
					serviceCalls.listService();
				}
				case 5: {
					System.out.println("Finalizando!");
					break;	
				}
				default: break;
				}
		}
	}
}
