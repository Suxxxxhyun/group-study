n,m,x,y,k = map(int, input().split())

graph = []

for _ in range(n):
    graph.append(list(map(int,input().split())))

order = list(map(int, input().split()))

# 1. if map == 0 -> map = dice bottom
# 2. if map != 0 -> dice bottom = map, map = 0
# 3. 

dx = [-1,1,0,0]
dy = [0,0,1,-1]

dice = [0,0,0,0,0,0,0]

current_dice = 1

r = x
c = y

for a in range(len(order)):
    if order[a] == 4:
        nx = dx[1] + r
        ny = dy[1] + c
        
        if nx < 0 or nx>=n or ny <0 or ny >=m:
            pass
        else:
            r = nx
            c = ny
            tmp = dice[0]
            dice[0] = dice[3]
            dice[3] = dice[2]
            dice[2] = dice[1]
            dice[1] = tmp
            if graph[r][c] == 0:
                graph[r][c] = dice[0]
            else:            
                dice[0] = graph[r][c]
                graph[r][c] = 0    
            print(dice[2])


    elif order[a] ==3:
        nx = dx[0] + r
        ny = dy[0] + c
        
        if nx < 0 or nx>=n or ny <0 or ny >=m:
            pass
        else:
            r = nx
            c = ny
            tmp = dice[0]
            dice[0] = dice[1]
            dice[1] = dice[2]
            dice[2] = dice[3]
            dice[3] = tmp
            if graph[r][c] == 0:
                graph[r][c] = dice[0]
            else:            
                dice[0] = graph[r][c]
                graph[r][c] = 0    
            print(dice[2])
        
    elif order[a] ==2:
        nx = dx[3] + r
        ny = dy[3] + c

        if nx < 0 or nx>=n or ny <0 or ny >=m:
            pass
        else:
            r = nx
            c = ny
            tmp = dice[0]
            dice[0] = dice[5]
            dice[5] = dice[2]
            dice[2] = dice[4]
            dice[4] = tmp
            if graph[r][c] == 0:
                graph[r][c] = dice[0]
            else:            
                dice[0] = graph[r][c]
                graph[r][c] = 0    
            print(dice[2])

        
    elif order[a] ==1:
        nx = dx[2] + r
        ny = dy[2] + c

        if nx < 0 or nx>=n or ny <0 or ny >=m:
            pass
        else:
            r = nx
            c = ny
            tmp = dice[0]
            dice[0] = dice[4]
            dice[4] = dice[2]
            dice[2] = dice[5]
            dice[5] = tmp
            if graph[r][c] == 0:
                graph[r][c] = dice[0]
            else:            
                dice[0] = graph[r][c]
                graph[r][c] = 0    
            print(dice[2])

                
        