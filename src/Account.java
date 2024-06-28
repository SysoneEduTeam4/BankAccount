
public class Account {
	private String accountNo;
	private String name;
	private long balance;
	private Transaction[] transactions;

	public Account(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public Account(String accountNo, String name) {
		this.accountNo = accountNo;
		this.name = name;
		this.balance = 0;
		this.transactions = new Transaction[10];  
	}
	
	public Account(String accountNo, String name, long balance, Transaction[] transactions) {
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
		this.transactions = new Transaction[10];
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBalance() {
		return balance;
	}
  
	//잔고
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	//거래내역 메서드
	public Transaction[] getTransactions() {
		return transactions;
		
	}

	public void setTransactions(Transaction[] transactions) {
		
		this.transactions = transactions;
	}

	//입금 메서드
	public void deposit(long amount) {

		balance += amount;
		Transaction tt = new Transaction(amount, balance);
		System.out.println(amount +"원 입금하셨습니다.");
  }

	//출금 메서드
	public void withdraw(long amount) {

		balance -= amount;
		Transaction tt = new Transaction(amount, balance);
		System.out.println(amount + "원 인출하셨습니다.");		
	}
	//잔고 확인
	public long getBalance() {
		return balance;
	}
	
	//거래내역 메서드
	public Transaction[] getTransactions() {

	}

}
