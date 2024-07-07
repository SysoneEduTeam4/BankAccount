## Builder Pattern

빌더 패턴은 복잡한 객체의 생성 과정과 표현 방법을 분리하여 다양한 구성의 인스턴스를 만드는 생성 패턴이다. 생성자에 들어갈 매개 변수를 메서드로 하나하나 받아들이고 마지막에 통합 빌드해서 객체를 생성하는 방식이다.

객체를 정의하고 그 객체를 생성할 때 보통 생성자를 생성하는 것을 생각한다.

```java
Bag bag = new Bag("name", 1000, "memo");
```

하지만 생성자를 통해 객체를 생성하는데 몇 가지 단점이 있어 객체를 생성하는 별도 builder를 두는 방법이 있다.

```java
Bag bag = Bag.builder()
					.name("name")
        	.money(1000)
        	.memo("memo")
        	.build();
```

객체를 생성할 수 있는 빌더를 builder()함수를 통해 얻고 거기에 셋팅하고자 하는 값을 셋팅하고 마지막에 build()를 통해 빌더를 작동시켜 객체를 생성한다.

## 빌더를 써야하는 이유

### 1. 생성자 파라미터가 많을 경우 가독성이 좋지 않다.

생성자 파라미터로 받아야하는 값이 많으면 각 값들이 어떤 값을 의미하는지 이해하기 힘들다.

```java
Bag bag = new Bag("name", 1000, "memo", "abc", "what", "is", "it", "?");
```

하지만 이를 빌더 패턴으로 구현하면 각 값들은 빌더의 각 값들의 이름 함수로 셋팅이 되어 각각 무슨 값을 의미하는지 파악하기 쉽다. 따라서 생성자로 설정해야하는 값이 많을 경우 빌더를 쓰는 것이 생성자보다 가독성이 좋다. 이는 같은 타입의 다른변수의 값을 서로 바꿔 넣는 것을 방지할 수도 있다.

```java
Bag bag = Bag.builder()
						.name("name")
	        	.money(1000)
	        	.memo("memo")
	          .letter("This is the letter")
	          .box("This is the box")
	        	.build();
```

### 2. 어떤 값을 먼저 설정하던 상관 없다.

생성자의 경우는 정해진 파라미터 순서대로 꼭 값을 넣어줘야한다. 순서를 무시하고 값을 넣으면 에러가 발생하거나 엉뚱한데 값이 들어갈 수 있다.

```java
public Bag(String name, int money, String memo) {
			this.name = name;
    	this.money = money;
    	this.memo = memo;
}
```

하지만 빌더 패턴은 빌더의 필드 이름으로 값을 설정하기 때문에 순서에 종속적이지 않다.

```java
Bag bag = Bag.builder()
					.name("name")
        	.memo("memo")	// memo를 money 대신 먼저!
        	.money(1000)
        	.build();
```

## 빌더 구현방법

```java
class BagBuilder {
	private String name;
	private String memo;
	private int money;
	
	public BagBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	public BagBuilder memo(String memo) {
		this.memo= memo;
		return this;
	}
	
	public BagBuilder money(int money) {
		this.money= money;
		return this;
	}
	
	public Bag build() {
		return new Bag(name, memo, money); //Bag생성자 호출
	}
	
}
```

`return this` 에서 `this` 는 BagBuilder 객체 자신을 말한다. 빌더 객체 자신을 리턴함으로써 메서드 호출 후 연속적으로 빌더 메서드들을 호출할 수 있게 된다.

```java
public static void main(String[] args) {
	Bag bag = new BagBuilder()
						.name("kkk")
						.memo("aaa")
						.money(12334)
						.build();
	
	System.out.println(bag);
}
```

빌더 클래스 실행

## Builder 디자인 패턴종류

### 이펙티브 자바의 빌더 패턴 : 생성시 지정해야 할 인자가 많을 때 사용. 객체의 일관성 불변성이 목적

