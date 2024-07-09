import controller.BankManager;

public class BankAccountApplication {

    public static void main(String[] args) {
        BankManager manager = Config.callManager();
        manager.run();
    }
}