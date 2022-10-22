# Mission 1주차 해설

+ Http
  + GET
  + POST

## Http

---

### GET

---
mdn에서 Http GET은 다음과 같이 정의합니다.
```
HTTP `GET` 메서드는 특정한 리소스를 가져오도록 요청합니다.
`GET` 요청은 데이터를 가져올 때만 사용합니다.
```
위의 설명처럼 GET은 데이터를 가져올 때 사용하는 메서드 입니다.

그렇다면 `id=1` 과 같은 특정한 정보를 가져 오려면 어떻게 하여야할까요?

`Mission 1주차 설명`에서 키워드로 설명한 `쿼리 파라미터`를 통해 가져올 정보에 대한 조건을 줄 수 있습니다.

그렇다면 이번 미션에 대한 저가 의도한 코드를 볼까요?

```java
    @GetMapping("/query")
    public void query(@RequestParam Long id, @RequestParam String name) {
        System.out.println("By query id = " + id);
        System.out.println("By query name = " + name);
    }
```

다들 위의 코드와 유사하게 작성하셨을까요?

저도 처음 미션이라는 것을 내다보니 조금 불친절한 미션이었을 것이라고는 생각해요...!ㅠㅠ

다음부터는 조금더 잘 미션을 내도록 노력해보겠습니다!

위의 코드는 `http://localhost:8080/query?id=1&name=jongjun` 와 같은 주소로 HTTP GET 요청이 왔을 때 매핑되는 코드입니다.

쿼리로 받은 정보들을 단순히 콘솔창에 보여주는 것으로 내부 동작을 끝났지만 본래 HTTP GET의 정의를 생각한다면 받은 정보를 바탕으로 Member DB에 제약조건을 걸어주는 원하는 정보를 받아오는 등 활용할 수 있을 것 같아요!

### POST

---



### Postman

---
GET과 마찬가지로 mdn에서 어떻게 POST를 정의하는지 한번 알아봅시다.
```
HTTP `POST` 메서드는 서버로 데이털르 전송합니다.
요청 본문의 유형은 `Content-type` 헤더로 나타납니다.

`POST` 요청은 보통 HTML 양식을 통해 서버에 전송하며, 서버에서 변경사항을 만듭니다.
이 경우 콘텐츠 유형은 `<form>` 요소의 `enctype` 특성이나 `<input>`, `<button>` 요소의 `formenctype` 특성 안에 적다한 문자열을 넣어 결정합니다. 

콘텐츠 유형의 경우 크게 아래 3가지가 있습니다.

application/x-www-form-urlencoded: &으로 분리되고, "=" 기호로 값과 키를 연결하는 key-value tuple로 인코딩되는 값입니다.__ 영어 알파벳이 아닌 문자들은 percent encoded 으로 인코딩됩니다. 따라서, 이 content type은 바이너리 데이터에 사용하기에는 적절치 않습니다. (바이너리 데이터에는 use multipart/form-data 를 사용해 주세요.)

multipart/form-data

text/plain
```

위의 설명에 따르면 `POST`는 `GET`과 다르게 서버에 데이터를 전달하는 메서드이네요!

그럼 제가 `Mission 1주차 설명`에서 키워드로 설명한 `form data` 그리고 `request body` 를 통해 데이터를 받아 볼까요?

우선 제가 의도한 코드부터 보자면 아래와 같습니다.

```java
    @PostMapping("/formDataParam")
    public void formDataParam(@RequestParam Long id, @RequestParam String name) {
        System.out.println("By formData Param id = " + id);
        System.out.println("By formData Param name = " + name);
    }

    @PostMapping("/formDataModel")
    public void formDataModel(@ModelAttribute Member member) {
        System.out.println("By formData Model id = " + member.getId());
        System.out.println("By formData Model name = " + member.getName());
    }

    @PostMapping("/requestBodyMember")
    public void requestBodyMember(@RequestBody Member member) {
        System.out.println("By request Body id = " + member.getId());
        System.out.println("By request Body name = " + member.getName());
    }
```

우선 위에서부터 2개의 코드는 `POSTMAN`에서 `body`의 `form-data` 그리고 `x-www-form-urlencoded` 두가지 방식으로 동일한 데이터를 받아처리한 코드입니다.
`form-data` 그리고 `x-www-form-urlencoded`의 차이는 <a href = "https://taehoonkoo.tistory.com/232"> https://taehoonkoo.tistory.com/232 </a> 에 방문해서 읽어보시는 것을 추천합니다!

다시 코드에 대한 설명으로 돌아오면 위에서부터 2개의 코드의 차이는 파라미터입니다.

첫번째 코드는 `@RequestParam Long id, @RequestParam String name` 과 같의 Member의 `id`와 `name`을 각각 파라미터로 받았고<br>
(`@RequestParam Long id, @RequestParam String name`는 `Long id, String name`까지 줄여서 작성할 수 있지만 추천하지는 않습니다.)


두번째 코드는 `@ModelAttribute Member member` 와 같이 Member라는 객체로 한번에 `id`와 `name`를 받았습니다.<br>
(`@ModelAttribute Member member`는 `Member member`까지 줄여서 작성할 수 있습니다. 이것은 추천합니다!)


이러한 것이 가능한 이유는 스프링 덕분입니다.

스프링은 `String`, `int`, `Integer` 과 같은 단순 타입은 `@RequestParam`을

나머지의 경우 `@ModelAttribute`를 자동적으로 적용해 줍니다.

이렇게 받은 데이터를 통해 우리는 Member DB에 정보를 `insert`, `update`, `delete` 등을 할 수 있겠죠?

마지막 코드의 경우 `body`의 `form-data` 그리고 `x-www-form-urlencoded`가 `key=value` 형태로 데이터를 받는 것과 다르게 `{ 'key' : 'value' }` 형태로 데이터를 받습니다.

그렇기에 `@RequestBody`를 붙여 다른 형식의 데이터를 받는다는 것을 표시한 것입니다.

그 후의 동작은 위와 동일합니다.

혹시 이번 미션은 어떠셨나요? 피드백 주시면 저도 다음 미션부터 반영해서 미션을 만들어보려 노력하겠습니다!

**앞으로 한학기 다 같이 많이 성장해봐요!!!!**