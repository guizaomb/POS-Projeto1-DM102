package br.com.inatel.pos.dm102.bo;

import java.util.Scanner;

import br.com.inatel.pos.dm102.dao.ClientDAO;
import br.com.inatel.pos.dm102.model.Client;

public class ClientController {
	
	Scanner in = new Scanner(System.in);
	ClientDAO clientDAO = new ClientDAO();
	
	public int newClient() {
				
		System.out.println("***Tipo de Pessoa***");
		System.out.println("* 1 - Pessoa Fisica");
		System.out.println("* 2 - Pessoa Juridica");
		System.out.println("* 3 - Sair do cadastro");

		System.out.println("Escolha o tipo de pessoa: ");

		int op = Integer.parseInt(in.nextLine());

		if(op == 1){
		
			Client client = new Client();
			System.out.println("*** Pessoa Fisica ***");
			client.setDocumentType("CPF");
			System.out.println("* Entre com o Número do CPF:");
			client.setDocumentNumber(in.nextLine());
			System.out.println("* Entre com o nome:");
			client.setName(in.nextLine());
			System.out.println("* Entre com o endereço:");
			client.setAddress(in.nextLine());
			System.out.println("* Entre com o telefone:");
			client.setPhone(in.nextLine());
			
			clientDAO.saveClient(client);
			
			return 0;
								
		} else if (op == 2) {
			Client client = new Client();
			System.out.println("*** Pessoa Juridica ***");
			client.setDocumentType("CNPJ");
			System.out.println("* Entre com o numero do CNPJ:");
			client.setDocumentNumber(in.nextLine());
			System.out.println("* Entre com a Razão Social:");
			client.setName(in.nextLine());
			System.out.println("* Entre com o endereço:");
			client.setAddress(in.nextLine());
			System.out.println("* Entre com o telefone:");
			client.setPhone(in.nextLine());
	
			clientDAO.saveClient(client);
			
			return 0;
			
		} else {
			return 0;
		}				
		
		
	}
	
	public void listClients() {
		
		System.out.println("*** Lista de atendimentos ***");

		for (Client client : clientDAO.listClients()) {
			
			System.out.println("* Tipo Documento: " +client.getDocumentType());
			System.out.println("* Documento Número: " +client.getDocumentNumber());
			System.out.println("* Nome: " +client.getName());
			System.out.println("* Endereço: " +client.getAddress());
			System.out.println("* Telefone: " +client.getPhone());
			
		}
		System.out.println("\n\n");
	}

}
