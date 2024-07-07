# Builder Pattern

## 🤔 Builder 패턴이란?
복잡한 객체의 생성 과정과 표현 방법을 분리하여 다양한 구성의 인스턴스를 만드는 생성 패턴이다. <br>
동일한 생성 절차에서 서로 다른 표현 결과를 만들 수 있게 하는 패턴인 것이다.

## 🌁 Builder Pattern 탄생
먼저 Builder 패턴이 탄생하기 전에는 아래의 패턴으로 개발하곤 했다.

### 1️⃣ 점층적 생성자 패턴
점층적 생성자 패턴(Telescoping Constructor Pattern)은 필수 매개변수와 함께 선택 매개변수를 0개, 1개, 2개 .. 받는 형태로,<br>
다양한 매개변수를 입력받아 인스턴스를 생성하고 싶을때 사용하던 **생성자를 오버로딩** 방식이다.

```java
class Account {
    // 필수 매개변수
    private String accountNumber;  // 계좌 번호
    private String accountHolder;  // 계좌 소유자

    // 선택 매개변수
    private double balance;        // 잔액
    private String accountType;    // 계좌 유형 (예: Checking, Savings)
    private double interestRate;   // 이자율

    public Account(String accountNumber, String accountHolder, double balance, String accountType, double interestRate) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountType = accountType;
        this.interestRate = interestRate;
    }

    public Account(String accountNumber, String accountHolder, double balance, String accountType) {
        this(accountNumber, accountHolder, balance, accountType, 0.0);
    }

    public Account(String accountNumber, String accountHolder, double balance) {
        this(accountNumber, accountHolder, balance, "Checking", 0.0);
    }

    public Account(String accountNumber, String accountHolder) {
        this(accountNumber, accountHolder, 0.0, "Checking", 0.0);
    }

    // ...
}
```

```java
public class Main {
    public static void main(String[] args) {
        // 모든 매개변수가 있는 계좌
        Account account1 = new Account("123456789", "John Doe", 1000.0, "Savings", 1.5);

        // 필수 매개변수와 계좌 잔액, 계좌 유형이 있는 계좌
        Account account2 = new Account("987654321", "Jane Doe", 2000.0, "Checking");

        // 필수 매개변수와 잔액만 있는 계좌
        Account account3 = new Account("135792468", "Alice", 1500.0);

        // 필수 매개변수만 있는 계좌
        Account account4 = new Account("246813579", "Bob");
    }
}

```

이러한 방식은 필드가 많아질 수록 인자의 수가 늘어나면서 어떤 필드 였는지 햇갈릴 경우가 생기곤 한다.<br>
어떤 계좌를 생성하기 위해서 몇 번째에 어떤 필드가 들어가야 하는지 개발자는 정확하게 파악할 필요가 있게 되는 것이다. <br>
때문에 가독성, 유지보수 등 여러가지로 좋지 않은 개발 방식이였다.

### 2️⃣️ 자바 빈(Java Beans) 패턴
자바 빈(Java Beans) 패턴은 Setter 메서드를 사용하여 객체의 필드를 설정하는 방식으로, 매개변수가 없는 생성자로 객체를 생성한 후 필요한 필드를 설정한다.

```java
class Account {
    // 필수 매개변수
    private String accountNumber;  // 계좌 번호
    private String accountHolder;  // 계좌 소유자

    // 선택 매개변수
    private double balance;        // 잔액
    private String accountType;    // 계좌 유형 (예: Checking, Savings)
    private double interestRate;   // 이자율

    public Account() {}

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // ...
}

```

```java
public class Main {
    public static void main(String[] args) {
        // 모든 매개변수가 있는 계좌
        Account account1 = new Account();
        account1.setAccountNumber("123456789");
        account1.setAccountHolder("John Doe");
        account1.setBalance(1000.0);
        account1.setAccountType("Savings");
        account1.setInterestRate(1.5);

        // 필수 매개변수와 잔액만 있는 계좌
        Account account2 = new Account();
        account2.setAccountNumber("987654321");
        account2.setAccountHolder("Jane Doe");
        account2.setBalance(2000.0);

        // 필수 매개변수만 있는 계좌
        Account account3 = new Account();
        account3.setAccountNumber("135792468");
        account3.setAccountHolder("Alice");
    }
}

```
기존 생성자 오버로딩에서 나타났던 가독성 문제점은 개선된 것을 코드를 보면 알 수 있었다.<br> 
그리고 필요한 파라미터를 Setter 메서드를 통해서 유연하게 생성이 가능해졌다.<br>
하지만 객체 생성 시점에 모든 값들을 주입 하지 않아 일관성(consistency) 문제와 불변성(immutable) 문제가 나타나게 된다.

#### 일관성 문제
필수 매개변수가 설정되지 않을 경우 객체의 일관성이 깨질 수 있다. 예를 들어, `setAccountNumber()` 또는 `setAccountHolder()`를 호출하지 않으면 객체가 유효하지 않게 된다.

#### 불변성 문제
Setter 메서드가 외부에 노출되어 있어, 객체가 생성된 후에도 필드 값을 변경할 수 있다. 이는 객체의 불변성을 보장하지 않는다.

### 3️⃣ Builder Pattern
빌더 패턴은 이러한 문제들을 해결하기 위해 별도의 Builder 클래스를 만들어 메소드를 통해 step-by-step 으로 값을 입력받은 후에 최종적으로 build() 메소드로 하나의 인스턴스를 생성하여 리턴하는 패턴이다. <br>
별도의 Builder 클래스를 만들어 메소드를 통해 단계별로 값을 설정한 후, 최종적으로 `build()` 메소드를 호출하여 객체를 생성한다.<br>
이 패턴을 사용하면 생성자 오버로딩의 문제를 피할 수 있고, 인자 순서에 관계없이 객체를 만들 수 있어 실수를 줄일 수 있다.

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

## Builder 패턴의 장점
- 가독성: 메소드 체이닝을 통해 객체를 구성할 수 있어 가독성이 좋다.
- 유연성: 인자 순서에 상관없이 객체를 생성할 수 있다.
- 안정성: 필수 매개변수를 명확히 하여 객체의 일관성을 유지할 수 있다.

#### Reference
👨🏻‍💻 [인파_님의 블로그](https://inpa.tistory.com/entry/GOF-%F0%9F%92%A0-%EB%B9%8C%EB%8D%94Builder-%ED%8C%A8%ED%84%B4-%EB%81%9D%ED%8C%90%EC%99%95-%EC%A0%95%EB%A6%AC)