package view;

import lombok.Getter;

@Getter
public enum MessageContent {

    ALL_ACCOUNTS_MSG("= 전체 계좌 목록 ="),
    ACCOUNT_INFO_MSG("= 해당 계좌번호의 계좌정보 ="),
    ACCOUNT_INFO_BY_NAME_MSG("= 해당 소유자명의 계좌 목록 ="),
    AMOUNT_TRANSACTION_MSG("%d원 %s하셨습니다"),
    ACCOUNT_BALANCE_MSG("현재 잔액은 %d원 입니다."),
    TRANSACTION_HISTORY_MSG("= 거래 내역 =");

    private final String infoMsg;

    MessageContent(String infoMsg) {
        this.infoMsg = infoMsg;
    }

    public String format(Object... args) {
        return String.format(infoMsg, args);
    }

}
