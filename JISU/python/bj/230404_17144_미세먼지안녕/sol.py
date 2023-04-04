R,C,T=map(int,input().split())
A=[list(map(int,input().split())) for _ in range(R)]
direction=[(1,0),(0,1),(-1,0),(0,-1)]
#공청기 위치
location=[]

for _ in range(T):
    spreaded=[[0 for _ in range(C)] for _ in range(R)]
    #미세먼지 퍼뜨리기
    for i in range(R):
        if A[i][0]==-1:location.append(i)
        for j in range(C):
            if A[i][j]>0:
                dust=A[i][j]//5
                #사방 체크 후 퍼트리기
                for di,dj in direction:
                    ti,tj=di+i,dj+j
                    if 0<=ti<R and 0<=tj<C and A[ti][tj]!=-1:
                        spreaded[ti][tj]+=dust
                        A[i][j]-=dust
    
    #퍼뜨려진 애들 더하기
    for i in range(R):
        for j in range(C):
            if spreaded[i][j]>0:
                A[i][j]+=spreaded[i][j]
                
    #확산
    lo_i1=location[0]
    lo_i2=location[1]
    # 반시계방향
    for i in range(lo_i1-2,-1,-1):
        A[i+1][0]=A[i][0]
    for j in range(1,C):
        A[0][j-1]=A[0][j]
    for i in range(1,lo_i1+1):
        A[i-1][C-1]=A[i][C-1]
    A[lo_i1].insert(1,0)
    A[lo_i1].pop()
    
    #시계방향
    for i in range(lo_i2+2,R):
        A[i-1][0]=A[i][0]
    for j in range(1,C):
        A[R-1][j-1]=A[R-1][j]
    for i in range(R-2,lo_i2-1,-1):
        A[i+1][C-1]=A[i][C-1]
    A[lo_i2].insert(1,0)
    A[lo_i2].pop()
    

answer=0
for i in range(R):
    for j in range(C):
        if A[i][j]>0:answer+=A[i][j]
print(answer)
