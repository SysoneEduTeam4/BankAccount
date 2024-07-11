import controller.BankManager;
import model.Bank;

public class Config {

    public static BankManager callManager() {
        Bank bank = new Bank();
        addSampleData(bank);
        return new BankManager(bank);
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
