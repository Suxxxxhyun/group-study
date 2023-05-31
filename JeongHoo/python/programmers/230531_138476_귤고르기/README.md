## 귤고르기 lvl2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/176962#

### 알고리즘 사용 : 정렬

- 전형적인 정렬 문제이다
- 처음에는 dictionary를 사용하려 했으나 그냥 단순 리스트가 더 간단하다.
- 개수를 관리해야한다면 visited와 같이 tracking 배열을 만들자

### 단계
1. tangerine에 있는 최대 귤값과 같은 길이의 list를 만든다
2. 기록을 한다
3. 계산을 한다


### 복습
```
track = [0]*(max(tangerine)+1)

for a in range(tangerine):
    track[tangerings[a]] += 1

```
