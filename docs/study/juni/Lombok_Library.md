# ✨LomBok이란
* * *
> Lombok은 여러가지 @어노테이션을 제공하고 컴파일 과정에서 자동으로 개발자가 원하는 메소드를 생성/주입 방식으로 동작하는 라이브러리를 말한다.
* * *
### Lombok의 주요 기능

model 클래스나 Entity 같은 도메인 클래스 등에 반복되는 getter, setter, toString 등의 메소드를 자동으로 만들어주는 기능을 한다.
* * *
### Lombok 롬복의 장점
Lombok은 복잡하고 반복되는 코드를 어노테이션 기반의 코드 자동생성으로 생산성이 향상되고 코드가 축소되어 가독성 및 유지보수성을 높일 수 있다.
### Lombok 롬복의 단점
코드가 직접 눈에 보이는게 아니므로 직관성이 떨어질수 있다.

* * *
#### 적용 예시 @Builder
전에 학습한 Builder패턴 역시 Lombok이 어노테이션으로 제공해준다.
##### Lombok 적용 전
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

```java
// .kind 호출하지않으므로 default 매개변수 생략 간접 지원
Transaction transaction = new Transaction.Builder(day,time) // static inner class 초기화 (필수 파라미터)
        .amount(amount) // 선택 파라미터
        .balance(balance)
        .build();
```

##### 롬복 적용 후
```java
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString : toString() 메서드 자동 생성
public class Transaction {
    private final String transactionDate; //거래일
    private final String transactionTime; //거래시간
    private final String kind; //구분(입금 또는 출금)
    private final long amount; //거래금액
    private final long balance; //잔고
```

이처럼 코드를 간결하고 핵심 메서드만 작성할 수 있게 도와주는 것이 Lombok의 핵심기능이다.
그럼 자주 사용되는 어노테이션에 대해 알아보고 마치겠다.
* * *
### 자주 사용되는 Lombok 어노테이션

***@Getter*** : get() 자동생성

***@Setter*** : set() 자동생성

***@Builder*** : builder 클래스 자동생성

***@ToString*** : toString() 자동으로 생성

***@EqualsAndHashCode*** : equals와 hashcode를 자동으로 생성

***@NoArgsConstructor*** : 파라미터가 없는 디폴트 생성자를 생성

***@AllArgsConstructor*** : 모든 필드 값을 파라미터로 받는 생성자를 생성 -> <U>모든 필드 한번에 초기화</U>

***@RequiredArgsConstructor*** : final이나 @NonNull으로 선언된 필드만을 파라미터로 받는 생성자를 생성 -> <U>클래스가 의존하는 필드를 간단하게 초기화할때 사용</U>
