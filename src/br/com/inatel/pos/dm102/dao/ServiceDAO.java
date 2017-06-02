package br.com.inatel.pos.dm102.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


import br.com.inatel.pos.dm102.dao.DataBase;
import br.com.inatel.pos.dm102.model.Service;
import br.com.inatel.pos.dm102.model.Client;



public class ServiceDAO extends DataBase<Service, Serializable>  {
	


	public void newService(Service service) {

		String query = "INSERT INTO public.service(date, serviceDescription, idcliente_fk) VALUES (?, ?, ?)";

		try {
			getPreparedStatement(query);

			ps.setDate(1, service.getDate());
			ps.setString(2, service.getServiceDescription());
			ps.setInt(3, service.getClient().getId());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Service> listServices() {

		String query = "SELECT serviceDescription, date, id, idcliente_fk FROM public.service;";
		List<Service> services = new ArrayList<>();
		try {
			getPreparedStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Service service = new Service();
				service.setDate(rs.getDate("date"));
				service.setServiceDescription(rs.getString("serviceDescription"));
				service.setClient(getClient(rs.getInt("idcliente_fk")));
				
				services.add(service);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return services;

	}



	public Client getClient(int id) {
		Client client = null;
		String query = "SELECT documentType, documentNumber, name, address, phone FROM public.client where id = " + id;
		try {
			getPreparedStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				client = new Client();
				client.setDocumentType(rs.getString("documentType"));
				client.setDocumentNumber(rs.getString("documentNumber"));
				client.setName(rs.getString("name"));
				client.setAddress(rs.getString("address"));
				client.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return client;
	}

	
}
