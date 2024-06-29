import java.util.List;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        addSampleData(bank);

        System.out.println("= 전체 계좌 목록 =");
        for (Account account: bank.getAccounts()) {
            System.out.println("[계좌번호 : " + account.getAccountNo() + ", 소유자 명 : " + account.getName() + ", 잔액 : " + account.getBalance() + "]");
        }
        System.out.println();

        System.out.println("= 해당 계좌번호의 계좌정보 ="); // 890113, 택
        Account account = bank.getAccount("890113");
        System.out.println("[계좌번호 : " + account.getAccountNo() + ", 소유자 명 : " + account.getName() + ", 잔액 : " + account.getBalance() + "]");
        System.out.println();

        account.deposit(200000);
        System.out.println("현재 잔액은 "+ account.getBalance() + "원 입니다.");
        System.out.println();

        System.out.println("= 해당 계좌번호의 계좌정보 =");
        System.out.println("[계좌번호 : " + account.getAccountNo() + ", 소유자 명 : " + account.getName() + ", 잔액 : " + account.getBalance() + "]");
        System.out.println();

        account.deposit(200000);
        System.out.println("현재 잔액은 "+ account.getBalance() + "원 입니다.");
        System.out.println();

        System.out.println("= 해당 계좌번호의 계좌정보 =");
        System.out.println("[계좌번호 : " + account.getAccountNo() + ", 소유자 명 : " + account.getName() + ", 잔액 : " + account.getBalance() + "]");
        System.out.println();

        System.out.println("= 해당 소유자명의 계좌 목록 =");
        List<Account> account1 = bank.findAccounts("택");
        for(Account account2 : account1) {
            System.out.println("[계좌번호 : " + account2.getAccountNo() + ", 소유자 명 : " + account2.getName() + ", 잔액 : " + account2.getBalance() + "]");
        }
        System.out.println();

        System.out.println("= 해당 계좌번호의 계좌정보 =");
        Account account3 = bank.getAccount("011");
        if (account3 == null) {
            System.out.println();
        } else {
            System.out.println("[계좌번호 : " + account3.getAccountNo() + ", 소유자 명 : " + account3.getName() + ", 잔액 : " + account3.getBalance() + "]");
            System.out.println();
        }

        System.out.println("= 해당 소유자명의 계좌 목록 =");
        List<Account> account4 = bank.findAccounts("희정");
        if (account4 == null) {
            System.out.println();
        } else {
            for(Account account5 : account4) {
                System.out.println("[계좌번호 : " + account5.getAccountNo() + ", 소유자 명 : " + account5.getName() + ", 잔액 : " + account5.getBalance() + "]");
            }
        }

        System.out.println("= 해당 계좌번호의 계좌정보 ="); // 890113, 택
        System.out.println("[계좌번호 : " + account.getAccountNo() + ", 소유자 명 : " + account.getName() + ", 잔액 : " + account.getBalance() + "]");
        System.out.println();

        account.withdraw(5500);
        System.out.println("현재 잔액은 "+ account.getBalance() + "원 입니다.");
        System.out.println();

        System.out.println("= 해당 계좌번호의 계좌정보 =");
        System.out.println("[계좌번호 : " + account.getAccountNo() + ", 소유자 명 : " + account.getName() + ", 잔액 : " + account.getBalance() + "]");
        System.out.println();

        System.out.println("= 거래 내역 =");
        for(Transaction tt : account.getTransactions()) {
            tt.printTransactionList();
        }
    }

    private static void addSampleData(Bank bank) {
        bank.addAccount("10071", "백");
        bank.addAccount("890113", "택");
        bank.addAccount("0113", "택");
        bank.addAccount("987654321", "두팔");
    }

}