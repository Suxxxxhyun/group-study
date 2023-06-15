## 땅따먹기 lvl2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/12913

### 알고리즘 사용 : 다이나믹 프로그래밍

- 좋은 DP 문제이다
- 보통 DP에서 첫번째를 정의한 후 앞에거를 추가하는 반면, 땅따먹기 문제는 전에꺼를 앞을 고려하여 뒤를 정의한다
- 매순간에 최적만을 고려하는 그리디와는 다르게, 모든 상황에서의 최적을 구해야한다
    - DP와 그리디의 차이점을 한번 더 알 수 있었다


### 단계
1. create DP
2. define 1~end considering max that is not my current from the previous


### 복습
```
for a in range(1,len(land)):
    for b in range(4):
        x = 0
        y = 0
        
        # because previous max cannot be in the same row as current max
        x = max(land[a-1][:b])
        y = max(land[a-1][b+1:])

        # for all rows
        land[a][b] = land[a][b] + max(x,y)

```