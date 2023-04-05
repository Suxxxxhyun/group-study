from copy import deepcopy
N,M=map(int,input().split())
room=[list(map(int,input().split())) for _ in range(N)]

def check(d,i,j,G):
    if d==1:#북
        for x in range(i-1,-1,-1):
            if G[x][j]==0:G[x][j]='#'
            elif G[x][j]==6:break
    elif d==2:#동
        for y in range(j+1,M):
            if G[i][y]==0:G[i][y]='#'
            elif G[i][y]==6:break
    elif d==3:#남
        for x in range(i+1,N):
            if G[x][j]==0:G[x][j]='#'
            elif G[x][j]==6:break
    elif d==4:#서
        for y in range(j-1,-1,-1):
            if G[i][y]==0:G[i][y]='#'
            elif G[i][y]==6:break


cases={1:[[1],[2],[3],[4]], 2:[(1,3),(2,4)], 3:[(1,2),(2,3),(3,4),(4,1)], 4:[(1,2,3),(2,3,4),(3,4,1)], 5:[(1,2,3,4)]}
def blind_spot(i,j,directions,map):
    for d in directions:
        check(d,i,j,map)
        

    for x in range(i,N):
        start=0
        if x==i:start=j+1
        for y in range(start,M):
            if map[x][y] in cases:
                nos=[]
                for case in cases[map[x][y]]:
                    copied=deepcopy(map)
                    nos.append(blind_spot(x,y,case,copied))
                return min(nos)
    
    #사각지대 계산
    answer=0
    for a in range(N):
        for b in range(M):
            if map[a][b]==0:
                answer+=1
    
    return answer

print(blind_spot(0,-1,[],room))