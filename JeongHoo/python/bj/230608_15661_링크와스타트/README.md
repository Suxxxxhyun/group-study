
## 링크와스타트 실1 bj
https://www.acmicpc.net/problem/15661

### 알고리즘 사용 : 백트레킹
- 시간초과가 나서 은근 어려웠던 문제이다
- 색다른 백트래킹이었다
- 문제 풀이보다는 이해가 힘들었다

### 단계
- 생략

### 코드리뷰
```py
def recur(target):
    # n 번만큼 iterate!!
    if target == n:
        print(visited)
        score()
        return

    # 백트래킹 모든 조합을 구해준다 
    # True = Linked Team, 
    visited[target] = True
    recur(target+1)
    visited[target] = False
    recur(target+1)
    

def score():
    global min_value
    start = 0
    link = 0

    #짝수를 구하는 for 문 
    for i in range(n-1):
        for j in range(i+1,n):
               
```
