public class Bank {

    private Account[] accounts;
    private int totalAccount;

    public Bank() {}

    public Bank(Account[] accounts, int totalAccount) {
        this.accounts = accounts;
        this.totalAccount = totalAccount;
    }

    /**
     * 계좌 등록 메서드
     * @param accountNo: 계좌 번호
     * @param name: 소유주 명
     * @return String
     */
    public String addAccount(String accountNo, String name) {

        return "";
    }

    /**
     * 계좌 조회 메서드
     * @param accountNo: 계좌 번호
     * @return Account
     */
    public Account getAccount(String accountNo) {
        Account acc = new Account();
        return acc;
    }

    /**
     * 계좌 조회 메서드
     * @param name: 소유주 명
     * @return Account[]
     */
    public Account[] findAccounts(String name) {
        return new Account[0];
    }

    /**
     * 계좌 목록 조회
     * @return Account[]
     */
    public Account[] getAccounts() {
        return accounts;
    }

    /**
     * 총 계좌수 조회
     * @return
     */
    public int getTotalAccount() {
        return totalAccount;
    }

}
