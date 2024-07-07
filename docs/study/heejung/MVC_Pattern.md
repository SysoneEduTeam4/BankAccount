프로젝트를 구성할 때 그 구성요소를 세가지의 역할로 구분한 패턴 



사용자가 `controller`를 사용하게 되면 `controller`는 `model`에게서 데이터를 받아오고 받아온 데이터를 통해 `view`에서 시각적인 부분을 제어하여 사용자에게 전달 

[https://github.com/SysoneEduTeam4/BankAccount/issues/23#issuecomment-2212615578](https://private-user-images.githubusercontent.com/76714312/346378466-3bd28db5-dcc5-4c1d-ba9e-70a233ead1c7.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MjAzOTU1MTUsIm5iZiI6MTcyMDM5NTIxNSwicGF0aCI6Ii83NjcxNDMxMi8zNDYzNzg0NjYtM2JkMjhkYjUtZGNjNS00YzFkLWJhOWUtNzBhMjMzZWFkMWM3LnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDA3MDclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwNzA3VDIzMzMzNVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTdjYWFkZjM4ODkyMjE4ZTNlZjRlMjJkNDA3OGE4MGFmOTI2N2IyNDc1ZGYwZGU2YzA0MGZiNzVhMTQ4ODUzYWEmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.yHTtYu4IrOf_tBgo2J1xU2sVPpVi9fTv3AR8SoQK6tM)
### 모델 , Model

애플리케이션의 정보 , 데이터 

규칙

1. 사용자가 편집하길 원하는 모든 데이터를 가지고 있어야한다
2. 뷰나 컨트롤러에 대해서 어떤 정보도 알지 말아야 한다.
3. 변경이 일어나면 , 변경 통지에 대한 처리방법을 구현해야만 한다.

### 뷰, View

input텍스트,체크박스 항목 → 사용자 인터페이스 

( 데이터 및 객체의 입력 , 보여주는 출력 ) 

규칙

1. 모델이 가지고 있는 정보를 따로 저장해서는 안된다.
2. 모델이나 컨트롤러와 같이 다른 구성요소들을 몰라야 한다
3. 변경이 일어나면 변경통지에 대한 처리방법을 구현해야만 한다. 

### 컨트롤러 , Controller

데이터와 사용자 인터페이스 요소들을 잇는 다리역할 →이벤트 처리 부분

model과 view의 역할을 분리하는 중요한 요소 

규칙

1. 모델이나 뷰에 대해서 알고 있어야한다
2. 모델이나 뷰의 변경을 모니터링 해야한다.

### 실전 적용

1. 모델은 컨트롤러나 뷰에 의존하면 안된다.
    - 모델 내부에 컨트롤러 및 뷰와 관련된 코드가 있으면 안된다.
2. 뷰는 모델에만 의존해야 하고, 컨트롤러에는 의존하면 안된다.
    - 뷰 내부에 모델의 코드만 있을 수 있고, 컨트롤러의 코드가 있으면 안된다.
3. 뷰가 모델로부터 데이터를 받을 때는 사용자마다 다르게 보여주어야 하는 데이터에 한해서만 받아야 한다.
4. 컨트롤러는 모델과 뷰에 의존해도 된다.
    - 컨트롤러 내부에는 모델과 뷰의 코드가 있을 수 있다.
5. 뷰가 모델로부터 데이터를 받을 때는 반드시 컨트롤러에서 받아야 한다.
