package model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Bank {

    private final List<Account> accounts = new ArrayList<>();
    private int totalAccount;

    /**
     * 계좌 등록 메서드
     * @param accountNo: 계좌 번호
     * @param name: 소유주 명
     */
    public void addAccount(String accountNo, String name) {
    	Account account = new Account.AccountBuilder()
    						.accountNo(accountNo)
    						.name(name)
    						.build();
        accounts.add(account);
        totalAccount++;
    }

    /**
     * 계좌 조회 메서드
     * @param accountNo: 계좌 번호
     * @return Account
     */
    public Account getAccount(String accountNo) {
        for (Account account : accounts) {
            if (account.getAccountNo().equals(accountNo)) {
                return account;
            }
        }
        return null; // TODO: 계좌 없음 -> 예외
    }

    /**
     * 계좌 조회 메서드
     * @param name: 소유주 명
     * @return Account[]
     */
    public List<Account> findAccounts(String name) {
        List<Account> accounts = new ArrayList<>();
        for (Account account : getAccounts()) {
            if (account.getName().equals(name)) {
                accounts.add(account);
            }
        }
        return accounts;
    }
    
    

}
