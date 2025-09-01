public class Client {
	private static int nextId = 1;
	private int id = nextId++;
	private String name;
	private double balance;
	
	int getId() {
		return this.id;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return this.name;
	}
	
	void setBalance(double balance) {
		this.balance = balance;
	}
	
	double getBalance() {
		return this.balance;
	}
	
	public void deposit(int value) {
		Transaction deposit = new Transaction(1, value, this.getId(), this.getId());
		double newBalance = this.getBalance() + value;
		setBalance(newBalance);
		if(deposit != null) {
			System.out.println("Déposito realizado com sucesso. "+"Novo saldo: " + this.getBalance());
			System.out.println(deposit.printTransaction());
		}
	}
	
	public void withdraw(int value) {
		if(this.balance < value) {
			System.out.println("Fundos insuficientes. "+ "Saldo atual: " + this.getBalance());
			return;
		}
		Transaction withdraw = new Transaction(2, value, this.getId(), this.getId());
		double newBalance = this.getBalance() - value;
		setBalance(newBalance);
		if(withdraw != null) {
			System.out.println("Saque realizado com sucesso. "+"Novo saldo: " + this.getBalance());
			System.out.println(withdraw.printTransaction());
		}
	}
	
	public void addTransaction(int value, Client clientTo) {
		if (clientTo == null || clientTo == this) {
			System.out.println("Cliente não é válido.");
			return;
		}
		
		if(this.balance < value) {
			System.out.println("Fundos insuficientes "+ "Saldo atual: " + this.getBalance());
			return;
		}
		
		Transaction transference = new Transaction(3, value, this.getId(), clientTo.getId());
		double newBalanceCl1 = this.getBalance() - value;
		setBalance(newBalanceCl1);
		double newBalanceCl2 = clientTo.getBalance() + value;
		clientTo.setBalance(newBalanceCl2);
		if (transference != null) {
			System.out.println("Transferência realizada com sucesso.");
			System.out.println(this.getName() + ": " + this.getBalance());
			System.out.println(clientTo.getName() + ": " + clientTo.getBalance());
			System.out.println(transference.printTransaction());
		}
		
		
	}
}
