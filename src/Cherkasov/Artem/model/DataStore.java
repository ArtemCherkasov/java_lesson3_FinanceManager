package Cherkasov.Artem.model;
import java.util.Set;


public interface DataStore {
	
	User getUser(String name);	// return null if no such user
	Category getCategory(Integer id);
	Set<String> getUserNames();	// If no users, return empty collection (not null)
	Set<Account> getAccounts(User owner);	// If no accounts, return empty collection (not null)
	Set<Record> getRecords(Account account);	// If no records, return empty collection (not null)
	Set<Category> getCategories(); 
	void addUser(User user);
	void addAccount(User user, Account account);
	void addRecord(Account account, Record record);
	void addCategory(Category category);
	User removeUser(String name);	// return removed User or null if no such user
	Account removeAccount(User owner, Account account);	// return null if no such account
	Record removeRecord(Account from, Record record);	// return null if no such record
	
}
