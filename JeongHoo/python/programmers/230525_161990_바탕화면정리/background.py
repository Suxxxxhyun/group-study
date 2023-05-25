# 처음에 엄청 어려운 문제인줄 알고 BFS로 시간 낭비를 했다..
# 결론은 : 간단한 완탐
# 후기 : 이렇게 코테에서 해매면 광탈함

def solution(wallpaper):
    
    new_wallpaper = []
    for a in wallpaper:
        new_wallpaper.append([g for g in a])  
        
    y_len = len(new_wallpaper[0])
    x_len = len(wallpaper)
    
    results = []
    for a in range(x_len):
        for b in range(y_len):
            if new_wallpaper[a][b] == '#':
                results.append([a,b])

    answer = [0,0,0,0]
    min_x,max_x,min_y,max_y = 1e8,0,1e8,0
    
    for a in range(len(results)):
        min_x = min(min_x, results[a][0])
        min_y = min(min_y, results[a][1])
        max_x = max(max_x, results[a][0])
        max_y = max(max_y, results[a][1])
    
    return [min_x,min_y,max_x+1,max_y+1]
        
# def solution(wallpaper):
#     dx = [-1,1,0,0]
#     dy = [0,0,-1,1]
#     new_wallpaper = []
#     for a in wallpaper:
#         new_wallpaper.append([g for g in a])
    
#     y_len = len(new_wallpaper[0])
#     x_len = len(wallpaper)
    
#     count = 0
#     for a in range(x_len):
#         for b in range(y_len):
#             if wallpaper[a][b] == '#':
#                 count += 1
    
#     results = []
#     find_min = 1e8
#     def bfs(x,y, current, visited):
#         global find_min
#         q = deque()
#         q.append([x,y])
        
#         while q:
#             current_x, current_y = q.popleft()
#             visited[current_x][current_y]
            
#             if current == count:
#                 # find_min = min(find_min, abs(current_x-x)+abs(current_y-y))
#                 # results.append(abs(current_x-x)+abs(current_y-y), [x,y,current_x,current_y])
#                 return
        
#             for a in range(4):
#                 nx = dx[a] + x
#                 ny = dy[a] + y
                
#                 if 0<=nx<x and 0<=ny<y and visited[nx][ny] != True:
#                     if wallpaper[nx][ny] == '#':   
#                         bfs(nx,ny, current+1, visited)
#                     else:
#                         bfs(nx,ny,current,visited)
    
#     for a in range(x_len):
#         for b in range(y_len):
#             visited = [[False]*(y_len) for _ in range(x_len)]        
#             bfs(a,b, 0, visited)

#     return results

