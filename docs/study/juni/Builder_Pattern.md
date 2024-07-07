# ✨Builder Pattern에 대해서
* * *
## 1. 빌더 패턴이란?
> 복잡한 객체의 생성과정과 표현 방법을 분리하여 다양한 구성의 인스턴스를 만드는 생성 패턴

## 2. 그렇다면 왜 쓰는걸까?
이유를 알기위해 현재 우리가 사용하는 Transaction 클래스를 가져와보았다.

>**점층적 생성자 패턴**으로 구현된 Transaction 클래스.
``` java
public class Transaction {

    private final String transactionDate; //거래일
    private final String transactionTime; //거래시간
    private final String kind; //구분(입금 또는 출금)
    private final long amount; //거래금액
    private final long balance; //잔고

    public Transaction(String kind, long amount, long balance, String transactionDate,
            String transactionTime) {
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.kind = kind;
        this.amount = amount;
        this.balance = balance;
    }
```
위에서처럼 우리가 필수 매개변수와 함께, 선택 매개변수를 선택하여 생성자를 생성, 그에 맞추어 객체를 생성해주는 방식이다,
```java 
Transaction transaction = new Transaction("출금", amount, balance, day, time);
```
그런데 지금 단순히 보아도, 다음과 같은 불편함이 보인다.
 1. **객체 생성시의 어려움** ->
필드가 많아질 수록, 생성자와 필드 순서가 맞지않는 경우 등 객체 생성시 헷갈림.


2. 생성자가 해당 생성자밖에 없는 경우, 어쩔수없이 **0, null** 등의 빈 값을 채워 전달해주어야한다.


3. 타입이 다양할수록 메서드 수가 기하급수적으로 늘어남.

> ✔ 점층적 생성자 패턴은 가독성과 유지보수 측면에서 좋지않다.

그래서 위 단점을 보완하기위해 Setter 메서드를 사용한 자바 빈(Bean) 패턴이 고안되었다.
매개변수가 없는 생성자로 객체를 생성후 Setter 메서드를 이용해 필드의 초기값을 주입해주는 방식이다.
>**자바 Bean**으로 구현된 Transaction 클래스.
``` java
public class Transaction {

    private String transactionDate; //거래일
    private String transactionTime; //거래시간
    private String kind; //구분(입금 또는 출금)
    private long amount; //거래금액
    private long balance; //잔고

    public Transaction() {}
    
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
    
    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
    
    public void setBalance(long balance) {
        this.balance = balance;
    }
```
Main 자바코드에서 빈 객체를 생성 후 값을 주입해주는 Java Bean방식
```java
Transaction transaction = new Transaction();
transaction.setTransactionDate(day);
transaction.setTransactionTime(time);
transaction.setKind("출금");
transaction.setAmount(amount);
transaction.setBalance(balance);
```
차이가 보이는가? 이제는 생성자 필드값의 순서도,원하는 필드만의 생성도, 가독성도 챙길 수 있다.
그러나 이러한 방식은 또 다음의 단점이 있다.

1. 일관성 문제 
   - 필수 매개변수에 대해 setter를 호출하지않으면, 유효하지 않은 객체 생성 가능성이 존재 -> 런타임 에러 유발

2. 불변성 문제 
   - setter 메서드는 지양해야한다. 누군가가 데이터값을 임의로 조작할 수 있기때문

> ✔ 자바 bean 방식은 유연하며 가독성이 좋으나, **일관성**과 **불변성** 문제가 존재한다.

이러한 단점을 모두 잡은 방식이 바로 **Builder 패턴**이다.

## 3. 빌더 패턴과 장단점
> 별도의 Builder 클래스를 만들어 메소드를 통해 step-by-step 으로 값을 입력받은 후에 최종적으로 build() 메소드로 하나의 인스턴스를 생성하여 리턴하는 패턴

다음 코드를 통해 알아보자.
```java
// 생성자 방식
Transaction transaction = new Transaction("출금", amount, balance, day, time);

// 빌더 방식
Transaction transaction = new Transaction.Builder(day,time)
        .kind("출금")
        .amount(amount)
        .balance(balance)
        .build();
```

