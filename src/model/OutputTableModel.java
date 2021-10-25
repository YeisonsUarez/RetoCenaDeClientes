package model;

import java.util.List;

public class OutputTableModel {

	private String name;
	private List<ClientModel> clients;
	
	public OutputTableModel() {
		super();
	}

	public OutputTableModel(String name, List<ClientModel> clients) {
		super();
		this.name = name;
		this.clients = clients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ClientModel> getClients() {
		return clients;
	}

	public void setClients(List<ClientModel> clients) {
		this.clients = clients;
	}
	
	
	
	
}
