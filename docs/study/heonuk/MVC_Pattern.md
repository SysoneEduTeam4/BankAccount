# MVC Pattern
MVC 패턴은 '디자인패턴' 중의 하나이다.
## 🤔 Intro: 디자인 패턴이 뭐야?
라고 의문을 가질수 있을 것이다. 본래 디자인 패턴은 건축학에서 먼저 사용되었는데, 공법에 해당하는 것을 소프트웨어의 개발 방법에 공식화 한 것이다.

> 소수의 뛰어난 엔지니어가 해결한 문제를 다수의 엔지니어들이 처리할 수 있도록 한 규칙이면서 이 패턴을 통해서 구현자들 간의 _**커뮤니케이션 효율을 높이는 기법**_ 인 것이다.

이제 MVC 패턴이 무엇인지 들어가보자.

## 🤔 MVC 패턴이란?
Model & View & Controller의 약자로 애플리케이션을 세가지 역할로 구분한 개발 방법론이다.
아래의 그림을 보자
<img width="300" alt="image" src="https://github.com/SysoneEduTeam4/BankAccount/assets/117193889/b14f0983-4d74-4df1-b157-0d6cc61aeab7">


흐름을 간단하게 알아보자면,
- [1] 사용자가 Google을 통해서 "MVC패턴"을 검색을 한다.
- [2] Controller는 "MVC패턴"이라는 검색 결과 Data를 Model에 요청을 하게 된다.
- [3] 요청한 데이터를 사용자에게 전달하기 위해서 View로 데이터를 전달하게 된다.
- [4] View는 사용자가 보는 UI에 "MVC패턴"의 검색 결과 Data를 넣어서 Web Page에서 보여주게 된다.

이와 같은 흐름을 보게 되면, 각 애플리케이션의 역할을 짐작할 수 있게 될텐데 정리해보자면,
> **Model**: 데이터와 관련된 일을 한다는 것을 짐작할 수 있다.
**View**: 사용자에게 보여지는 부분을 담당하고 있다는 것을 짐작 가능하다.
**Controller**: 사용자의 요청을 받아 요청을 전달하는 역할을 하는 것을 짐작할 수 있다.

이제 MVC 패턴이 어떤 것인지, 어떤 흐름으로 사용자에게 요청이 돌아오는지 알 수 있었을 것이다.

다음은 MVC 패턴에서의 Model, View, Controller 애플리케이션 역할을 조금더 알아보고자 한다.

### 🛠️ Model
> ✅ Model은 Controller와 View에 의존하지 않는다.
➡️ Model계층 내부에 Controller와 View에 관련된 코드가 작성되어 있으면 안된다.

