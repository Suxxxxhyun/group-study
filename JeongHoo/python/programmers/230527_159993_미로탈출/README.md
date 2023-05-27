## 미로탈출 lvl2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/159993

### 알고리즘 사용 : BFS

- 아직도 DFS/BFS 가끔 구분 모하는거 보고 조금 충격받음. 좀더 기본 알고리즘을 사용하는 경우들을 생각하고 기초를 다져야 할꺼 같음.
- 이번에도 BFS 대신 DFS로 먼저 풀었다..
    - BFS : 최단시간 (미로 같은 문제들은 BFS를 사용한다고 보면 된다(?)) => 런타임이 훨씬 빠르다
    - DFS : 면적, 트리, 최대 깊이 팔때
- BFS 안에서도 visited 표시를 틀리게 해서 시간초과가 났다.. 이것도 항상 신경 써야 할꺼 같다.
- BFS 두 function을 구현하려 하지 말고, 하나의 function에서 두개 체크포인트를 찾으려고 해야한다.
- 문제 자체는 그냥 두개 체크포인트를 지나는 최단시간.
- 전형적인 BFS문제라 BFS 몸풀기용으로 좋은거 같다.

### 단계
1. for-loop을 통해 S,E,L 좌표를 찾는다
2. BFS


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
