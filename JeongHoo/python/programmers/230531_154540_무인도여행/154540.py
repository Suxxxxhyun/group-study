from collections import deque

dx = [0,0,1,-1]
dy = [1,-1,0,0]
def bfs(x,y, graph, visited):
    count = 0
    q = deque()
    q.append([x,y])
    
    while q:
        i,j = q.popleft()
        print(int(graph[i][j]),i,j)
        count +=  int(graph[i][j])    
        visited[i][j] = True
        for a in range(4):
            nx = dx[a] + i
            ny = dy[a] + j
            if 0<=nx<len(graph) and 0<=ny<len(graph[0]):
                if graph[nx][ny] != 'X' and visited[nx][ny] == False:
                    visited[nx][ny] = True
                    q.append([nx,ny])
        
    return count, graph,visited

def solution(maps):
    graph = []
    for a in range(len(maps)):
        graph.append([b for b in maps[a]])
    
    visited = [[False]*len(graph[0]) for _ in range(len(graph))]
    
    results = []
    for a in range(len(graph)):
        for b in range(len(graph[0])):
            if graph[a][b] != 'X' and visited[a][b] != True:
                z, graph,visited = bfs(a,b,graph,visited)
                results.append(z)
    print(results)
    
    results.sort()
    if len(results) == 0:
        return [-1]
    else:
        return results
                