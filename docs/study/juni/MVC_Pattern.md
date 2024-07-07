# MVC 패턴에 대해 알아보자.
* * *
### 1. 등장 배경
> 코드에 대한 유지보수를 편하게 하기 위해 고안된 코드 구성 방식
### 2. 패턴의 관계와 흐름
![image](https://github.com/SysoneEduTeam4/BankAccount/assets/131724311/255c45b3-667b-4b8b-8647-e17e8578e532)
![image](https://github.com/SysoneEduTeam4/BankAccount/assets/131724311/3872764a-6309-44b1-a79a-ebe0d4232426)
> - User: 사용자가 웹 사이트에 접속한다.
> - Manipulates: Controller는 사용자가 요청한 웹 페이지를 보여주기 위해 Model을 호출한다. 
> - Updates: Model은 비즈니스 로직을 통해 DB 및 파일과 같은 데이터를 제어한 후 결과를 반환한다. 이후 Controller는 Model에게 반환받은 결과를 View에 반영한다. 
> - Sees: 데이터를 받아온 View가 사용자에게 웹 페이지를 출력하여 보여준다.

### 3. ✨패턴을 사용하기 위한 5가지 규칙!
***
##### 1. Model은 Controller와 View에 의존하지 않는다.
> Model 내부에 Controller와 View에 관련된 코드가 존재하면 안된다.
> 
> 데이터에 대한 순수 로직만 존재하는것이 바람직하다.
##### 2. View는 Model에만 의존해야하고, Controller에는 의존하면 안된다.
> View 내부에 Model의 코드만 존재할 수 있고, Controller의 코드가 있으면 안된다.

##### 3. View가 Model로부터 데이터를 받을때는, 사용자마다 다르게 보여주어야하는 데이터에 대해서만 받아야한다.
> 공통 View 컴포넌트는 Model로부터 데이터를 받지않는다.

##### 4. Controller는 Model과 View에 의존해도 된다.
> Controller 내부에는 Model과 View의 코드가 있을 수 있다.

##### 5. View가 Model로부터 데이터를 받을 때, 반드시 Controller에서 받아야한다.

***
### 4. 패턴의 장점과 한계
##### 장점 - 생산성👍 유지보수👍
>- 구성요소들의 재사용 (ex.콘솔용 어플을 웹으로 확장 할때 모델은 그대로 재사용 가능)
>- Model과 View가 다른 컴포넌트들에 종속되지 않아 확장성 증가
>- 중복 코딩 제거
>- 비즈니스 로직과 UI로직을 분리하여 각 요소들에 집중가능 -> 협업 강점
##### 단점 - Massive Controller, view와 model의 의존성
> - Model과 View는 서로의 정보를 갖고 있지 않는 독립적인 상태라고 하지만 Model과 View사이에는 Controller를 통해 소통을 이루기에 의존성이 완전히 분리될 수 없다. 
> - 그래서 복잡한 대규모 프로그램의 경우 다수의 View와 Model이 Controller를 통해 연결되기 때문에 컨트롤러가 불필요하게 커지는 현상 발생.

이러한 단점을 위한 대안 -> ***MVP, MVVM, Flux, Redux***

