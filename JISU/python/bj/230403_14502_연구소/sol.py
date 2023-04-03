from itertools import combinations
from copy import deepcopy
NM=input().split()
n,m=int(NM[0]),int(NM[1])
map=[input().split() for _ in range(n)]
cord=[(i,j) for i in range(n) for j in range(m) if map[i][j]=='0']
cord_combi=list(combinations(cord,3))
max=0

def infect(i,j,G):
    move=[(0,1),(1,0),(-1,0),(0,-1)]
    for mv in move:
        if i+mv[0]>=0 and i+mv[0]<n and j+mv[1]>=0 and j+mv[1]<m and G[i+mv[0]][j+mv[1]]=='0':
            G[i+mv[0]][j+mv[1]]='3'
            infect(i+mv[0],j+mv[1],G)

for a,b,c in cord_combi:
    safe=0
    map_copy=deepcopy(map)
    map_copy[a[0]][a[1]]='1'
    map_copy[b[0]][b[1]]='1'
    map_copy[c[0]][c[1]]='1'

    #감염
    for i in range(n):
        for j in range(m):
            if map_copy[i][j]=='2':
                infect(i,j,map_copy)


    #생존 찾기
    for i in range(n):
        for j in range(m):
            if map_copy[i][j]=='0':
                safe+=1

    if safe>max:
        max=safe
print(max)
    