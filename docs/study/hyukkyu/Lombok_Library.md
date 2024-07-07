## Lombok이란?

**Lombok**은 Java 라이브러리로 반복되는 **`getter` , `setter`, `toString` ,** 등의 메서드 작성 코드를 줄여주는 코드 다이어트 라이브러리이다. 보통 `Model` 클래스나 `Entity` 같은 도메인 클래스 등에는 수많은 멤버변수가 있고 이에 대응되는 getter와 setter 그리고 toString() 메서드 그리고 때에 따라 멤버변수에 따른 여러개의 생성자를 만들어주게 되는데 코드 자체가 반복되는 메서드로 인해 매우 복잡해지게 된다.

Lombok은 여러가지 어노테이션을 제공하고 이를 기반을 코드를 컴파일과정에서 생성해 주는 방식으로 동작하는 라이브러리이다.

## Lombok 사용시 장점과 주의사항

Lombok은 복잡하고 반복되는 코드가 줆어듦으로써 코드의 가독성을 높일 수 있고 코딩 생산성 또한 높일 수 있다. 하지만 개발자마다 호불호가 나뉘는 라이브러리로 특정 개발자들은 코드가 직접 눈에 보임으로써 직관성을 유지하는 것이 좋다고 보는 의견도 있는 만큼 프로젝트나 프로젝트 리더의 성향에 따라 사용하면 좋다.

또 주의할 사항으로 API 설명과 내부 동작을 어느정도 숙지하고 사용해야 된다는 점이다. Lombok의 `@Data` 어노테이션이나 `@ToString`어노테이션으로 자동 생성되는 `toString()` 메서드는 순환 참조 또는 무한 재귀 호출 문제로 인해 `StackOverflowError` 가 발생할 수도 있다. 롬복이 편리하다는 이유만으로 마구 사용한다면 여러가지 문제가 발생할 수 있다.

## Lombok Annotation

자주 사용하는 어노테이션

| Annotation | 설명 |
| --- | --- |
| @Getter | 자동으로 get~() 메서드를 사용 가능 |
| @Setter | 자동으로 set~()메서드를 사용 가능 |
| @Data | getter(), setter(), equals(), hashCode(), toString() 메서드 사용 가능
(@ Getter, @Setter, @toString, @EqualsAndHashCode, @RequiredArgsConstructor 자동 생성) |
| @ToString | toString() 메서드 사용가능 |
| @AllArgsConstructor | ‘모든’인자를 가지는 생성자를 구성 |
| @RequriedArgsConstructor | ‘필수’인지를 가지는 생성자를 구성 |
| @NoArgsConstructor | ‘인자가 없는’ 생성자를 구 |

## Lombok 적용 코드

```java
@Getter
@Setter
@ToString
@NoargsConstructor
@AllArgsConstructor
public class CategoryModel {
	private String id;
	private String parentId;
	private String name;
	private Long depthLevel;
	private Long seq;
	private String userYn;
}
```

Lombok을 적용하면 반복되는 코드를 줄일 수 있다.

```java
@Data
public class CategoryModel {
	private String id;
	private String parentId;
	private String name;
	private Long depthLevel;
	private Long seq;
	private String userYn;
}
```

`@Data` 어노테이션을 사용하여 여러가지 어노테이션을 붙이지 않아도 된다.

### Lombok 적용방법

1) https://projectlombok.org/download 접속하여 다운로드 후  .jar 실행하여 IDE 가 위치한 경로 선택

![Untitled](https://github.com/SysoneEduTeam4/BankAccount/assets/81544639/53b2936b-c5f8-4d84-b375-ddbf1af6852a)

2) eclipse.exe파일이 있는 곳에 lombok.jar 확인

![Untitled (1)](https://github.com/SysoneEduTeam4/BankAccount/assets/81544639/6e3fd3ef-50eb-498b-b0f5-9f3419c27a2e)

**3) Lombok 초기 설정**
![Untitled (2)](https://github.com/SysoneEduTeam4/BankAccount/assets/81544639/1f52f460-e9ef-4167-ad6f-225fb9e6f9f5)
