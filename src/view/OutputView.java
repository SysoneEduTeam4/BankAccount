package view;

import static view.MessageContent.ACCOUNT_BALANCE_MSG;
import static view.MessageContent.ACCOUNT_INFO_BY_NAME_MSG;
import static view.MessageContent.ACCOUNT_INFO_MSG;
import static view.MessageContent.ALL_ACCOUNTS_MSG;
import static view.MessageContent.AMOUNT_TRANSACTION_MSG;
import static view.MessageContent.TRANSACTION_HISTORY_MSG;

public class OutputView {

    /**
     * 모든 계좌 정보 출력 메서드
     * @param accountsInfo: 모든 계좌 문자열 정보
     */
    public void displayAllAccounts(String[] accountsInfo) {
        System.out.println(ALL_ACCOUNTS_MSG.getInfoMsg());
        for (String account : accountsInfo) {
            System.out.println(account);
        }
        System.out.println();
    }

    /**
     * 계좌 정보 출력 메서드 - 계좌 번호
     * @param accountInfo: 출력할 계좌 정보
     */
    public void displayAccountByNo(String accountInfo) {
        System.out.println(ACCOUNT_INFO_MSG.getInfoMsg());
        System.out.println(accountInfo);
        System.out.println();
    }

    /**
     * 계좌 정보 출력 메서드 - 소유주 명
     * @param accountsInfo: 출력할 계좌 정보
     */
    public void displayAccountByName(String[] accountsInfo) {
        System.out.println(ACCOUNT_INFO_BY_NAME_MSG.getInfoMsg());
        for (String account : accountsInfo) {
            System.out.println(account);
        }
        System.out.println();
    }

    /**
     * 입출력 상태 출력 메서드
     * @param amount: 금액
     * @param kind: 입출력 종류
     * @param balance: 잔액
     */
    public void displayTransactionStatus(int amount, String kind, long balance) {
        if (kind.equals("입금")) {
            System.out.println(AMOUNT_TRANSACTION_MSG.format(amount, kind));
            System.out.println(ACCOUNT_BALANCE_MSG.format(balance));
        } else if (kind.equals("출금")) {
            System.out.println(AMOUNT_TRANSACTION_MSG.format(amount, kind));
            System.out.println(ACCOUNT_BALANCE_MSG.format(balance));
        }
        System.out.println();
    }

    /**
     * 계좌 거래 내역 출력 메서드
     * @param transactionsInfo: 모든 계좌 문자열 정보
     */
    public void displayTransactionsHistory(String[] transactionsInfo) {
        System.out.println(TRANSACTION_HISTORY_MSG.getInfoMsg());
        for (String transaction : transactionsInfo) {
            System.out.println(transaction);
        }
        System.out.println();
    }

    public void displayAccountNoNull() {
        System.out.println(ACCOUNT_INFO_MSG.getInfoMsg());
        System.out.println();
    }

}
