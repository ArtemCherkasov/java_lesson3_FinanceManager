package Cherkasov.Artem.model;

public class User {
	
	private String login;
	private String password;
	private String name;
	private String surname;
	
	public String getLogin() {
		
		return login;
		
	}
	
	public void setLogin(String login) {
		
		this.login = login;
		
	}
	
	public String getPassword() {
		
		return password;
		
	}
	
	public void setPassword(String password) {
		
		this.password = password;
		
	}
	
	public void setPassword(char[] c) {
		
		this.password = "";
		
		for (Integer i = 0; i < c.length; ++i){
			
			this.password +=c[i];
			
		}
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}

	public String getSurname() {
		
		return surname;
		
	}

	public void setSurname(String surname) {
		
		this.surname = surname;
		
	}

}
