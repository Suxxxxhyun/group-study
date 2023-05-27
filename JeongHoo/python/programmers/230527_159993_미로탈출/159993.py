from collections import deque

def solution(maps):
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    
    for a in range(len(maps)):
        maps[a] = list(maps[a])
        for b in range(len(maps[a])):
            if maps[a][b] == 'S':
                start_x, start_y = a,b
            if maps[a][b] == 'L':
                lever_x, lever_y = a,b
            if maps[a][b] == 'E':
                exit_x, exit_y = a,b
    
    def bfs(x,y,target_x,target_y, count):
        visited = [[False]*len(maps[0]) for _ in range(len(maps))]
    
        q = deque()
        q.append([x,y,0])
        visited[x][y] = True
        
        while q:
            current_x, current_y, count = q.popleft()
            
            if current_x == target_x and current_y == target_y:
                return count

            for a in range(4):
                nx = dx[a] + current_x
                ny = dy[a] + current_y

                if 0<=nx<len(maps) and 0<=ny<len(maps[0]):
                    if visited[nx][ny] == False and maps[nx][ny] != 'X':
                        q.append([nx,ny,count+1])
                        # 여기서 -> 다음에 넘어갈때 visited말고 지금 표시해주는것이 엄청 중요!!!!
                        visited[nx][ny] = True
        return
    
    seconds = 0
    if bfs(start_x,start_y, lever_x,lever_y,0) != None:
        seconds += bfs(start_x,start_y, lever_x,lever_y,0)
    else:
        return -1
    if bfs(lever_x,lever_y, exit_x, exit_y,0) != None:
        seconds += bfs(lever_x,lever_y,exit_x,exit_y,0)
    else:
        return -1
    
    return seconds
    
    


######## DFS 풀이 시간초과

# def solution(maps):
#     dx = [-1,1,0,0]
#     dy = [0,0,-1,1]
    
#     for a in range(len(maps)):
#         maps[a] = list(maps[a])
#         for b in range(len(maps[a])):
#             if maps[a][b] == 'S':
#                 start_x, start_y = a,b
#             if maps[a][b] == 'L':
#                 lever_x, lever_y = a,b
#             if maps[a][b] == 'E':
#                 exit_x, exit_y = a,b
    
#     def dfs_lever(x,y, count):
#         visited[x][y] = min(count, visited[x][y])

#         if x == lever_x and y == lever_y:
#             return
        
#         for a in range(4):
#             nx = dx[a] + x
#             ny = dy[a] + y
            
#             if 0<=nx<len(maps) and 0<=ny<len(maps[0]):
#                 if visited[nx][ny] == 1e8 and maps[nx][ny] != 'X':
#                     dfs_lever(nx,ny, count+1)
                    
#     def dfs_exit(x,y, count):
#         visited[x][y] = min(count, visited[x][y])

#         if x == exit_x and y == exit_y:
#             return
#         for a in range(4):
#             nx = dx[a] + x
#             ny = dy[a] + y
            
#             if 0<=nx<len(maps) and 0<=ny<len(maps[0]):
#                 if visited[nx][ny] == 1e8 and maps[nx][ny] != 'X':
#                     dfs_exit(nx,ny, count+1)
    
#     seconds = 0
#     visited = [[1e8]*len(maps[0]) for _ in range(len(maps))]
#     dfs_lever(start_x,start_y, 0)
    
#     if visited[lever_x][lever_y] != 1e8:
#         second s += visited[lever_x][lever_y]   
#     else:
#         return -1
    
#     visited = [[1e8]*len(maps[0]) for _ in range(len(maps))]
#     dfs_exit(lever_x,lever_y, 0)
#     if visited[exit_x][exit_y]!= 1e8:
#         seconds += visited[exit_x][exit_y]
#     else:
#         return -1
#     return seconds