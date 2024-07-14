import java.util.List;

import controller.BankManager;
import model.Account;
import model.Bank;
import model.Transaction;

public class BankAccountApplication {

    public static void main(String[] args) {
    	BankManager bm = new BankManager();
    	bm.runBank();
    }
}