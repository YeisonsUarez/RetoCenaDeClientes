package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ClientModel;

public class DBController {

	private String connectionURL;

	public DBController() {
		connectionURL = "jdbc:mysql://localhost:3306/evalart_reto";
	}

	public List<ClientModel> getClients(String command) {
		List<ClientModel> clients= new ArrayList<ClientModel>();
		try {
			Connection connection = DriverManager.getConnection(this.connectionURL, "root", "Pi3141592654");//Establishing connection with DB
			PreparedStatement preparedStatement=connection.prepareStatement(command);
			ResultSet resultSet=preparedStatement.executeQuery();
	        while(resultSet.next()){
	             
	             ClientModel client= new ClientModel();
	             client.setId(resultSet.getInt("id"));
	             client.setCode(resultSet.getString("code"));
	             client.setCompany(resultSet.getString("company"));
	             client.setLocation(resultSet.getString("location"));
	             client.setType(resultSet.getInt("type"));
	             client.setMale(resultSet.getBoolean("male"));
	             client.setEncrypt(resultSet.getBoolean("encrypt"));
	             clients.add(client);
	        
	        }
	        preparedStatement.close();
	        resultSet.close();
	        connection.close();
		} catch (SQLException e) {
	         System.out.println("Error in Select Data:"+ e.getMessage());
	         
		}
		
		return clients;
	}

}


