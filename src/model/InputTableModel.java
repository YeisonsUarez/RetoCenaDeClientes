package model;

import java.util.List;

public class InputTableModel {

	private String name;
	private List<FilterModel> filters;
	
	
	public InputTableModel() {
	
		
	}


	public InputTableModel(String name, List<FilterModel> filters) {
		super();
		this.name = name;
		this.filters = filters;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<FilterModel> getFilters() {
		return filters;
	}


	public void setFilters(List<FilterModel> filters) {
		this.filters = filters;
	}


	
	
	
	
}
