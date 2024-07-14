package view;

public final class Const {
  public static final String TRANSATIONLIST = "= 거래 내역 =";
  public static final String ACCOUNTSBYNAME = "= 해당 소유자명의 계좌 목록 =";
  public static final String ACCOUNTSBYNO = "= 해당 계좌번호의 계좌정보 =";
  public static final String ALLACCOUNTS = "= 전체 계좌 목록 =";

  public static void showTransactionList(){
    System.out.println(TRANSATIONLIST);
  }

  public static void showAccountsByName(){
    System.out.println(ACCOUNTSBYNAME);
  }

  public static void showAccountsByNo(){
    System.out.println(ACCOUNTSBYNO);
  }

  public static void showAllAccounts(){
    System.out.println(ALLACCOUNTS);
  }

}
