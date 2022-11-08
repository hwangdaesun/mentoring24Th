# JSON

## JSON의 구조

## 자료형

1. 숫자
2. 문자열
3. 불리언
4. 객체
5. 배열
6. NULL

### 숫자

JSON의 숫자는 JavaScript의 배정도수 부동소수점 형식을 따릅니다.

예시)

{

“age” : 24,

“weight” : 58.14,

“size” : 5.8426e+2,

}

### 문자열

JSON의 문자열은 유니코드 문자로 구성되며, 문자열에서 역슬래시{\)와 큰따옴표(”)를 사용하고 싶다면, 백슬래시(\) 이스케이프 문자를 사용합니다.

예시)

{ “name” : “sonny” }

{

“comment” : “\”sonny\”는 제 별명 입니다”

}

### 불리언

JSON에서 불리언 값은 참(true), 거짓(false)로 표현한다.

JSON에서는 항상 true, false를 소문자로 표시해야한다.

{

“marital_status” : false

}

### 객체

JSON에서 객체(object)란 데이터 이름과 값의 한 쌍으로 구성된 프로퍼티의 정렬되지 않은 집합을 의미한다.

{

“name” : “sonny”,

“age” : 24,

“height” : 171,

“weight” : 58.14

}

### 배열

JSON에서 배열이란 여러 개의 데이터가 순서를 가지고 나열된 집합을 의미한다.

{

“dog” : [

“웰시코기”,

“포메라니안”,

“푸들”

{

“ownerName: : “황대선”,

“phone” : “01012345678”

}

]

}

### null

JSON에서 null이란 아무런 값도 가지고 있지 않은 빈 값을 의미한다.

null이란 ‘값’을 가지고 있지 않는 다는 의미를 가지는 하나의 데이터값이다.