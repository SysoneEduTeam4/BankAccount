# Lombok Library
## Lombok?
롬복은 여러가지 어노테이션을 제공하고 컴파일 과정에서 자동으로 개발자가 원하는 메소드를 생성/주입 방식으로 동작하는 라이브러리로 개발자의 생산성을 높혀주는 쉽고 편리한 라이브러리이다.

### 기능
롬복은 model 클래스나 Entity 같은 도메인 클래스에 반복적으로 사용되는 getter, setter, toString과 같은 메서드를 자동으로 만들어주는 기능을 가지고 있다.
> 장점: 롬복을 사용하면 복잡하고 반복되는 코드를 어노테이션 기반으로 생성해줘서 생산성을 높혀주고 코드가 축소되어 유지보수성을 높일 수 있다. <br>
> 단점: 코드가 생략되어 직관성이 떨어질 수도 있다. 어노테이션을 난발할 수 있다.


### 사용 예시
Builder Pattern에서 사용한 아래의 Account 코드를 Lombok Library를 사용해 얼마나 코드가 단순해지는지 확인해보자.
#### 사용 전 
```java
class Account {
    // 필수 매개변수
    private String accountNumber;  // 계좌 번호
    private String accountHolder;  // 계좌 소유자

    // 선택 매개변수
    private double balance;        // 잔액
    private String accountType;    // 계좌 유형
    private double interestRate;   // 이자율

    private Account(Builder builder) {
        this.accountNumber = builder.accountNumber;
        this.accountHolder = builder.accountHolder;
        this.balance = builder.balance;
        this.accountType = builder.accountType;
        this.interestRate = builder.interestRate;
    }

    public static class Builder {
        // 필수 매개변수
        private final String accountNumber;
        private final String accountHolder;

        // 선택 매개변수
        private double balance;
        private String accountType;
        private double interestRate;

        public Builder(String accountNumber, String accountHolder) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
        }

        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder interestRate(double interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }

    // ...
}

public class Main {
    public static void main(String[] args) {
        // 빌더 패턴을 이용한 Account 객체 생성
        Account account1 = new Account.Builder("123456789", "John Doe")
                .balance(1000.0)
                .accountType("Savings")
                .interestRate(1.5)
                .build();

        Account account2 = new Account.Builder("987654321", "Jane Doe")
                .balance(2000.0)
                .build();

        Account account3 = new Account.Builder("135792468", "Alice")
                .build();

    }
}

```

#### Lombok 적용
```java
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Account {

    // 필수 매개변수
    private String accountNumber;  // 계좌 번호
    private String accountHolder;  // 계좌 소유자

    // 선택 매개변수
    private double balance;        // 잔액
    private String accountType;    // 계좌 유형
    private double interestRate;   // 이자율
}
```
```java
public class Main {
    public static void main(String[] args) {
        // 빌더 패턴을 이용한 Account 객체 생성
        Account account1 = Account.builder()
                .accountNumber("123456789")
                .accountHolder("John Doe")
                .balance(1000.0)
                .accountType("Savings")
                .interestRate(1.5)
                .build();

        Account account2 = Account.builder()
                .accountNumber("987654321")
                .accountHolder("Jane Doe")
                .balance(2000.0)
                .build();

        Account account3 = Account.builder()
                .accountNumber("135792468")
                .accountHolder("Alice")
                .build();

    }
}
```
- `@Builder`: Lombok 어노테이션으로, `builder()` 메서드를 자동으로 생성하여 빌더 패턴을 지원해준다.
- `@Getter`, `@Setter`: 필드의 getter와 setter를 자동 생성하여 사용할 수 있다.

### 롬복을 사용한 이점
- 코드의 가독성과 유지보수성이 향상된다.
- 필드에 대한 `getter`, `setter` 작성 없이도 객체의 속성을 손쉽게 설정할 수 있다.
- 빌더 패턴을 이용해 객체를 생성할 때, 인자의 순서에 구애받지 않는다.
롬복을 사용하면 코드를 간결하게 유지할 수 있으며, 객체 생성 시 필수적인 부분을 명확하게 관리할 수 있다.