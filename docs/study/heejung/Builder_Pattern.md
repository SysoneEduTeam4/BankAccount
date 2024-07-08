## 빌더 패턴

생성과 관련된 디자인 패턴으로 , 동일한 프로세스를 거쳐 다양한 구성의 인스턴스를 만드는 생성 패턴 → build 메소드로 하나의 인스턴스를 생성하여 리턴하는 패턴 

(생성자를 가독성 좋게 만들어주는 도구)

### 장점

1. 객체 생성 과정을 일관된 프로세스로 표현 
2. 디폴트 매개변수 생략을 간접적으로 지원
3. 필수 멤버와 선택적 멤버를 분리 가능
4. 객체 생성 단계를 지연할 수 있음
5. 초기화 검증을 멤버별로 분리
6. 멤버에 대한 변경 가능성 최소화를 추구

### 단점

1. 코드 복잡성 증가
2. 생성자 보다는 성능은 떨어진다
3. 지나친 빌더 남용은 금지 

### 구현 방법

- 빌더 클래스를 선언하고 , 생성한 객체의 속성에 대한 setter 메서드를 구현

```java
public class User {
    private String name;
    private int age;
    
    public static class Builder {
    //생성자 파라미터 전부 적기 
        private String name; 
        private int age;
        
        public Builder withName(String name) {
            this.name = name;
            return this;
        }
        
        public Builder withAge(int age) {
            this.age = age;
            return this;
        }
        
        public User build() {
            User user = new User();
            user.name = this.name;
            user.age = this.age;
            return user;
        }
    }
    
    public static void main(String[] args) {
        User user = new User.Builder().withName("Henry").withAge(30).build();
    }
}
```