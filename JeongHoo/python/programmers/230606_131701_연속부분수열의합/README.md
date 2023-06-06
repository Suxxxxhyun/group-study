## 연속 부분수열의 합 lvl2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/131701

### 알고리즘 사용 : Sliding Window
- Sliding Window 기초 문제
- Set 사용 연습


### 단계
1. 1~n 의 길이까지 while
2. 만약 i+n 가 out of bounds면 나눠서 추가
3. sum특성을 사용해서 중복 제거



### 복습
```
s = sum()

s.append(1)
s.append(2)
# s = (1,2)

s.append(1)
s.append(3)
# s = (1,2,3)

```