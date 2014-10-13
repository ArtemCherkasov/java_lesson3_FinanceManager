package Cherkasov.Artem.test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Cherkasov.Artem.model.Account;
import Cherkasov.Artem.model.Category;
import Cherkasov.Artem.model.DataStoreImpl;
import Cherkasov.Artem.model.Record;
import Cherkasov.Artem.model.User;

public class TestDB{
	
	DataStoreImpl dataStoreImpl = new DataStoreImpl();
	
	@Before
	public void putData(){
		
		User user = new User();
		user.setLogin("randomUser");
		user.setName("USER");
		user.setSurname("SURNAME");
		user.setPassword("password");
		
		if (dataStoreImpl.getUser(user.getLogin()) == null)
			dataStoreImpl.addUser(user);
		
		Account account = new Account();
		account.setUser(user);
		account.setFunds(19700.50);
		
		if (dataStoreImpl.getAccounts(user).isEmpty())
			dataStoreImpl.addAccount(user, account);
		
		Category category = new Category();
		category.setDescription("test description");
		
		if (dataStoreImpl.getCategories().isEmpty())
			dataStoreImpl.addCategory(category);
		
		Iterator<Category> itCatecory = dataStoreImpl.getCategories().iterator();
		category = itCatecory.next();
		
		Iterator<Account> itAccount = dataStoreImpl.getAccounts(user).iterator();
		account = itAccount.next();
		
		if (dataStoreImpl.getRecords(account).isEmpty()){
			
			for (Integer i = 0; i < 10; ++i){
				
				Record record = new Record();
				record.setAccount(account);
				record.setCategory(category);
				record.setFunds(new Random().nextDouble()*50);
				dataStoreImpl.addRecord(account, record);
				
			}
			
		}
		
	}
	
	@Test
	public void testData(){
		
		User user = dataStoreImpl.getUser("randomUser");
		Set<Account> accounts = dataStoreImpl.getAccounts(user);
		Set<Record> records = new HashSet<Record>();
		
		for (Account a: accounts){
			
			records.addAll(dataStoreImpl.getRecords(a));
			
		}
		
		assertEquals(10, records.size());
		//dataStoreImpl.removeUser("randomUser");
		records = new HashSet<Record>();
		
		for (Account a: accounts){
			
			records.addAll(dataStoreImpl.getRecords(a));
			
		}
		
		//assertEquals(0, records.size());
		
	}

}
