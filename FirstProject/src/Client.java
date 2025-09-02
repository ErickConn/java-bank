public class Client {
	private static int nextId = 1;
	private int id = nextId++;
	private String name;
	private double balance;
	private String password;
	
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
	
	void setPassword(String password) {
		this.password = password;
	}
	
	String getPassword() {
		return this.password;
	}
	
	public Transaction deposit(int value) {
		Transaction deposit = new Transaction(1, value, this.getId(), this.getId());
		double newBalance = this.getBalance() + value;
		setBalance(newBalance);
		return deposit;
	}
	
	public Transaction withdraw(int value) {
		if(this.balance < value) {
			return null;
		}
		Transaction withdraw = new Transaction(2, value, this.getId(), this.getId());
		double newBalance = this.getBalance() - value;
		setBalance(newBalance);
		return withdraw;
	}
}
