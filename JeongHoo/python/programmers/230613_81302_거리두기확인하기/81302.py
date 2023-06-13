from collections import deque

dx = [-1,1,0,0]
dy = [0,0,1,-1]

def bfs(x,y, graph, visited):
    q = deque()
    q.append((x,y,0))
    visited[x][y] = True
    
    while q:
        i,j,count = q.popleft()
        
        if count == 2:
            break
        
        for a in range(4):
            nx = dx[a] + i
            ny = dy[a] + j
    
            if 0<=nx<len(graph) and 0<=ny<len(graph):
                if graph[nx][ny] != 'X' and visited[nx][ny] != True:  
                    if graph[nx][ny] == 'P':
                        return False
                    else: 
                        visited[nx][ny] = True
                        q.append((nx,ny,count+1))
    return True

def solution(places):
    
    results = []
    for place in places:
        graph = []
        current = []
        for p in place:
            graph.append([a for a in p])
        visited = [[False]*5 for _ in range(5)]
        
        for a in range(5):
            for b in range(5):
                if graph[a][b] == 'P':
                    check = bfs(a,b, graph, visited)
                    current.append(check)
    
        if False in current:
            results.append(0)
        else:
            results.append(1)
                        
            
    return results
            
            
            
            
            
            
            
            