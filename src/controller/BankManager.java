package controller;

import java.io.IOException;
import java.util.List;
import model.Account;
import model.Bank;
import model.Transaction;
import view.OutputView;

public class BankManager {

  private final Bank bank;
  private final OutputView outputView = new OutputView();

  private void init(){
    addSampleData(bank);
    task(bank);
  }

  public BankManager(Bank bank) {
    this.bank = bank;
  }

  public static void run(){
    Bank bank = new Bank();
    BankManager bankManager = new BankManager(bank);
    bankManager.init();
  }

  private void task(Bank bank) {
    requestAllAccounts(bank);
    requestAccountByNo(bank.getAccount("890113"));
    requestAccountDeposit(bank.getAccount("890113"), 200000);
    requestAccountByNo(bank.getAccount("890113"));
    requestAccountDeposit(bank.getAccount("890113"), 200000);
    requestAccountByNo(bank.getAccount("890113"));
    requestAccountsByName(bank.findAccounts("택"));
    requestAccountByNo(bank.getAccount("011"));
    requestAccountsByName(bank.findAccounts("희정"));
    requestAccountsByName(bank.findAccounts("택"));
    requestAccountWithDraw(bank.getAccount("890113"), 5500);
    requestAccountByNo(bank.getAccount("890113"));
    requestTransactions(bank.getAccount("890113"));
  }

  private void addSampleData(Bank bank) {
    bank.addAccount("10071", "백");
    bank.addAccount("890113", "택");
    bank.addAccount("0113", "택");
    bank.addAccount("987654321", "두팔");
  }

  private void  requestTransactions(Account account) {
    List<Transaction> transactions = account.getTransactions();
    outputView.displayTransactions(transactions);
  }

  /**
   * 특정 계좌에서 출금하고 잔액을 출력하는 메서드
   * @param account: 출금할 계좌 객체
   * @param amount: 출금할 금액
   */
  private void  requestAccountWithDraw(Account account, int amount) {
    account.withdraw(amount);
    outputView.displayAccountWithDraw(account);
  }

  /**
   * 소유자명으로 계좌 목록을 출력하는 메서드
   * @param accounts: 출력할 계좌 목록
   */
  private void  requestAccountsByName(List<Account> accounts) {
    outputView.displayAccountsByName(accounts);
  }

  /**
   * 특정 계좌에 입금하고 잔액을 출력하는 메서드
   * @param account: 입금을 할 계좌 객체
   * @param amount 입금할 금액
   */
  private void  requestAccountDeposit(Account account, int amount) {
    account.deposit(amount);
    outputView.displayAccountDeposit(account);
  }

  /**
   * 계좌 정보를 출력하는 메서드
   * @param account: 출력할 계좌 객체
   */
  private void requestAccountByNo(Account account) {
    if (account == null) {
      System.out.println("Error");
    }
    outputView.displayAccountByNo(account);
  }

  /**
   * 전체 계좌 목록을 출력하는 메서드
   * @param bank: 계좌 목록을 조회할 은행 객체
   */
  private void requestAllAccounts(Bank bank) {
    List<Account> accounts =  bank.getAccounts();
    outputView.displayAllAccounts(accounts);
  }
}
