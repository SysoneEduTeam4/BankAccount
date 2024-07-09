package model;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

    private String accountNo;
    private String name;
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
    public void deposit(long amount) {
        System.out.println(amount + "원 입금하셨습니다.");
        balance += amount;
        transactions.add(createTransaction("입금", amount));
    }

    /**
     * 출금 메서드
     * @param amount: 출금 금액
     */
    public void withdraw(long amount) {
        if (amount > balance) {    //잔고 0일 때
            System.out.println("출금액이 현재 잔액보다 큽니다.");
            System.out.println("현재 잔액" + balance);
        } else {
            System.out.println(amount + "원 인출하셨습니다.");
            balance -= amount;
            transactions.add(createTransaction("출금", amount));
        }
    }

    /**
     * 거래 내역 생성 메서드
     * @param kind: 입출금 종류
     * @param amount: 입출금 금액
     * @return Transaction 객체
     */
    private Transaction createTransaction(String kind, long amount) {
        DateTime datetime = new DateTime();
        return Transaction.builder()
                .transactionDate(datetime.getDate())
                .transactionTime(datetime.getTime())
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
