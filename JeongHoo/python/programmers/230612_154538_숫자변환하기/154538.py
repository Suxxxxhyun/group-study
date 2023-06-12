from collections import deque
def solution(x, y, n):
    # BFS
    visited = [False]*10000000
    def bfs(start):
        q = deque()
        q.append((start, 0))
        visited[start] = True
        while q:
            current, count = q.popleft()
            if current == y:
                return count
            
            if current+n <= y and visited[current+n] == False:
                q.append((current+n, count+1))
                visited[current+n] = True

            if current*2 <= y and visited[current*2] == False:
                q.append((current*2, count+1))
                visited[current*2] = True

            if current*3 <= y and visited[current*3] == False:
                q.append((current*3, count+1))
                visited[current*3] = True
     
    j = bfs(x)
    if j != None:
        return j
    else:
        return -1
        
        