![](https://velog.velcdn.com/images/itoriginal/post/6e3335f4-a8ca-43b5-bf08-83eb81d88b22/image.png)

위의 코드는 간단한 이름과 나이를 가진 학생의 class 이다.
코드 내용을 들여다보면, 이 클래스 내부에는 View에 해당되거나, Controller에 해당되는 코드가 없다는 것을 알아차릴 수 있을 것이다.
이 말이 즉, 해당 코드는 Controller나 View에 의존하지 않고 있다는 것이다.

### 🛠️ View
> ✅ View는 Model에만 의존해야 하고, Controller와는 의존하면 안된다.
➡️ View 계층 내부에 Model에 관련된 코드가 작성될 수 있고, Controller와 관련된 코드는 있으면 안된다.

![](https://velog.velcdn.com/images/itoriginal/post/33f4081b-d95e-4888-8e9e-f09d54ce810f/image.png)

위의 코드를 보면 printProfile 메서드의 파라미터로 student를 받는 것을 볼 수 있다. student는 앞서 얘기한 바와 같이 Model에 관련된 코드였다.<br>
이렇게 View에는 Model에 관련된 코드가 존재해도 상관이 없는 것이다.<br>
하지만, 다음에 소개할 Controller의 코드는 View에 존재해서는 안된다.<br>

그리고 View에는 한가지 더 유의할 점이 존재한다.
> ✅ View가 Model로부터 데이터를 받는데, 이때 사용자마다 다르게 보여주어야하는 데이터에 대해서만 받아야 한다.

이게 무슨 말인지 이해하기 어려울 것이다. 이해를 돕기 위해 아래의 그림을 보자.
![](https://velog.velcdn.com/images/itoriginal/post/a79626f8-a4b1-4d39-b3d2-fc30378ad763/image.png)


벨로그 회원 정보 페이지인데, 사진과 같이 파란색 표시처럼 사용자에게 똑같이 보여 줘야 되는 부분과 빨간색 표시처럼 사용자마다 다르게 보여 줘야 되는 부분들로 나누어져있다.

> 🟦 파란색 상자: View에서 자체적으로 가지고 있어야하는 정보
🟥 빨간색 상자: Model에서 받아온 정보


다시 말하자면, View는 UI(레이아웃)에 Model로 부터 받은 데이터를 합쳐져 만들어진 화면이다.

여기서 중요한 것은, 똑같이 보여줘야 되는 부분은 Model로 부터 받는 것이 아니라 View에서 자체적으로 가지고 있어야 하는 정보들이라는 것이다.


### 🛠️ Controller
> ✅ Controller는 Model과 View에 의존해도 된다.
➡️ Controller 내부에는 Model과 View의 코드가 있을 수 있다.

#### Model과 View 두가지 모두 의존해도 되는 이유?
앞서 흐름에서 짐작했듯이, Controller는 Model과 View 사이에서 중개자 역할을 하고 있으면서, 전체 로직을 구성하기 때문이다.

> ✅ View가 Model로부터 데이터를 받을 때는, 반드시 Controller에서 받아야 한다.

![](https://velog.velcdn.com/images/itoriginal/post/8de5338e-66bc-470b-a874-38a6b1894e92/image.png)

위의 코드를 보면 Model인 Student 클래스로부터 학생의 데이터를 생성하여 View의 printProfile method에 파라미터로 전달하는 것을 확인해 볼 수 있다.



그렇다면 MVC 패턴을 사용하면 어떤 것이 좋을까?

## 🤩 MVC 패턴의 장점
MVC 패턴을 사용하게되면 사용자 인터페이스로부터 비즈니스 로직을 분리하여 비즈니스 로직을 쉽게 고칠수 있는, 즉, _**유지보수**_ 에 용이한 장점이 있을 것이다.

#### 이 외의 장점들
> 👍🏻 기능별로 코드를 분리하여 하나의 파일에 코드가 모이는 것을 방지하기 때문에 코드의 가독성을 높일 수 있고, 코드의 재사용이 증가 할 수 있다.
👍 각 구성 요소들을 독립시킴으로서, 협업이 이루어질때 맡은 부분에 집중할 수 있어 개발의 효율성을 높여 줄수 있다.

## 🫨 MVC 패턴의 한계
Model과 View는 서로의 정보를 갖고 있지 않는 독립적인 상태라고 하지만 Model과 View사이에는 Controller를 통해 소통을 이루기 때문에 의존성이 완벽하게 분리될 수 없다. 그래서 복잡한 대규모 프로그램의 경우 다수의 View와 Model이 존재하게 되고, 이는 Controller를 통해서 연결되기 때문에 Controller가 불필요하게 커지는 현상이 발생하게 될 수 있다.<br>
이러한 현상을 Massive-View-Controller 현상이라고 부르며, 이를 보완하기 위해서 MVP, MVVM, Flux, Redux 등의 다양한 패턴이 생겨난 것이다.

## 🚀 마무리하며
결국 MVC 패턴은 어떻게 하면 내가 개발하려는 프로젝트를 잘 나눌 것인지를 고민하게 하는 구조인 것 같다. 우리가 프로젝트를 시작하기에 앞서 어떤 부분들을 개발할지 나눠서 나눈 부분에 각각 역할과 책임을 두듯이, 이 패턴도 어떤 특정 역할들에 대해 분담을 할 때 가이드라인을 제시하는 방법중에 정형화(?)되면서 사용된 것이 아닌가 하는 생각이 들었다. <br>
우리는 사람이니까 내가 쓴 코드도 오랜 시간이 지나면 찾기가 어렵고, 과거의 내가 왜 이렇게 코드를 작성했는지 의문이 생길 때가 많을 것이라 생각한다. <br>
때문에, 꼭 내가 개발하려는 코드가 MVC 패턴이 아니더라도 복잡한 코드를 쉽게 찾아가고 추가하는데 익숙해질 필요가 있다고 생각이 들었다.

---
#### Reference
📺 [우아한 10분 테코톡: 제리의 MVC 패턴](https://www.youtube.com/watch?v=ogaXW6KPc8I&ab_channel=%EC%9A%B0%EC%95%84%ED%95%9C%ED%85%8C%ED%81%AC) <br/>
👨🏻‍💻 [seongwon97님의 블로그](https://velog.io/@seongwon97/MVC-%ED%8C%A8%ED%84%B4%EC%9D%B4%EB%9E%80)
