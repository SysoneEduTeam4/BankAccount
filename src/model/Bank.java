package model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Bank {

    private final List<Account> accounts = new ArrayList<>();

    /**
     * 계좌 등록 메서드
     * @param accountNo: 계좌 번호
     * @param name: 소유주 명
     */
    public void addAccount(String accountNo, String name) {
        Account account = Account.builder()
                .accountNo(accountNo)
                .name(name)
                .build();
        accounts.add(account);
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
        List<Account> accountsByName = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getName().equals(name)) {
                accountsByName.add(account);
            }
        }
        return accountsByName;
    }

    /**
     * 총 계좌수 조회 메서드
     * @return Account 개수
     */
    public int getTotalAccount() {
        return accounts.size();
    }

}
