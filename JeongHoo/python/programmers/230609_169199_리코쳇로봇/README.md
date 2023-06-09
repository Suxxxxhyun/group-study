## 리코쳇로봇 lvl2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/169199169199

### 알고리즘 사용 : BFS
- BFS 풀이를 하는데 좀더 방문을 구분하고 효율화 시키는것을 연습
- 전형적인 BFS지만 미끄럼 게임 처럼 한 방향을 가기 시작하면 벽을 만날떄 까지 쭉 가야한다
    - for(4) -> while 문 사용
    - nx 뿐 아니라 nnx도 생각해야함
    - 그렇다고 너무 nnx만 신경쓸수도 없고 nx 도 장애물이 없는지 확인해야한다
- 방문은 가는 길이 아닌 슬라이딩의 마지막 목적지만!
- 실전 코테에서는 디버깅하기 힘들었을듯..

### 단계
1. start at start point
2. BFS
3. for each direction -> if valid -> go straight uptil a obstacle / wall
4. mark the FINAL destination of the slide as visited (not the route)
5. if desintation -> return


### 복습
```
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
```

