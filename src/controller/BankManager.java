package controller;

import java.util.List;
import model.Account;
import model.Bank;
import model.Transaction;
import view.OutputView;

public class BankManager {

    private final Bank bank;
    private final OutputView outputView = new OutputView();

    public BankManager(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        requestBankAllAccounts();
        requestAccountByNo("890113");
        requestAccountTransaction("890113", "입금", 200_000);
        requestAccountByNo("890113");
        requestAccountTransaction("890113", "입금", 200_000);
        requestAccountByNo("890113");
        requestAccountsByName("택");
        requestAccountByNo("011");
        requestAccountsByName("헌욱");
        requestAccountByNo("890113");
        requestAccountTransaction("890113", "출금", 5_500);
        requestAccountByNo("890113");
        requestTransactionsHistory("890113");
    }

    /**
     * 전체 계좌 목록 요청 메서드
     */
    private void requestBankAllAccounts() {
        List<Account> accounts = bank.getAccounts();
        String[] outputData = accounts.stream()
                .map(Account::toString)
                .toArray(String[]::new);
        outputView.displayAllAccounts(outputData);
    }

    /**
     * 계좌 정보 요청 메서드(계좌 번호로 조회)
     */
    private void requestAccountByNo(String accountNo) {
        Account account = bank.getAccount(accountNo);
        if (account == null) outputView.displayAccountNoNull();
        else outputView.displayAccountByNo(account.toString());
    }

    /**
     * 거래 요청 메서드
     * @param accountNo: 계좌 번호
     * @param kind: 입출금 종류
     * @param amount: 거래 금액
     */
    private void requestAccountTransaction(String accountNo, String kind, int amount) {
        Account account = bank.getAccount(accountNo);
        switch (kind) {
            case "입금" -> account.deposit(amount, kind);
            case "출금" -> account.withdraw(amount, kind);
            default -> throw new IllegalArgumentException();
        }
        List<Transaction> transactions = account.getTransactions();
        Transaction transaction = transactions.get(transactions.size() - 1);
        outputView.displayTransactionStatus(amount, transaction.getKind(), account.getBalance());
    }

    /**
     * 계좌 정보 요청 메서드(소유주 명으로 조회)
     * @param name: 계좌 소유주 명
     */
    private void requestAccountsByName(String name) {
        List<Account> accounts = bank.findAccounts(name);
        String[] outputData = accounts.stream()
                .map(Account::toString)
                .toArray(String[]::new);
        outputView.displayAccountByName(outputData);
    }

    /**
     * 거래 내역 조회 요청 메서드
     * @param accountNo: 계좌 번호
     */
    private void requestTransactionsHistory(String accountNo) {
        Account account = bank.getAccount(accountNo);
        List<Transaction> transactions = account.getTransactions();
        String[] outputData = transactions.stream()
                .map(Transaction::toString)
                .toArray(String[]::new);
        outputView.displayTransactionsHistory(outputData);
    }
}
