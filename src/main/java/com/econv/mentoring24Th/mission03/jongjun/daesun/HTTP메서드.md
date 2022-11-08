# HTTP 메서드

| 메서드 | 의미 | Indempotent |
| --- | --- | --- |
| POST | Create | No |
| GET | Select | Yes |
| PUT | Update | Yes |
| DELETE | Delete | Yes |

Indempotent란 멱등성인데, 이는 여러 번 수행해도 결과가 같은 경우를 의미한다.

표를 보면, POST방식을 제외하고 멱등성이 Yes인 것을 확인 할 수 있는 데, 이는 POST방식이 다른 방식들과 다르게 리소스를 추가하는 연산이기때문이다.