## 무인도여행 lvl2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/154540

### 알고리즘 사용 : BFS

- 아주 기본적인 BFS문제이지만 다시 vistied 위치의 중요성을 느꼈다
- 계속 BFS, DFS를 썪어서 문제를 푸는데.. 구분을 명확하게 하자
- visited를 왠만하면 사용하자! -> 시간단축하려면 append / 재귀함수 다음에!

### 단계
- 생략


### 복습
```
def bfs(x,y):
    visited[x][y] = True

    while q:
        # 여기서 q.pop하고 나서 바로 visited표시 하지 말기!!!!

        for a in range(4):
            if visited[nx][ny] = False:
                q.append(nx,ny)
                visited[nx][ny] = True
```
=> visited을 pop 직후에 한다면 시간초과 날 확률이 크다 (DFS랑 크게 차이가 없다 그렇게 하면)
=>=> q.append()이후에 사용하자.