더이상 생성자 오버로딩 열거를 하지 않아도 되며, 데이터의 순서에 상관없이 객체를 만들어내 생성자 인자 순서를 파악할 필요도 없고 잘못된 값을 넣는 실수도 하지 않게 된다. 
> 점층적 생성자 패턴과 자바 Beans 패턴 두 가지의 장점만을 취한 형태

그럼 장점들을 코드를 통해 자세히 알아보자.

#### 1️⃣ 객체 생성 과정을 일관된 프로세스로 표현한다.
```java
// 생성자 방식
Transaction transaction = new Transaction("출금", amount, balance, day, time);

// 빌더 방식
Transaction transaction = new Transaction.Builder(day,time)
        .kind("출금")
        .amount(amount)
        .balance(balance)
        .build();
```
딱봐도 직관적으로 매개변수를 설정할때 혼동을 줄이고, 가독성을 높였다.

#### 2️⃣ default 매개변수 생략을 간접적으로 지원한다.

이게 무슨말이냐 하면, 기존 자바에서의 생성자 방식에서는, 값이 할당되지않은 필드의 default값을 사용해주려면,
해당 필드에 default값을 선언해주고, 그에 맞는 생성자를 생성하여 써야했다. 즉, 생성자 오버로딩 문제가 있었다.
그러나 builder 클래스에서 해당 default값을 설정하는 메서드를 호출하지않는 방식으로 생략하는 효과를 간접적으로 구현할 수 있다는 것이다.
다음 예제코드로 한번에 확인해본다.


#### 3️⃣ 필수 멤버와 선택적 멤버를 분리가능하다.

기존 방식에서는 선택적 멤버를 사용하지않으려면 **0또는 null**을 대입해야했지만, 이제는 구분하여 생성가능하다.
``` java
public class Transaction {
    // 빌더패턴을 사용하기때문에 fianl 원상복귀
    // ✨빌더패턴은 final로 불변성 보장해주는게 일반적임.
    private final String transactionDate; //거래일
    private final String transactionTime; //거래시간
    private final String kind; //구분(입금 또는 출금)
    private final long amount; //거래금액
    private final long balance; //잔고
    
    // 정적 내부 빌더 클래스
    public static class Builder {
    
        // 필수 파라미터
        private final String transactionDate;
        private final String transactionTime;
        
        // 선택 파라미터
         private final String kind = "출금"; // default 매개변수 생략
         private final long amount;
         private final long balance;
         
         // 필수 파라미터는 빌더 생성자로 받게한다.
         public Builder(String transactionDate,String transactionTime){
            this.transactionDate = transactionDate;
            this.transactionTime = transactionTime;
         }
         
         // 선택 파라미터는 각 메서드를 통해 정의한다.
         public Builder kind(String kind){
            this.kind = kind;
            return this;
         }
         
         public Builder amount(long amount){
            this.amount = amount;
            return this;
         }
         
         public Builder balance(long balance){
            this.balance = balance;
            return this;
         }
         
         // 대상 객체의 private 생성자를 호출하여 최종 인스턴스화 한다
        public Transaction build() {
            return new Transaction(this); // 빌더 객체 자신을 넘긴다.
        }
    }
    // private 생성자 - 생성자는 외부에서 호출되는것이 아닌 빌더 클래스에서만 호출되기 때문에
    private Transaction(Builder builder) {
        this.transactionDate = builder.transactionDate;
        this.transactionTime = builder.transactionTime;
        this.kind = builder.kind;
        this.amount = builder.amount;
        this.balance = builder.balance;
    }
}
```
객체 생성 코드
```java
// .kind 호출하지않으므로 default 매개변수 생략 간접 지원
Transaction transaction = new Transaction.Builder(day,time) // static inner class 초기화 (필수 파라미터)
        .amount(amount) // 선택 파라미터
        .balance(balance)
        .build();
```

#### 4️⃣ 객체 생성 단계를 지연할 수 있다.

```java
// .kind 호출하지않으므로 default 매개변수 생략 간접 지원
List<Builder> builders = new ArrayList<>();

// 2. 객체를 최종 생성 하지말고 초깃값만 세팅한 빌더만 생성
        builders.add(
        new Builder(day,time) 
        .amount(amount)
        .balance(balance)
        );


        builders.add(
        new Builder(day,time)
        .kind("출금")
        .amount(amount)
        .balance(balance)
        );

        builders.add(
        new Builder(day,time)
        .kind("입금")
        .amount(amount)
        );

// 3. 나중에 빌더 리스트를 순회하여 최종 객체 생성을 주도
        for(Builder b : builders) {
        Transaction transaction = b.build();
        System.out.println(transaction);
        }
```