- **심플 빌더 패턴(Effective Java)**
    
    보통개발자들이 빌더 패턴을 말할 때 정의되는 것이 이펙티브 자바에서 소개한 빌더 패턴이다. GOF빌더 패턴과 구분하기 위해 심플 빌더 패턴(Simple Builder Patter) 이라고도 불리운다.
    
    심플 빌더 패턴은 **생성자가 많을 경우** 또는 **변경 불가능한 불변 객체가 필요한 경우** 코드의 가독성과 일관성, 불변성을 유지하는 것에 중점을 둔다.  다만 빌더 클래스가 구현할 클래스의 **정적 내부 클래스**로 구현된다는 점이 다르다.
    
    ```java
    class Bag {
    	//final 키워드로 필드들을 불변 객체로 만든다.
    	private final String name;
    	private final int money;
    	private final String memo;
    	private final String letter;
    	private final String box;
    	
    	//private 생성자 - 생성자는 외부에서 호출되는것이 아닌 빌더 클래스에서만 호출되기 때문에
    	private Bag(Builder builder) { 
    		this.name = builder.name;
    		this.age = builder.money;
    		this.memo = builder.letter;
    		this.letter = builder.box;
    	}
    	
    	//정적 내부 빌더 클래스
    	public static class Builder {
    		//필수 파라미터
    		private final String name;
    		private final int money;
    		
    		//선택 파라미터
    		private String memo;
    		private String letter;
    		private String box;
    		
    		//필수 파라미터는 빌더 생성자로 받게한다
    		public Builder(String name, int money) {
    			this.name = name;
    			this.money = money;
    		}
    		
    		//선택 파라미터는 각 메서드를 통해 저의한다
    		public Builder memo(String memo) {
    			this.memo = memo;
    			return this;
    		}
    		
    		//선택 파라미터는 각 메서드를 통해 저의한다
    		public Builder letter(String letter) {
    			this.letter= letter;
    			return this;
    		}
    		
    		//선택 파라미터는 각 메서드를 통해 저의한다
    		public Builder box(String box) {
    			this.box= box;
    			return this;
    		}
    		
    		//대상 객체의 private 생성자를 호출하여 최종 인스턴스화한다.
    		private Bag build() {
    			return new Bag(this);//빌더 객체 자신을 넘긴다.
    		}
    	}
    }
    ```
    
    빌더 클래스가 static inner class로 구현되는 이유
    
    1) 하나의 빌더 클래스는 하나의 대상 객체 생성만을 위해 사용된다. 
    
    2) 대상 객체는 오로지 빌더 객체에 의해 초기화 된다. 즉, 생성자를 외부에 노출시키면 안되기 때문에 생성자를 private로 하고, 내부 빌더 클래스에서 private 생성자를 호출함으로써 오로지 빌더 객체에 의해 초기화 되도록 설계할 수 있다.
    
    3)  inner class를 static으로 선언하는 이유는, 정적 내부 클래스는 외부 클래스의 인스턴스 없이도 생성할 수 있는데, 만일 일반 내부 클래스로 구성한다면 내부 클래스를 생성하기도 전에 외부 클래스를 인스턴스화 해야 한다. 
    
    4) 메모리 누수 문제 때문에 static으로 내부 클래스를 정의해주어야 한다.
    
    ```java
    public static void main(String[] args) {
    	Bag bag = new bag
    				.Builder("홍길동". 1000) //static inner class 초기화(필수 파라미터)
    				.memo("this is memo")
    				.letter("this is letter")
    				.box("this is box")
    				
    	System.out.println(bag);
    }
    
    ```
    
    ### Lombok의 @Builder
    
    개발자가 좀더 편하게 빌더 패턴을 이용하기 위해 Lombok에서는 별도의 어노테이션을 지원한다.
    
    롬복의 @Builder는 심플 빌더 패턴을 다룬다.
    
    ```java
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    class Bag {
    	private final String name;
    	private final int money;
    	private final String memo;
    	private final String letter;
    	private final String box;
    	
    	//필수 파라미터 빌더 메서드 구현
    	public static BagBuilder builder(String name, int money) {
    		//빌더의 파라미터 검증
    		if (name == null || money == 0) 
    			throw new IllegalArgumentException("필수 파라미터 누락");
    			
    		//필수 파라미터 빌더 객체 반환
    		return new BagBuilder.name(name).money(money);
    	}
    	
    }
    ```
    
    @Builder : BagBuilder 빌더 클래스와 이를 반환하는 builder() 메서드 생성
    
    @AllArgsConstructor(access = AccessLevel.PRIVATE) : @Builder 어노테이션을 선언하면 전체 인자를 갖는 생성자를 자동으로 만드는데, 이를 private 생성자로 설정
    
    @ToString : toString()메서드 자동 생성
  
    public static void main(String[] args) {
  	Bag bag = Bag.Builder("홍길동". 1000) //필수 파라미터
  				.memo("this is memo")
  				.letter("this is letter")
  				.box("this is box")
  				
  	System.out.println(bag);
  }
