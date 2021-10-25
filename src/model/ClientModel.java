package model;

public class ClientModel {
	private int id;
	private String code;
	private Boolean male;
	private int type;
	private String location; 
	private String company; 
	private Boolean encrypt;
	public ClientModel() {
		
	}
	public ClientModel(int id, String code, Boolean male, int type, String location, String company, Boolean encrypt) {
		super();
		this.id = id;
		this.code = code;
		this.male = male;
		this.type = type;
		this.location = location;
		this.company = company;
		this.encrypt = encrypt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Boolean getMale() {
		return male;
	}
	public void setMale(Boolean male) {
		this.male = male;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Boolean getEncrypt() {
		return encrypt;
	}
	public void setEncrypt(Boolean encrypt) {
		this.encrypt = encrypt;
	}
	
	
	
	
}
