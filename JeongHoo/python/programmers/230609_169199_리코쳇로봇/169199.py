# 11:35 ~ 12:35
from collections import deque

dx = [1,-1,0,0]
dy = [0,0,-1,1]

def bfs(x,y, board, visited):
    q = deque()
    q.append([x,y,0])
    visited[x][y] = True
    results = []
    while q:
        i,j, steps = q.popleft()
        if board[i][j] == 'G':
            results.append(steps)
        for a in range(4):
            nx = dx[a] + i
            ny = dy[a] + j
            while True:
                nnx = nx + dx[a]
                nny = ny + dy[a]
                if 0<=nnx<len(board) and 0<=nny<len(board[a]) and board[nnx][nny] != 'D' and board[nx][ny] != 'D':
                    nx = nnx
                    ny = nny
                else:
                    break
            
            if 0<=nx<len(board) and 0<=ny<len(board[a]) and board[nx][ny] != 'D':
                if visited[nx][ny] != True:
                    q.append([nx,ny,steps+1])
                    visited[nx][ny] = True
    return results

def solution(board):
    for a,b in enumerate(board):
        board[a] = list(b)
    
    for a in range(len(board)):
        for b in range(len(board[a])):
            if board[a][b] == 'R':
                start_x = a
                start_y = b
                
    visited = [[False]*len(board[a]) for _ in range(len(board))]
    answer = bfs(start_x,start_y, board, visited)
            
    if len(answer) != 0:
        return min(answer)
    else:
        return -1
            
            
            
            
            
            