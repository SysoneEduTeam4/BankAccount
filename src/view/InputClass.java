package view;

import java.util.Scanner;

public class InputClass {
	Scanner sc = null;
	
	public InputClass() {
		sc = new Scanner(System.in);
	}
	
	public String accountByNo(int type) {
		if (type == 1) {
			System.out.println("계좌번호를 입력해주세요.");
		} else if(type == 2) {
			System.out.println("위의 목록에서 원하는 계좌번호를 입력해주세요.");
		}
		String accountByNo = sc.next();
		
		return accountByNo;
	}
	
	public String accountByName() {
		System.out.println("소유자명을 입력해주세요.");
		String accountByName = sc.next();
		
		return accountByName;
	}
	
	public int bankType() {
		System.out.println("선택 해주세요. ex) 1. 입금 2. 출금 3. 잔고 확인");
		int type = sc.nextInt();
		
		return type;
	}
	
	public int continueBank() {
		System.out.println("계속 진행하시겠습니까? 1. 진행 2. 종료");
		int type = sc.nextInt();
		
		return type;
	}
	
	public int choiceType() {
		System.out.println("계좌번호 또는 소유주를 선택하여 진행해주세요. 1.계좌번호 2.소유주");
		int type = sc.nextInt();
		
		return type;
	}
	
	public long inputAmount(int bankType) {
		long amount = 0;
		if (bankType == 1) {	//입금
			System.out.println("입금 금액을 입력하여 주세요.");
			amount = sc.nextLong();
		} else if(bankType == 2) {	//출금
			System.out.println("출금 금액을 입력하여 주세요.");
			amount = sc.nextLong();
		}
		return amount;
	}

}
