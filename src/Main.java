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

    private static void displayTransactions(Account account) {
        System.out.println("= 거래 내역 =");
        for(Transaction transaction : account.getTransactions()) {
            transaction.printTransactionList();
        }
    }

    private static void displayAccountWithDraw(Account account, int amount) {
        account.withdraw(amount);
        System.out.printf("현재 잔액은 %d원 입니다.%n",account.getBalance());
        System.out.println();
    }

    private static void displayAccountsByName(List<Account> accounts) {
        System.out.println("= 해당 소유자명의 계좌 목록 =");
        for(Account account : accounts) {
            printAccountInfo(account);
        }
        System.out.println();
    }

    private static void displayAccountDeposit(Account account, int amount) {
        account.deposit(amount);
        System.out.printf("현재 잔액은 %d원 입니다.%n",account.getBalance());
        System.out.println();
    }

    private static void displayAccountByNo(Account account) {
        System.out.println("= 해당 계좌번호의 계좌정보 =");
        if (account != null) {
            printAccountInfo(account);
        }
        System.out.println();
    }

    private static void displayAllAccounts(Bank bank) {
        System.out.println("= 전체 계좌 목록 =");
        for (Account account: bank.getAccounts()) {
            printAccountInfo(account);
        }
        System.out.println();
    }

    private static void printAccountInfo(Account account) {
        System.out.printf("[계좌번호 : %s, 소유자 명 : %s, 잔액 : %d]%n", account.getAccountNo(), account.getName(), account.getBalance());
    }

    private static void addSampleData(Bank bank) {
        bank.addAccount("10071", "백");
        bank.addAccount("890113", "택");
        bank.addAccount("0113", "택");
        bank.addAccount("987654321", "두팔");
    }

}