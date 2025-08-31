// This file will deal with accounts and transactions logic and conditions
import java.util.HashMap;
import java.util.Map;

public class BankService {
	private Map<String, Client> accounts = new HashMap<>();
	
	public Client createAccount(String name) {
		Client client = new Client();
		client.setName(name);
		accounts.put(Integer.toString(client.getId()), client);
		return client;
	}
	
	public Client getAccount(String id) {
		Client client = accounts.get(id);
		return client;
	}
	
	public void deposit() {
		
	}
	
	public void withdraw() {
		
	}
	
	public void transfer() {
		
	}
	
	public void showAllAccounts() {
		
	}
}
