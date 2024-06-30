import java.util.ArrayList;
import java.util.List;

public class Account {

    private final String accountNo;
    private final String name;
    private long balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(String accountNo, String name) {
        this.accountNo = accountNo;
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    //입금 메서드
    public void deposit(long amount) {
        DateTime datetime = new DateTime();
        String day = datetime.getDate();
        String time = datetime.getTime();
        System.out.println(amount + "원 입금하셨습니다.");
        balance += amount;
        Transaction tt = new Transaction("입금", amount, balance, day, time);
        transactions.add(tt);
    }

    //출금 메서드
    public void withdraw(long amount) {
        DateTime datetime = new DateTime();
        String day = datetime.getDate();
        String time = datetime.getTime();
        if (amount > balance) {    //잔고 0일 때
            System.out.println("출금액이 현재 잔액보다 큽니다.");
            System.out.println("현재 잔액" + balance);
        } else {
            System.out.println(amount + "원 인출하셨습니다.");
            balance -= amount;
            Transaction tt = new Transaction("출금", amount, balance, day, time);
            transactions.add(tt);
        }
    }

    //잔고 확인
    public long getBalance() {
        return balance;
    }

    //거래내역 메서드
    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[계좌번호 : ")
                .append(this.accountNo)
                .append(", 소유자 명 : ")
                .append(this.getName())
                .append(", 잔액 : ")
                .append(this.getBalance())
                .append("]");
        return sb.toString();
    }
}
