### Lombok ?

?개발자가 작성해야하는 코드를 단축시켜주는 다양한 에너테이션을 제공하는 자바 라이브러리

? 여러가지 어노테이션을 제공하고 이를 기반으로 코드를 컴파일과정에서 생성해주는 방식으로 동작하는 라이브러리 

### 장점

? 가독성을 높인다

? 코드 생산성을 높인다 

### 단점

? 여러가지 예외문제가 발생할 수 있다 

### 종류

| Annotation | 설명 |
| --- | --- |
| @Getter | 해당 어노테이션을 선언하면 자동으로 getXXX() 메서드를 사용 가능하게 해줍니다. |
| @Setter | 해당 어노테이션을 선언하면 자동으로 setXXX() 메서드를 사용 가능하게 해줍니다. |
| @Data | 해당 어노테이션을 선언하면 getter(), setter(), equals(), hasCode(), toString() 메서드 사용 가능하게 해줍니다.(@Getter @Setter @toString @EqaulsAndHashCode @RequiredArgsConstructor을 자동 생성해줍니다. |
| @ToString | 해당 어노테이션을 선언하면 toString() 메서드를 사용 가능하게 해줍니다. |
| @AllArgsConstructor | 해당 어노테이션을 선언하면 ‘모든’ 인자를 가지는 생성자를 구성합니다. |
| @RequriedArgsConstructor | 해당 어노테이션을 선언하면 ‘필수’ 인지를 가지는 생성자를 구성합니다. |
| @NoArgsConstructor | 해당 어노테이션을 선언하면 ‘인자가 없는’ 생성자를 구성합니다. |

### 사용 방법

```java
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
```

데이터 어노테이션 @Data 

→ @Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor 를 자동완성