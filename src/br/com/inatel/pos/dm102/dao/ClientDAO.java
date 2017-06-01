package br.com.inatel.pos.dm102.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.inatel.pos.dm102.model.Client;
import br.com.inatel.pos.dm102.dao.DataBase;

public class ClientDAO extends DataBase<Client, Serializable>  {

	public void newClient(Client client) {

		String query = "INSERT INTO public.client(documentType, documentNumber, name, phone) VALUES (?, ?, ?, ?) returning id";

		try {
			getPreparedStatement(query);

			ps.setString(1, client.getDocumentType());
			ps.setString(2, client.getDocumentNumber());
			ps.setString(3, client.getName());
			ps.setString(4, client.getPhone());

			ResultSet rs = ps.executeQuery();
			rs.next();
			int id = rs.getInt(1);
			System.out.println("id do cliente: "+id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Client> listClients() {

		String query = "SELECT documentType, documentNumber, name, phone FROM public.client;";
		List<Client> clients = new ArrayList<>();
		try {
			getPreparedStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Client client = new Client();
				client.setDocumentType(rs.getString("documentType"));
				client.setDocumentNumber(rs.getString("documentNumber"));
				client.setName(rs.getString("name"));
				client.setPhone(rs.getString("phone"));
				
				clients.add(client);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return clients;

	}

	
}
