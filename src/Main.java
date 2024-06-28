import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        systemOn();
        int selectNum = sc.nextInt();
        List<Account> accountsList = new LinkedList<>();
        Bank bank = new Bank();
        loadingPrevData(accountsList);

        switch (selectNum){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    private static void loadingPrevData( List<Account> accountsList) {
        accountsList.add(new Account("10071","백"));
        accountsList.add(new Account("890113","택"));
        accountsList.add(new Account("0113","택"));
        accountsList.add(new Account("987654321","두팔"));
    }

    private static void bankCreate() {
    }

    public static void systemOn(){
        System.out.println("===============================");
        System.out.println("   KOSA 은행프로그램을 실행합니다   ");
        System.out.println("===============================");
        System.out.println("원하시는 기능을 선택하세요");
        System.out.println("1. 계좌 생성\n 2. 계좌 찾기\n 3. 계좌 목록 조회\n 4. 총계좌수 \n 5. 프로그램 종료");
    }
}