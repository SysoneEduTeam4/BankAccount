package model;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Account {

    private final String accountNo;
    private final String name;
    private long balance;
    private final List<Transaction> transactions = new ArrayList<>();

    //입금 메서드
    public void deposit(long amount) {
        DateTime datetime = new DateTime();
        String day = datetime.getDate();
        String time = datetime.getTime();
        System.out.println(amount + "원 입금하셨습니다.");
        balance += amount;
        Transaction tt = new Transaction.TransactionBuilder()
        					.kind("입금")
        					.amount(amount)
        					.balance(balance)
        					.transactionDate(day)
        					.transactionTime(time)
        					.build();
        //Transaction tt = new Transaction("입금", amount, balance, day, time);
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
            Transaction tt = new Transaction.TransactionBuilder()
					.kind("출금")
					.amount(amount)
					.balance(balance)
					.transactionDate(day)
					.transactionTime(time)
					.build();
            transactions.add(tt);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[계좌번호 : ")
                .append(accountNo)
                .append(", 소유자 명 : ")
                .append(name)
                .append(", 잔액 : ")
                .append(balance)
                .append("]");
        return sb.toString();
    }
}
