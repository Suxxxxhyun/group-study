# 09:06 ~ 09:15 + 10:10~10:53
#
#
# BFS 풀이로 풀어보자
#
# 1) BFS를 통해 현재 가장 가까운 거리들을 구한다
# 2) 규칙에 따라 현재 위치를 업데이트 시켜준다
#
#
from collections import deque

n = int(input())
graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

for a in range(n):
    for b in range(n):
        if graph[a][b] == 9:
            start_x = a
            start_y = b
            
current_size = 2

dx = [0,0,-1,1]
dy = [1,-1,0,0]

def bfs(x,y, current_size):
    graph[x][y] = 0
    visited = [[False]*n for _ in range(n)]
    visited[x][y] = True
    q = deque()
    q.append((x,y, 0))
    tmp = []
    eat = False
    eaten_steps = 0
    min_count = 1e8
    while q:
        i, j, steps = q.popleft()
        if graph[i][j] != 0 and graph[i][j] < current_size and min_count >= steps:
            tmp.append([i,j])
            min_count = min(min_count, steps)
            # 먹었다면 bfs 멈추기..
            eat = True
            eaten_steps = steps
            
        if eat != True:
            for a in range(4):
                nx = dx[a]+i
                ny = dy[a]+j
                
                if 0<=nx<n and 0<=ny<n:
                    if graph[nx][ny] <= current_size and visited[nx][ny] == False:
                        visited[nx][ny] = True
                        q.append((nx,ny, steps+1))
    
    # 정렬
    tmp.sort(key=lambda x:(x[0],x[1]))
    
    if len(tmp) != 0:
        # 먹은거는 0처리
        graph[tmp[0][0]][tmp[0][1]] = 0
        return tmp[0][0], tmp[0][1], eaten_steps
    else:
        return 0,0,0


total = 0
eat_count = 0

# lvl up 도 고려하자
while True:
    start_x, start_y, returned_steps = bfs(start_x,start_y, current_size)

    total += returned_steps
    if returned_steps == 0:
        print(total)
        break 
    
    eat_count += 1
    
    if eat_count == current_size:
        current_size += 1
        eat_count = 0

# size 2
# 6 + 15
#
# size 3
# 1 + 6 + 3 
# 
# size 4
# 2 + 4 + 4 + 5
#
# size 5
# 4