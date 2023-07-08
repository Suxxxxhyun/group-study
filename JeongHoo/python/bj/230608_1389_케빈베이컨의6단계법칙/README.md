
## 괄호제거 골5 bj
https://www.acmicpc.net/problem

### 알고리즘 사용 : 다이익스트라
- 전형적인 다익스트라 + 힙 문제

### 단계
- 생략

### 코드리뷰
```py
n, m = map(int, input().split())
l = [[] for _ in range(n+1)]
distance = [1e8]*(n+1)

for _ in range(n):
    node, destination, cost = map(int, input().split())
    l[node].append((destination, cost))


def dijikstra(start):
    q = []
    heapq.heappush(q, (0, start))
                    # 거리, 노드
    distnace[start] = 0

    while q:
        current_distance, current_node = heapq.heappop(q)
        
        if current_distnace > distacne[current_node]:
            continue

        for a in l[current_node]:
            sum_value = a[1] + current_distance

            if sum_value < distance[a]:
                distance[a] = sum_value
                heapq.heappush(q, (sum_value, a))

```
