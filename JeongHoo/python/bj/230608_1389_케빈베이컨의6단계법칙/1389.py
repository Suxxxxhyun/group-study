# 9:13 ~ 9:18 + 09:41 ~ 09:58
# 
# 다익스트라 (?) / 플로이드와샬
import heapq

n,m = map(int, input().split())
l = [[] for _ in range(n+1)]
vistied = [False]*(n+1)
distance = [1e8]*(n+1)

for _ in range(m):
    x,y = map(int, input().split())
    l[x].append([y,2])
    l[y].append(x)
    # l = [[]
    #       [3,4]
    #        [2]
    #         [1,4][1,3,5][4]]

def dijikstra(start):
    distance = [1e8]*(n+1)
    q = []
    # 시작 지점 추가
    heapq.heappush(q,(0, start))
    # 시작 지점은 항상 0
    distance[start] = 0
    
    while q:
        current_distance, current_value = heapq.heappop(q)    
        if distance[current_value] < current_distance:
            continue
        
        for a in l[current_value]:
            total_added_distance = current_distance + 1
            if total_added_distance < distance[a]:
                distance[a] = total_added_distance
                heapq.heappush(q, (total_added_distance, a))
    
    total = 0
    for a in range(1, len(distance)):
        if distance[a] < 1e8:
            total += distance[a]
    return total, start


current_min = [1e8, 0]
for a in range(1,n+1):
    returned_total, current = dijikstra(a)
    
    if returned_total < current_min[0]:
        current_min = [returned_total, current]

print(current_min[1])