#### 5️⃣ 초기화 검증을 멤버별로 분리 가능하다.

###### 생성자로 부터 멤버값을 받는 형태 
 - 각 생성자 매개변수에 대한 검증 로직을 생성자 메소드 마다 복잡하게 구현.

###### 빌더를 이용 
- 생성될 객체의 멤버 변수의 초기화와 검증을 각각의 멤버별로 분리해서 작성할 수 있다.
빌더의 각각의멤버 설정 메서드에서 검증 과정을 분담함으로써 유지 보수를 용이하게 가능.

#### 6️⃣ ✨Setter메서드를 사용하지않아 변경 가능성을 최소화하여 불변성 보장

### 그렇다면 단점은??
1. 코드 복잡성 증가 -> 클래스를 새로 생성해야하기에 복잡해질수 있다.
2. 생성자보다는 성능적인 면에서 떨어진다 -> 한단계 더 인스턴스화를 진행하기때문
3. 지나친 빌더 남용은 금지 -> 필드 개수가 적거나, 변경 가능성이 없으면 [정적 클래스 메서드](https://inpa.tistory.com/entry/GOF-%F0%9F%92%A0-%EC%A0%95%EC%A0%81-%ED%8C%A9%ED%86%A0%EB%A6%AC-%EB%A9%94%EC%84%9C%EB%93%9C-%EC%83%9D%EC%84%B1%EC%9E%90-%EB%8C%80%EC%8B%A0-%EC%82%AC%EC%9A%A9%ED%95%98%EC%9E%90) 를 사용하자. 하이퍼링크 참조

### 구현 -> 보통 Simple Builder 패턴으로 구현한다.
구현방식은 **정적 내부 클래스** 로 구현되며, 위 코드와 동일하다.
``` java
public class Transaction {
    // 빌더패턴을 사용하기때문에 fianl 원상복귀
    // ✨빌더패턴은 final로 불변성 보장해주는게 일반적임.
    private final String transactionDate; //거래일
    private final String transactionTime; //거래시간
    private final String kind; //구분(입금 또는 출금)
    private final long amount; //거래금액
    private final long balance; //잔고
    
    // 정적 내부 빌더 클래스
    public static class Builder {
    
        // 필수 파라미터
        private final String transactionDate;
        private final String transactionTime;
        
        // 선택 파라미터
         private final String kind = "출금"; // default 매개변수 생략
         private final long amount;
         private final long balance;
         
         // 필수 파라미터는 빌더 생성자로 받게한다.
         public Builder(String transactionDate,String transactionTime){
            this.transactionDate = transactionDate;
            this.transactionTime = transactionTime;
         }
         
         // 선택 파라미터는 각 메서드를 통해 정의한다.
         public Builder kind(String kind){
            this.kind = kind;
            return this;
         }
         
         public Builder amount(long amount){
            this.amount = amount;
            return this;
         }
         
         public Builder balance(long balance){
            this.balance = balance;
            return this;
         }
         
         // 대상 객체의 private 생성자를 호출하여 최종 인스턴스화 한다
        public Transaction build() {
            return new Transaction(this); // 빌더 객체 자신을 넘긴다.
        }
    }
    // private 생성자 - 생성자는 외부에서 호출되는것이 아닌 빌더 클래스에서만 호출되기 때문에
    private Transaction(Builder builder) {
        this.transactionDate = builder.transactionDate;
        this.transactionTime = builder.transactionTime;
        this.kind = builder.kind;
        this.amount = builder.amount;
        this.balance = builder.balance;
    }
}
```
추가적으로 GOF 즉, 디렉터 빌더 패턴도 있으나, 추후 적용 기회가 생기면 학습하는것으로 한다.
자세한 정보는 [GOF 디렉터 빌더 패턴 정리](https://inpa.tistory.com/entry/GOF-%F0%9F%92%A0-%EB%B9%8C%EB%8D%94Builder-%ED%8C%A8%ED%84%B4-%EB%81%9D%ED%8C%90%EC%99%95-%EC%A0%95%EB%A6%AC) 위 하이퍼링크 참조.

