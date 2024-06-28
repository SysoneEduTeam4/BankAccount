import java.util.ArrayList;
import java.util.List;

public class Account {
	private String accountNo;
	private String name;
	private long balance;
	private List<Transaction> transactions;

	public Account(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public Account(String accountNo, String name) {
		this.accountNo = accountNo;
		this.name = name;
		this.balance = 0;
		this.transactions = new ArrayList<Transaction>(); 
	}
	
	public Account(String accountNo, String name, long balance, Transaction[] transactions) {
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
		this.transactions = new ArrayList<Transaction>();
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
  
	//잔고
	public void setBalance(long balance) {
		this.balance = balance;
	}

	public void setTransactions(List<Transaction> transactions) {
		
		this.transactions = transactions;
	}

	//입금 메서드
	public void deposit(long amount) {
		System.out.println(amount +"원 입금하셨습니다.");
		balance += amount;
		Transaction tt = new Transaction("입금", amount, balance);
  }

	//출금 메서드
	public void withdraw(long amount) {
		System.out.println(amount + "원 인출하셨습니다.");		
		balance -= amount;
		Transaction tt = new Transaction("출금", amount, balance);
	}
	//잔고 확인
	public long getBalance() {
		return balance;
	}
	
	//거래내역 메서드
	public List<Transaction> getTransactions() {
		return transactions;
	}

}
