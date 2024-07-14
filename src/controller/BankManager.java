package controller;

import java.util.List;

import model.Account;
import model.Bank;
import model.Transaction;
import view.InputClass;
import view.OutputView;

public class BankManager {

	private Bank bank;
	private OutputView outputView = new OutputView();
	private InputClass inputClass = new InputClass();
	
	public void runBank() {
		String accountByNo, accountByName;
		int bankType, continueBank, choiceAccountOrName;
		
		bank = new Bank();
		addSampleData(bank);
		while(true) {
			getAllAccounts(bank);
			
			bankType = inputClass.bankType();
			
			choiceAccountOrName = inputClass.choiceType();
			doBank(bankType, choiceAccountOrName);
			
			continueBank = inputClass.continueBank();
			if (continueBank == 2) {
				break;
			}
		}
	}
	
	/**
     * 특정 계좌의 거래 내역을 출력하는 메서드
     * @param account: 거래 내역을 출력할 계좌 객체
     */
    private void getTransactions(Account account) {
        outputView.displayTransactions(account);
    }

    /**
     * 특정 계좌에서 출금하고 잔액을 출력하는 메서드
     * @param account: 출금할 계좌 객체
     * @param amount: 출금할 금액
     */
    private void getAccountWithDraw(Account account, long amount) {
        account.withdraw(amount);
        outputView.displayAccountWithDraw(account);
    }

    /**
     * 소유자명으로 계좌 목록을 출력하는 메서드
     * @param accounts: 출력할 계좌 목록
     */
    private void getAccountsByName(List<Account> accounts) {
    	outputView.displayAccountsByName(accounts);
    }

    /**
     * 특정 계좌에 입금하고 잔액을 출력하는 메서드
     * @param account: 입금을 할 계좌 객체
     * @param amount 입금할 금액
     */
    private void getAccountDeposit(Account account, long amount) {
        account.deposit(amount);
        outputView.displayAccountDeposit(account);
    }

    /**
     * 계좌 정보를 출력하는 메서드
     * @param account: 출력할 계좌 객체
     */
    private void getAccountByNo(Account account) {
        outputView.displayAccountByNo(account);
    }

    /**
     * 전체 계좌 목록을 출력하는 메서드
     * @param bank: 계좌 목록을 조회할 은행 객체
     */
    private void getAllAccounts(Bank bank) {
    	List<Account> accounts = bank.getAccounts();
    	outputView.displayAllAccounts(accounts);
    }
    
	
	/**
     * 샘플 데이터를 추가하는 메서드
     * @param bank 샘플 데이터를 추가할 은행 객체
     */
    private void addSampleData(Bank bank) {
    	bank.addAccount("10071", "백");
        bank.addAccount("890113", "택");
        bank.addAccount("0113", "택");
        bank.addAccount("987654321", "두팔");
    }
    
    private void doBank(int bankType, int choiceAccountOrName) {
    	String strAccountNo = "", strAccountName = "";
    	long amount = 0;
    	if (bankType == 1) {	//입금
    		if (choiceAccountOrName == 1) {	//계좌번호 선택
    			strAccountNo = inputClass.accountByNo(choiceAccountOrName);
    			getAccountByNo(bank.getAccount(strAccountNo));
    			amount = inputClass.inputAmount(bankType);
    	        getAccountDeposit(bank.getAccount(strAccountNo), amount);
        	} else if(choiceAccountOrName == 2) {	//소유주 선택
        		strAccountName = inputClass.accountByName();
        		getAccountsByName(bank.findAccounts(strAccountName));
        		strAccountNo = inputClass.accountByNo(choiceAccountOrName);
        		amount = inputClass.inputAmount(bankType);
        		getAccountDeposit(bank.getAccount(strAccountNo), amount);
        	}
    		getTransactions(bank.getAccount(strAccountNo));
    	} else if (bankType == 2) {	//출금
    		if (choiceAccountOrName == 1) {	//계좌번호 선택
    			strAccountNo = inputClass.accountByNo(choiceAccountOrName);
    			getAccountByNo(bank.getAccount(strAccountNo));
    			amount = inputClass.inputAmount(bankType);
    			getAccountWithDraw(bank.getAccount(strAccountNo), amount);
        	} else if(choiceAccountOrName == 2) {	//소유주 선택
        		strAccountName = inputClass.accountByName();
        		getAccountsByName(bank.findAccounts(strAccountName));
        		strAccountNo = inputClass.accountByNo(choiceAccountOrName);
        		amount = inputClass.inputAmount(bankType);
        		getAccountWithDraw(bank.getAccount(strAccountNo), amount);
        	}
    		getTransactions(bank.getAccount(strAccountNo));
    	} else if (bankType == 3) {	//잔고확인
    		getAllAccounts(bank);
    	} 
    }
}
