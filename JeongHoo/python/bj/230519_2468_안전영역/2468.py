import sys

sys.setrecursionlimit(100000)

# https://www.acmicpc.net/problem/2468
# DFS
import copy

n = int(input())

graph = []
dx = [-1,1,0,0]
dy = [0,0,-1,1]

visited = [[False]*n for _ in range(n)]

current_max = 0
for _ in range(n):
    l = list(map(int, input().split()))
    current_max = max(current_max, max(l))
    graph.append(l)


def dfs(x,y, graph,visited, depth):
    visited[x][y] = True
    graph[x][y] = 0
        
    for a in range(4):
        nx = dx[a] + x
        ny = dy[a] + y
        if 0<=nx<n and 0<=ny<n:
            if graph[nx][ny] > depth and visited[nx][ny] == False:
                dfs(nx,ny,graph,visited,depth)
    return graph, visited

result = []
for a in range(current_max):
    tmp = copy.deepcopy(graph)
    tmp_visited = copy.deepcopy(visited)
    count = 0
    for b in range(n):
        for c in range(n):
            if tmp[b][c] > a:
                tmp, tmp_vistied = dfs(b,c, tmp, tmp_visited,a)
                count += 1
    result.append(count)

print(max(result))