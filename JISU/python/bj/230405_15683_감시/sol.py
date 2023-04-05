from copy import deepcopy
import sys

#입력 받기
N,M=map(int,input().split())
room=[list(map(int,input().split())) for _ in range(N)]

#CCTV가 볼 수 있는 경우의 수
cases={1:[[1],[2],[3],[4]], 2:[(1,3),(2,4)], 3:[(1,2),(2,3),(3,4),(4,1)], 4:[(1,2,3),(2,3,4),(3,4,1),(4,1,2)], 5:[(1,2,3,4)]}
move=[(-1,0),(0,1),(1,0),(0,-1)]#북,동,남,서
cctv=[(i,j) for j in range(M) for i in range(N) if room[i][j] in cases]#CCTV 좌표

#CCTV가 보는대로 지도 변경
def check(d,i,j,G):
    mv_i,mv_j=move[d-1][0],move[d-1][1]
    while 0<=i<N and 0<=j<M and G[i][j]!=6:
        if G[i][j]==0: G[i][j]='#'
        i+=mv_i
        j+=mv_j

#사각지대 찾기(dfs+재귀+bruteforce)
def blind_spot(cctv_idx,map):
    if len(cctv)>0 and cctv_idx<len(cctv):
        i,j=cctv[cctv_idx][0],cctv[cctv_idx][1]
        nos=sys.maxsize
        for direction in cases[map[i][j]]:
            copied=deepcopy(map)
            for d in direction:
                check(d,i,j,copied)
            nos=min(nos,blind_spot(cctv_idx+1,copied))
        return nos
        
    #사각지대 개수 계산
    return sum([map[a].count(0) for a in range(N)])


print(blind_spot(0,room))