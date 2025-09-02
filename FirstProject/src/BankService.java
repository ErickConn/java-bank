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
	
	public Client getAccount(String id) {
		Client client = accounts.get(id);
		return client;
	}
	
	public Transaction deposit(String id, int value) {
		Client client = this.getAccount(id);
		Transaction deposit = client.deposit(value);
		return deposit;
	}
	
	public Transaction withdraw(String id, int value) {
		Client client = this.getAccount(id);
		Transaction withdraw = client.withdraw(value);
		return withdraw;
	}
	
	public Transaction transfer(String idFrom, String idTo, int value) {
		Client clientTo = this.getAccount(idTo);
		Client clientFrom = this.getAccount(idFrom);
		
		if (clientTo.equals(null) || clientTo.equals(clientTo)) {
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
