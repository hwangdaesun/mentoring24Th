# spring MVC

MVC 패턴이란 사용자의 요청을 처리하고 다시 사용자에게 반환하는 과정을 `Model, View, Controller` 로 구분해서 처리하는 개발 방법을 의미한다고 합니다.

그 과정을 가볍게 살펴보면 다음과 같습니다.

![1](https://user-images.githubusercontent.com/102807742/200558614-6f69d66f-2149-41e8-85c4-67b2825a682b.png)

그래서 ‘spring에서 우리는 MVC패턴을 어떻게 적용하냐?’고 하면 주로 다음과 같이 패키지를 구성하여 MVC패턴을 구현합니다.

![2](https://user-images.githubusercontent.com/102807742/200558623-afe4ebfd-c21f-4e18-9d4c-f678e2478760.png)

Repository는 DAO라고 하기도 하고 Domain Class는 VO, DTO를 나타냅니다.

위를 토대로 패키지를 구성해 보면 다음과 같다고 합니다.

![3](https://user-images.githubusercontent.com/102807742/200558628-1e7b61ef-d1c4-4c7b-a82c-2a049c067681.png)

이제 사용자 요청이 들어올 때 어떤 일이 일어나는지 알아봅시다.

우선 DispatcherServlet이 HandlerMapping을 통해 사용자 요청에 부합하는 컨트롤러(`.Class`)를 찾습니다.

그리고 HandlerAdapter을 통해 사용자 요청에 부합하는 핸들러 메서드(`.method`)를 찾습니다.

그러면 HandlerMethod에서 사용자 요청을 치리하기 위해 Service와 Repository를 거쳐 DB 작업을 한 뒤, 처리된 요청 데이처를 받아서 HandlerAdpater 메서드에게 반환한다.

이때 반환된 정보가 ModelAndView 객체다.

그리고 이 객체를 DispatcherServlet에게 반환한 다음 DispatcherServlet은 뷰 리졸버를 통해 적합한 View를 찾아 사용자 페이지에 응답 데이터를 보여준다.

그리고 비지니스 로직 구현은 서비스 계층에서 구현하라는 말을 많이 들었을 것인데 이 말의 의미는 무엇일까요?

이는 비지니스 로직을 서비스 계층에서 구현함으로써 `확장성` 과 `재사용성` 을 확보하고  `중복 코드` 를 제거하자라는 의미입니다.

Service는 인터페이스로 구현되며 보통  Repository와 1:1 매핑된다.

Service와 Repository 계층이 1:1 매핑인 이유도 확장성 때문이다.

서비스 계층에서 비지니스 로직이 확장되어도 부작용이 없기 때문이다.

그리고 위와 같은 구현시 주의해야할 사항은 다음과 같다.

1) Model은 Controller와 View에 의존하지 않아야 한다.

⇒ Model 내부에 Controller와 View에 관련되 코드가 있으면 안된다.

2) View는 Model에만 의존해야 하고, Controller에는 의존하면 안 된다.

⇒ View 내부에 Model 코드만 있을 수 있고, Controller 코드가 있으면 안된다.

3) View가 Model로 부터 데이터를 받을 때는, 사용자마다 다르게 보여주어야 하는 데이터에 대해서만 받아야 한다.

4) Controller는 Model과 View에 의존해도 된다.

⇒ Controller 내부에는 Model과 View의 코드가 있을 수 있다.

5) View가 Model로부터 데이터를 받을 때, 반드시 Controller에서 받아야 한다.