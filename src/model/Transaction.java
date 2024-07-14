package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Getter
public class Transaction {

    private final String transactionDate; //거래일
    private final String transactionTime; //거래시간
    private final String kind; //구분(입금 또는 출금)
    private final long amount; //거래금액
    private final long balance; //잔고
    
    /*
     거래내역 출력 메서드
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[거래금액 :")
                .append(amount)
                .append("원, 잔액 : ")
                .append(balance)
                .append("원 /")
                .append(transactionDate)
                .append(transactionTime)
                .append("]");
        return sb.toString();
    }
}
