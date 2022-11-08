# MVC 구조

MVC 패턴의 구조는 Model, View, Controller 3가지로 나누어진다.

- 모델은 어떠한 동작을 수행하는 코드를 이야기한다. 여기서 무엇을 할 지를 정하고, 비즈니스 로직과 DB 등에 대한 처리를 수행한다.
- 컨트롤러는 뷰와 모델을 이어주는 역할을 맡는다. 컨트롤러는 모델에 질의를 보내고 그 값을 사용자에게 적절하게 보여준다.
- 뷰는 사용자에게 보이는 영역이다. 뷰의 요청에 따라 모델의 상태를 바꾸고, 이를 다시 뷰에 전달한다.

## MVC 패턴 - 흐름

1. Client가 Request를 보낸다.
2. Request URL에 알맞은 Controller가 수신한다.
3. Controller는 넘어온 요청을 처리하기 위해 Service를 호출한다.
4. Service는 Repository에서 정보를 가져와 적절하게 가공하여 Controller에게 데이터를 넘긴다.
5. Controller는 Service의 결과물을 Client에게 전달해준다.

![Untitled](MVC%20%E1%84%80%E1%85%AE%E1%84%8C%E1%85%A9%20fc9ec0df985143d894387f37b0020777/Untitled.png)

질문/내가 아는 것이 맞는건가…

<     VIEW      > <  CONTROLLER  >                   <          MODEL           >

DTO에서 Entity로 바꾸려면 toEntity()메소드를 이용하면 된다.

Entity는 데이터베이스랑 똑같이 만들면 된다.

그러면, Entity를 기준으로 두고, DTO는 상황에 따라 객체를 만들어내는 것인가?

그러면, DTO CLASS에는 필수로 가져야되는 필드가 없는 것인가 그러니깐 @Notnull 쓰는 것인가?

### Controller

- 외부 요청과 응답에 대한 전반적인 영역을 의미한다.

### Service

- 말 그대로 서비스(@Service)이다.
- 일반적으로 컨트롤러와 저장소(Repository,Dao)의 중간에 위치한다.
- Repository에서 얻어온 정보를 바탕으로 자바 문법을 이용하여 가공 후 다시 Controller에게 정보를 보내는 곳이다.

⇒ Service가 필요한 이유는 Controller에서 Repository로 바로 접근하면, 원본 데이터 손상 위험이 있기 때문에, Service를 거쳐서 데이터에 접근한다

또한, 데이터베이스에서 추출한 정보의 복사본인 DTO를 만들어 정보를 전달한다.

- Service는 비즈니스 로직을 처리하는 곳이 아니다.
- Service는 도메인 모델의 비즈니스 로직을 순서대로 호출해주고, 트랜잭션을 보장하면서, DB와의 연산을 수행하는 곳이다.

### Repository

- DB와 같은 데이터 저장소에 접근하는 영역이다.
- Service와 DB를 연결하는 고리의 역할
- SQL을 사용해 DB에 접근한 후 적절한 CRUD API를 제공한다.
- “Object” 단위 → (sql을 이용한 CRUD) → DB의 “Record” 단위로 저장되는 순서 → Object와 Record간의 miss match가 발생하면, 이를 해결해주어야한다.

### DAO

- DB에 접근하기 위한 객체이다.
- 서비스와 DB를 연결하기 위한 중간다리의 역할을 한다.

### DAO와 Repository의 차이

제공/관리하는 주체의 차이에 따라서 달라진다.

Repository는 자바 객체를 테이블에 매핑 할 수 있고, 이는 매핑 레밸이 객체 수준임을 알 수 있다.

DAO는 SQL에 대한 매핑이기 때문에, 매핑 레벨이 SQL 수준이다.

⇒ 결론, Repository에서는 DAO를 여러개 선언해서 사용할 수 있다.

### DTO

- DTO(Data Transfer Object)는 계층 간의 데이터 교환을 위한 객체를 이야기한다.
- 구체적으로, DB에서 데이터를 얻어 Service나 Controller 등으로 보낼 때 사용하는 객체를 말한다.
- 로직을 가지고 있지 않은 순수한 데이터 객체이다.
- DTO 클래스에는 값을 임의로 변경할 필요가 없기 때문에, setter()가 없다. ( 생성자에서 값 할당)
- @Data 어노테이션 사용

(@Data 어노테이션은 @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode를 한꺼번에 설정해준다)

### VO

- VO는 값 그 자체를 나타내는 객체이다.
- DTO와 반대로 로직을 포함할 수 있으며, VO의 경우 특정 값 자체를 표현하기 때문에 불변성 보장을 위해 생성자를 사용하여야한다.

DTO와 VO의 차이 실제 코드를 예시로 들어서 확인해봐야함

### Entity

- 실제 DB의 테이블과 매칭될 클래스( @Entity, @Column, @Id 등을 이용)

DTO Class와 Entity Class를 분리하는 이유??

1. View Layer와 DB Layer의 역할을 철저하게 분리하기 위해서
2. 테이블과 매핑되는 Entity 클래스가 변하면 여러 클래스에 영향을 끼치는 반면, View와 통신하는 DTO 클래스는 자주 변경되므로 분리해야한다.

---

## 질문

1. MVC에서 V가 user가 보는 것이 맞나?? b/c mvc패턴의 v는 controller까지 포함이된다는 말을 블로그에서 봐서 혼동이 온다.
2. 프로젝트를 만들 때, 구조가 controller 패키지, service패키지, repostiroy 패키지, domain패키지로 나눈다하면, dto(값 전달할 때 사용)와 vo(불변)는 domain에 들어가고, entity(데이터베이스와 연동되니깐 얘도 불변, 그러니깐 값 추가되는 것 제외하고)는 repository에 들어는 것인가(내가 이해한 것이 맞는 것인가)
3. 기준이 데이터베이스와 직접적으로 연결되는 entity를 기준으로 하고, dto는 상황에따라서 필드값이 다 있을 수도 없을 수도 있는 것이 맞는 것인가