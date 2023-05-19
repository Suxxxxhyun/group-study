# 1. 치킨이 존재하는 모든 조합
# 2. 시작 노드 선정 (1,3,2,4,5)
# 3. Traverse through Tree -> if current node == chicken count stop + break
# save 
# compare

INF = 1e8

n,m = map(int, input().split())

l = []

for _ in range(m):
    l.append(list(map(int, input().split())))
    
graph = [[1e8]*(n) for _ in range(n)]

for a in range(m):
    graph[l[a][0]-1][l[a][1]-1] = 1
    graph[l[a][1]-1][l[a][0]-1] = 1
            
for k in range(n):
    graph[k][k] = 0
    for a in range(n):
        for b in range(n):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
            
print(graph)














# from itertools import permutations
# n, m = map(int, input().split())
# l = []
# for _ in range(m):
#     l.append(list(map(int, input().split())))
# tmp_l = [a for a in range(1,n+1)]
# combi = list(permutations(tmp_l, 2))

# # visited = [[False]*(n+1)]
# def dfs(chicken_location, start, count, distance, node_visited):
#     node_visited[start] = True
    
#     if chicken_location[start]:
#         distance.append(count*2)
    
#     for a in range(len(l)):
#         if l[a][0] == start and node_visited[l[a][1]] != True:
#             dfs(chicken_location, l[a][1], count + 1, distance, node_visited)
#         if l[a][1] == start and node_visited[l[a][0]] != True:
#             dfs(chicken_location, l[a][0], count + 1, distance, node_visited)

#     return distance
    
# results = []

# for a in range(len(combi)):
#     visited = [False for _ in range(n+1)]
#     visited[combi[a][0]] = True
#     visited[combi[a][1]] = True    
    
#     tmp = []
#     node_visited = [False for _ in range(n+1)]
#     for b in range(1,n+1):
#         results.append(dfs(visited, b, 0, tmp, node_visited))
       
# print(results)



