# Mission 1주차 설명

+ Http
+ Postman

### Http

---

Http는 인터넷에서 데이터를 주고 받을 수 있는 프로토콜입니다.

Http 요청에는 크게 2가지 Get 그리고 Post가 있죠?

이 **두가지의 요청의 차이**에 대해 알아보는 것이 좋을꺼 같아요!

언제 사용하는 것이고 각 요청에 따라 우리가 어떻게 정보를 주고 받을 수 있는지 알아보는 것이 좋을 것 같아요.

어떻게 정보를 주고 받을 수 있는지에 관한 키워드는 `쿼리 파라미터` `form data` `request body`  입니다.

### Postman

---

또 단순히 알아보기만 하면 재미가 없겠죠?

그래서 약간의 실습을 하기 위해서는 Postman이라는 BackEnd의 필수 어플이 필요합니다.

Postman은 개발한 API를 프런트 뷰 없이 테스트할 수 있는 플랫폼입니다.

![PostmanImage](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/81244827-9637-4b45-8e8d-87b0da8f5ec2/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221009%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221009T055340Z&X-Amz-Expires=86400&X-Amz-Signature=d7f3d3a3020b072c59f1dc4ed0c94e9337667fe2111db3921fd756f5efd24221&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

요렇게 생겼으니 설치는 스스로 해보시기 바랍니다!

그럼 이렇게 설치한 Postman을 통해 아래 Member 클래스의 정보를  `쿼리 파라미터` `form data` `request body` 로 받아서 콘솔창에 출력해 보세요!

```java
public class Member {
	private Long id;
	private String name;
}
```

### 다음 미션

---

위의 내용을 모두 공부해 보았으면 위와 관련해서는 **REST API** 그리고 관련없이도 중요한 **Spring MVC 패턴**에 대해 공부해 보는 것도 좋을꺼 같아요!
