public class Main {
	public static void main (String[] args) {
		Client client1 = new Client();
		client1.setName("Rodolfo");
		client1.deposit(1000);
		client1.withdraw(500);
		
		Client client2 = new Client();
		client2.setName("Alberto");
		client2.deposit(2000);
		
		client2.addTransaction(1000, client1);
		client2.getBalance();
		client1.getBalance();
	}
}
