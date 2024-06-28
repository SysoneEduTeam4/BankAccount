
public class Transaction {
	private String transactionDate;
	private String transactionTime;
	private String kind;
	private long amount;
	 private long balance;
	private DateTime datetime;
	
	public Transaction (String kind, long amount, long balance) {
		super();
		DateTime datetime = new DateTime();
		this.transactionDate = datetime.getDate();
		this.transactionTime = datetime.getTime();
		this.kind = kind;
		this.amount = amount;
		this.balance = balance;
	}
	public String getTransactionDate() {
		return transactionDate;
	}

	public String getTransactionTime() {
		return transactionTime;
	}
	
	public String getKind() {
		return kind;
	}
	
	public long getAmount() {
		return amount;
	}

	public long getBalance() {
		return balance;
	}
	public void printTransactionList() {
		System.out.println("[ 거래금액 :"+getAmount()+"원, 잔액 : "+getBalance()+"원 /"+getTransactionDate()+" "+getTransactionTime()+"]");
		
		
		
	}

	

}
