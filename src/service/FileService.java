package service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.FilterModel;
import model.InputTableModel;


public class FileService {
	private static String REGEX_SEPARATOR_TABLES = "\\<";
	private static String REGEX_SEPARATOR_FILTERS = "\\n";
	private static String REGEX_SEPARATOR_VARIABLE = ":";


	private static String readFileAsString(String fileName) {
		try {
			String data = "";
			data = new String(Files.readAllBytes(Paths.get(fileName)));
			return data;
		} catch (Exception e) {
			System.out.println("Error in Read File: " + e.getMessage());
			return "";
		}

	}

	public static List<InputTableModel> processInput(String filename) {
		

		String textInput = readFileAsString(filename);

		String[]  separateTables = Arrays.stream(textInput.split(REGEX_SEPARATOR_TABLES)).filter(e -> e.trim().length() > 0).toArray(String[]::new);
		
		List<InputTableModel> tables= new ArrayList<InputTableModel>();
		

		for (String tableItem : separateTables) {
			tables.add(convertInputToTableModel(tableItem));
		}
		
		return tables;
	}

	private static InputTableModel convertInputToTableModel(String inputTableText) {
		InputTableModel table = new InputTableModel();
		
		table.setName(getTableName(inputTableText));
		table.setFilters(getFilters(inputTableText));
		return table;
	}
	
	private static String getTableName(String tableText) {
		String tableName="";
		try {
			
			tableName= tableText.substring(0, tableText.indexOf(">"));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return tableName;
	}
	
	private static List<FilterModel> getFilters(String tableText){
		List<FilterModel> filters= new ArrayList<FilterModel>();
		try {
			String[] separateFilters = Arrays.stream(tableText.split(REGEX_SEPARATOR_FILTERS)).filter(e -> e.trim().length() > 0).toArray(String[]::new);
			
			for(int i=1; i<separateFilters.length;i++) {
				String [] valuesFilter= separateFilters[i].split(REGEX_SEPARATOR_VARIABLE);
				FilterModel filter= new FilterModel();
				filter.setVariable(valuesFilter[0]);
				filter.setValue(valuesFilter[1]);
				filters.add(filter);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());

		}
			
		return filters;
	}
}
