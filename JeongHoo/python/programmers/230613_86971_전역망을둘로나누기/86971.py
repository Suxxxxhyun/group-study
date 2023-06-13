from collections import deque

# 1. iterate하면서 전선 하나씩 끊기 (count)
# 2. dfs로 최대 깊이 확인

def bfs(graph, start, visited):
    count = 1
    q = deque()
    q.append(start)
    visited[start] = True
    
    while q:
        i = q.popleft()
        for a in graph[i]:
            if visited[a] != True:
                count += 1
                visited[a] = True
                q.append(a)    
    return count


def solution(n, wires):    
    current_min = 1e8
    wires = deque(wires)
    results = []
    
    for a in range(len(wires)):
        x = wires.popleft()
        
        graph = [[] for _ in range(n+1)]
        for b in wires:
            graph[b[0]].append(b[1])
            graph[b[1]].append(b[0])
        visited = [False]*(n+1)
        
        r = bfs(graph, 1, visited)
        other = n-r
        current_min = min(current_min, abs(other-r))
        results.append(r)
        
        wires.append(x)

    return current_min    