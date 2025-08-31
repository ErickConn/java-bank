import java.time.LocalDateTime;

public class Transaction {
	private LocalDateTime idTransaction;
	private int value;
	private int type;
	private int idTo;
	private int idFrom;
	
	public Transaction(int type, int value, int idTo, int idFrom){
		this.idTransaction = LocalDateTime.now();
		this.type = type;
		this.value = value;
		this.idTo = idTo;
		this.idFrom = idFrom;
	}
	
	public LocalDateTime getId() {
		return this.idTransaction;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getType() {
		return type;
	}
	
	public int getIdTo() {
		return this.idTo;
	}
	
	public int getIdFrom() {
		return this.idFrom;
	}
	
	public Transaction printTransaction() {
		System.out.println("Transaction details: " + this.getId() + " " + this.getValue() + " " +  this.getType() + " " + this.getIdTo() + " " + this.getIdFrom());
		return this;
	}
	
}
