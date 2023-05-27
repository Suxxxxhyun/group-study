import heapq

n,m,k,x = map(int, input().split())

graph = [[] for _ in range(n+1)]
distance = [1e8]*(n+1)

for _ in range(m):
    a,b = map(int, input().split())
    graph[a].append((b,1))
    

def dijikstra(start):
    q = []
    heapq.heappush(q,(0, start)) # q에 거리가 0인 시작점 x를 넣는다
    distance[start] = 0
    
    while q:
        dist, now = heapq.heappop(q) # now = 1, distance = 0
        
        if distance[now] < dist: # if distnace is infinity
            continue
        
        for a in graph[now]: # for nodes that are connected to 1
            current = distance[now] + a[1] # each road's distance is 1
            
            if current < distance[a[0]]:
                distance[a[0]] = current
                heapq.heappush(q, (current, a[0]))
    
    
dijikstra(x)

if k not in distance:
    print(-1)
else:
    for a in range(len(distance)):
        if distance[a] == k:
            print(a)
           