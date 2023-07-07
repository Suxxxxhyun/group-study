
## n과m(9) 실2 bj
https://www.acmicpc.net/problem/15663

### 알고리즘 사용 : 백트레킹
- 기초 백트래킹 문제
- 같은 숫자가 여러개 있는 상태에서 중복값을 만들지 않기 위해 previous를 기록해야한다
- if not in 을 사용해도 괜찮지만 -> 시간초과 -> Set는 가능할지도

### 단계
- 생략

### 코드리뷰
```py
def combinations(start):
    if start == m:
        return
    current = 0
    for a in range(len(l)):
        if visited[a] == False and current != l[a]:
            visited = True
            tmp.append
            # 전꺼를 표시하자! 
            current = l[a]
               
```
아래 방지를 위해
```
4 2
9 1 9 7


1 7
1 9
1 9
7 1
7 9
7 9
9 1
9 7
9 9
9 1
9 7
9 9
```