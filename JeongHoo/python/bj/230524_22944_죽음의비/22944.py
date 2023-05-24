from collections import deque

n, h, d = map(int, input().split())
graph = []
for _ in range(n):
    graph.append(list([a for a in input()]))
visited = [[False]*n for _ in range(n)]
walked = [[0]*n for _ in range(n)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]

umbrella_health = 0
def bfs(x,y, steps, health, dead):
    global umbrella_health, current_min    

    q = deque()
    q.append([x,y,steps, health,dead]) 
    while q:
        x,y, steps, health, dead = q.popleft()
        if health == -1:
            dead = True
        if graph[x][y] == 'E':
            return steps
        elif graph[x][y] == 'U':
            umbrella_health = d
        elif graph[x][y] == 'S':
            pass
        else:
            if umbrella_health != 0:
                umbrella_health -= 1
            else:
                health -= 1 
        for a in range(4):
            nx = x + dx[a]
            ny = y + dy[a]
            if 0<=nx<n and 0<=ny<n and visited[nx][ny] != True and dead != True:
                q.append([nx,ny,steps+1,health, dead])
                visited[nx][ny] = False
            
check =bfs(0,0,0, h, False) 
if check == None:
    print(-1)
else:
    print(check)

# if current_min == 1e8:
#     print(-1)
# else:
#     print(current_min)

# umbrella_health = 0
# results = []
# current_min = 1e8
# def dfs(x,y, steps, health):
#     global umbrella_health, current_min
#     visited[x][y] = True
    
#     if health == -1:
#         return
#     if graph[x][y] == 'E':
#         current_min = min(current_min,steps)
#         return
#     elif graph[x][y] == 'U':
#         umbrella_health = d
#     else:
#         if umbrella_health != 0:
#             umbrella_health -= 1
#         else:
#             health -= 1   
            
#     for a in range(4):
#         nx = x + dx[a]
#         ny = y + dy[a]
#         if 0<=nx<n and 0<=ny<n and visited[nx][ny] != True:
#             dfs(nx,ny, steps + 1, health)
#             visited[nx][ny] = False

# dfs(0,0,0, h)

# if current_min == 1e8:
#     print(-1)
# else:
#     print(current_min)
