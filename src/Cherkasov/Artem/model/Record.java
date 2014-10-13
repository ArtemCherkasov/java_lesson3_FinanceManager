package Cherkasov.Artem.model;

public class Record {
	
	private Integer id;
	private Account account;
	private Double funds = 0.0;
	private Category category;
	private String date;
	
	public Integer getId() {
		
		return id;
		
	}
	
	public void setId(Integer id) {
		
		this.id = id;
		
	}
	
	public Account getAccount() {
		
		return account;
		
	}
	
	public void setAccount(Account account) {
		
		this.account = account;
		
	}
	
	public Double getFunds() {
		
		return funds;
		
	}
	
	public void setFunds(Double funds) {
		
		this.funds = funds;
		
	}
	
	public Category getCategory() {
		
		return category;
		
	}
	
	public void setCategory(Category category) {
		
		this.category = category;
		
	}
	
	public String getDate() {
		
		return date;
		
	}
	
	public void setDate(String date) {
		
		this.date = date;
		
	}

}
