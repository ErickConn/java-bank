import java.util.HashMap;
import java.util.Map;

public class BankService {
	private Map<String, Client> accounts = new HashMap<>();
	
	public Client createAccount(String name, String password) {
		Client client = new Client();
		client.setName(name);
		client.setPassword(password);
		accounts.put(client.getName(), client);
		return client;
	}
	
	public Client getAccount(String name) {
		Client client = accounts.get(name);
		return client;
	}
	
	public Client login(String name, String password) {
		Client account = this.getAccount(name);
		if (account.getPassword().equals(password)) {
			return account;
		}else {
			return null;
		}
	}
	
	public Transaction deposit(String name, int value) {
		Client client = this.getAccount(name);
		Transaction deposit = client.deposit(value);
		return deposit;
	}
	
	public Transaction withdraw(String name, int value) {
		Client client = this.getAccount(name);
		Transaction withdraw = client.withdraw(value);
		return withdraw;
	}
	
	public Transaction transfer(String nameFrom, String nameTo, int value) {
		Client clientTo = this.getAccount(nameTo);
		Client clientFrom = this.getAccount(nameFrom);
		
		if (clientTo.equals(null) || clientTo.equals(clientFrom)) {
			System.out.println("Cliente não é válido.");
			return null;
		}
		
		if(clientFrom.getBalance() < value) {
			System.out.println("Fundos insuficientes "+ "Saldo atual: " + clientFrom.getBalance());
			return null;
		}
		
		Transaction transference = new Transaction(3, value, clientFrom.getId(), clientTo.getId());
		double newBalanceCl1 = clientFrom.getBalance() - value;
		clientFrom.setBalance(newBalanceCl1);
		double newBalanceCl2 = clientTo.getBalance() + value;
		clientTo.setBalance(newBalanceCl2);
		
		return transference;
	}
	
	public void showAllAccounts() {
		if (accounts.isEmpty()) {
	        System.out.println("Nenhuma conta encontrada.");
	        return;
	    }
		
		for (String id : accounts.keySet()) {
		    Client client = accounts.get(id);
		    System.out.println("ID: " + id + " | Nome: " + client.getName());
		}
	}
}
