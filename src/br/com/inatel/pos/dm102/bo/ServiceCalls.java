package br.com.inatel.pos.dm102.bo;

import java.util.Calendar;
import java.util.Scanner;

import br.com.inatel.pos.dm102.model.Service;
import br.com.inatel.pos.dm102.dao.ServiceDAO;;

public class ServiceCalls {
	
	private ServiceDAO serviceDAO = new ServiceDAO();
	Scanner in = new Scanner(System.in);
	
	public int registerService() {
		
		ServiceDAO serviceDAO = new ServiceDAO();
		
		Service service = new Service();
		service.setDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		
		System.out.println("*** Criar atendimento ***");
		System.out.println("* Digite o código do cliente: ");
		service.setClient(serviceDAO.getClient(Integer.parseInt(in.nextLine())));	

		System.out.println("* Qual é o tipo de chamado: ");
		service.setServiceType(in.nextLine());

		serviceDAO.newService(service);
		
		System.out.println("*** Serviço criado! ***");
		System.out.println("\n\n");
		
		return 0;
	}
	
	public void listService() {
		
		System.out.println("*** Lista de atendimentos ***");

		for (Service service : serviceDAO.listServices()) {
			
			System.out.println("* Nome: " +service.getClient().getName());
			System.out.println("* Documento: " +service.getClient().getDocumentType());
			System.out.println("* Telefone: " +service.getClient().getPhone());
			System.out.println("* Data do Serviço: " +service.getDate());
			System.out.println("* Tipo do Serviço" +service.getServiceType());
		}
		System.out.println("\n\n");
	}

	
		
}


