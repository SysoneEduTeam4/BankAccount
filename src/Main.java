import java.util.List;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        addSampleData(bank);
        displayAllAccounts(bank);
        displayAccountByNo(bank.getAccount("890113"));
        displayAccountDeposit(bank.getAccount("890113"), 200000);
        displayAccountByNo(bank.getAccount("890113"));
        displayAccountDeposit(bank.getAccount("890113"), 200000);
        displayAccountByNo(bank.getAccount("890113"));
        displayAccountsByName(bank.findAccounts("택"));
        displayAccountByNo(bank.getAccount("011"));
        displayAccountsByName(bank.findAccounts("희정"));
        displayAccountsByName(bank.findAccounts("택"));
        displayAccountWithDraw(bank.getAccount("890113"), 5500);
        displayAccountByNo(bank.getAccount("890113"));
        displayTransactions(bank.getAccount("890113"));
    }

    /**
     * 특정 계좌의 거래 내역을 출력하는 메서드
     * @param account: 거래 내역을 출력할 계좌 객체
     */
    private static void displayTransactions(Account account) {
        System.out.println("= 거래 내역 =");
        for(Transaction transaction : account.getTransactions()) {
            System.out.println(transaction);
        }
    }

    /**
     * 특정 계좌에서 출금하고 잔액을 출력하는 메서드
     * @param account: 출금할 계좌 객체
     * @param amount: 출금할 금액
     */
    private static void displayAccountWithDraw(Account account, int amount) {
        account.withdraw(amount);
        System.out.printf("현재 잔액은 %d원 입니다.%n",account.getBalance());
        System.out.println();
    }

    /**
     * 소유자명으로 계좌 목록을 출력하는 메서드
     * @param accounts: 출력할 계좌 목록
     */
    private static void displayAccountsByName(List<Account> accounts) {
        System.out.println("= 해당 소유자명의 계좌 목록 =");
        for(Account account : accounts) {
            System.out.println(account);
        }
        System.out.println();
    }

    /**
     * 특정 계좌에 입금하고 잔액을 출력하는 메서드
     * @param account: 입금을 할 계좌 객체
     * @param amount 입금할 금액
     */
    private static void displayAccountDeposit(Account account, int amount) {
        account.deposit(amount);
        System.out.printf("현재 잔액은 %d원 입니다.%n",account.getBalance());
        System.out.println();
    }

    /**
     * 계좌 정보를 출력하는 메서드
     * @param account: 출력할 계좌 객체
     */
    private static void displayAccountByNo(Account account) {
        System.out.println("= 해당 계좌번호의 계좌정보 =");
        if (account != null) {
            System.out.println(account);
        }
        System.out.println();
    }

    /**
     * 전체 계좌 목록을 출력하는 메서드
     * @param bank: 계좌 목록을 조회할 은행 객체
     */
    private static void displayAllAccounts(Bank bank) {
        System.out.println("= 전체 계좌 목록 =");
        for (Account account: bank.getAccounts()) {
            System.out.println(account);
        }
        System.out.println();
    }

    /**
     * 샘플 데이터를 추가하는 메서드
     * @param bank 샘플 데이터를 추가할 은행 객체
     */
    private static void addSampleData(Bank bank) {
        bank.addAccount("10071", "백");
        bank.addAccount("890113", "택");
        bank.addAccount("0113", "택");
        bank.addAccount("987654321", "두팔");
    }

}