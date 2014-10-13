package Cherkasov.Artem.view;

import Cherkasov.Artem.model.Account;
import Cherkasov.Artem.model.Category;

public class ComboItem {
	
	private String key;
	private Account account;
	private Category category;
	
	public ComboItem(String key, Account account){
		this.key = key;
	    this.account = account;
	}
	
	public ComboItem(String key, Category category){
		this.key = key;
	    this.category = category;
	}
	
	@Override
	public String toString(){
		return key;
	}
	
	public String getKey(){
		return key;
	}
	
	public Account getAccount(){
		return account;
	}
	
	public Category getCategory(){
		return category;
	}

}
