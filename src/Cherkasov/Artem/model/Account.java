package Cherkasov.Artem.model;

public class Account {
	
	private Integer id;
	private User user;
	private Double funds = 0.0;
	
	public Integer getId() {
		
		return id;
		
	}
	
	public void setId(Integer id) {
		
		this.id = id;
		
	}
	
	public User getUser() {
		
		return user;
		
	}
	
	public void setUser(User user) {
		
		this.user = user;
		
	}
	
	public Double getFunds() {
		
		return funds;
		
	}
	
	public void setFunds(Double funds) {
		
		this.funds = funds;
		
	}

}
