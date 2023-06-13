## 전력망을 돌로 나누기 lvl2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/86971

### 알고리즘 사용 : BFS + Tree
- 풀이는 쉽게 떠올렸지만 노드는 무조건 DFS를 사용한다는 착각에 풀이 방향이 틀렸었다
- 2차배열이 아닌 BFS풀이를 오랜만에 풀 수 있어서 좋은 문제였고 트리도 공부 할 수 있어 좋았다
- 프로그래머스 구조에서 바깥 function을 사용하는거에 더욱 익숙해져야 할꺼 같다
- 트리 문제도 더 다양하게 풀어봐야 할듯 하다
- q를 사용해서 조합을 했지만 사실 combinations만 사용하면 된다

### 단계
1. combinations of nodes by taking one out
2. BFS the Node Tree with the Node removed
3. Compare Gap


### 복습
1. bfs tree

```
def bfs(graph, start, visited):
    count = 1
    q = deque()
    q.append(start)
    visited[start] = True

    while q:
        j = q.popleft()
        for a in graph[j]:
            if visited[a] != True:
                count +=1
                visited[a] = True
                q.append(a)
```

2. Removeing one Node from tree and making into graph

```
wires = deque(wires)

for a in range(len(wires)):
    x = wires.popleft

    graph = [[] for _ in range(n+1)]

    for b in wires:
        graph[b[0]].append[b[1]]
        graph[b[1]].append[b[0]]
    visited[False]*(n+1)

    bfs(graph,1,visited)

    wires.append(x)

```

3. Using Combinations

```
from itertools import combinations
nodes = [[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]

combi = combinations(nodes, len(nodes)-1)

```