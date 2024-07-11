package model;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Account {

    private final String accountNo;
    private final String name;
    private long balance;
    private final List<Transaction> transactions = new ArrayList<>();

    @Builder
    public Account(String accountNo, String name) {
        this.accountNo = accountNo;
        this.name = name;
    }

    /**
     * 입금 메서드
     * @param amount: 입금 금액
     */
    public void deposit(long amount, String kind) {
        balance += amount;
        transactions.add(createTransaction(kind, amount));
    }

    /**
     * 출금 메서드
     * @param amount: 출금 금액
     */
    public void withdraw(long amount, String kind) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(createTransaction(kind, amount));
        }
    }

    /**
     * 거래 내역 생성 메서드
     * @param kind: 입출금 종류
     * @param amount: 입출금 금액
     * @return Transaction 객체
     */
    private Transaction createTransaction(String kind, long amount) {
        DateTime dateTime = new DateTime();
        return Transaction.builder()
                .transactionDate(dateTime.getDate())
                .transactionTime(dateTime.getTime())
                .kind(kind)
                .amount(amount)
                .balance(balance)
                .build();
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
