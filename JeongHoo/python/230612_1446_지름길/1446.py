# 다이익스트라

# 최단거리 초기값을 실제 거리로 설정하자

import heapq
n,d = map(int, input().split())
graph = [[] for _ in range(d+1)]
for i in range(d):
    graph[i].append([i+1,1])

distance = [1e8]*(d+1)
for _ in range(n):
    a,b,c = map(int,input().split())
    if b > d: 
        continue
    graph[a].append([b,c]) # destination, price

def dijikstra(start):
    q = []
    heapq.heappush(q, (start, 0)) # start, distance
    distance[start] = 0 # d[0] = 0
    while q:
        current_desintation, current_price = heapq.heappop(q)
        if distance[current_desintation] < current_price:
            continue
        for a in graph[current_desintation]:
            # if a[0] <= d:
            sum_desination = current_price + a[1]
            if sum_desination < distance[a[0]]:
                distance[a[0]] = sum_desination
                heapq.heappush(q, (a[0], sum_desination))
                    

dijikstra(0)
print(distance[d])