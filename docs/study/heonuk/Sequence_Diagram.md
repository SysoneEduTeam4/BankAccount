# BankAccount Code Analysis
- version: `1`
- 리팩토링 이전 코드에서의 메서드 흐름

# main() 메서드 실행 순서

### 1. `new Bank()`: Bank 객체를 생성, `addSampleData(bank)`: 샘플 데이터를 추가
![image](https://github.com/SysoneEduTeam4/BankAccount/assets/117193889/ebf554ee-c433-4927-bcaf-89e2ad788f1f)

### 2. `displayAllAccounts(bank)`: 전체 계좌 목록을 출력 <br>
![image](https://github.com/SysoneEduTeam4/BankAccount/assets/117193889/2612339d-3927-4367-ab69-f799800c421f)

### 3. `displayAccountByNo(getAccount("890113"))`: 계좌 "890113" 정보를 출력
![image](https://github.com/SysoneEduTeam4/BankAccount/assets/117193889/97aa2964-f56d-4e33-b651-99744f0d09df)

### 4. `displayAccountDeposit(getAccount("890113"), 200000)`: 계좌 "890113"에 200000원을 입금하고 잔액을 출력
![image](https://github.com/SysoneEduTeam4/BankAccount/assets/117193889/ebdd049f-5b37-4811-b6ea-d9cc03e468d8)

### 5. 3번 로직 동일
### 6. 4번 로직 동일
### 7. 3번 로직 동일

### 8. `displayAccountsByName(findAccounts("택"))`: 소유자명이 "택"인 계좌 목록을 검색하고 출력
![image](https://github.com/SysoneEduTeam4/BankAccount/assets/117193889/e290d8b1-10e3-4b26-9fdc-820b4fb9bb2e)

### 9. `displayAccountByNo(getAccount("011"))`: 계좌 "011" 정보를 출력
- 3번 로직과 동일; 011 계좌의 정보는 없어서 아무것도 출력되지 않음

### 10.`displayAccountsByName(findAccounts("희정"))`: 소유자명이 "희정"인 계좌 목록을 검색하고 출력
- 8번 로직과 동일; “희정”인 계좌 정보는 없어서 아무것도 출력되지 않음

### 11.`displayAccountWithDraw(getAccount("890113"), 5500)`: 계좌 "890113"에서 5500원을 출금하고 잔액을 출력
![image](https://github.com/SysoneEduTeam4/BankAccount/assets/117193889/1f837afc-9f72-45dc-a986-c0a1de10b79e)

### 12. `displayAccountByNo(getAccount("890113"))`: 계좌 "890113" 정보를 출력
- 3번 로직과 같음

### 13. `displayTransactions(getAccount("890113"))`: 계좌 "890113"의 거래 내역을 출력
![image](https://github.com/SysoneEduTeam4/BankAccount/assets/117193889/4ce26ba1-da77-41fd-8876-26c2c56cafd1)
