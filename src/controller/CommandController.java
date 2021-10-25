package controller;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import model.FilterModel;
import model.InputTableModel;

public class CommandController {

	public static String getCommand(InputTableModel table) {
		
		StringBuilder sb= new StringBuilder();
		
		sb.append("Select * from client, account where account.client_id=client.id ");
		for (FilterModel filter : table.getFilters()) {
			switch(filter.getVariable())
	        {
	            case "TC":
	            	sb.append(" AND type="+filter.getValue());
	                break;
	            case "UG":
	            	sb.append(" AND location="+filter.getValue());
	                break;
	            case "RI":
	            	sb.append(" AND (select SUM(balance)from account where account.client_id=client.id)>="+filter.getValue());
	                break;
	            case "RF":
	            	sb.append(" AND (select SUM(balance)from account where account.client_id=client.id)<="+filter.getValue());
	                break;
	            default:
	                System.out.println("no match");
	        }
		}
		sb.append(" GROUP BY client.company order by balance,client.code asc LIMIT 8");
		return sb.toString();
	}
	
	
	
	
	
}
//(select SUM(balance)from account where account.client_id=client.id)