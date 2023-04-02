import collections
    
#입력
NM=input().split()
N,M=int(NM[0]),int(NM[1])
room_name=[input() for _ in range(N)]
reserved=collections.defaultdict(list)
for _ in range(M):
    time=input().split()
    reserved[time].append((int(time[1]), int(time[2])))

#이용가능시간 저장
available=collections.defaultdict(list)
i=0
for name in room_name:
    
    #이용가능시간
    start,end=9,18
    
    #예약된 시간 피해서 이용가능시간 찾기
    if reserved[name]:
        reserved[name].sort(key=lambda x:x[0])
        for time in reserved[name]:
            if time[0]>start:
                available[name].append((start,time[0]))
            start=time[1]
    
    if start!=end:
        available[name].append((start,end))


    #출력
    print('Room '+name)
    if available[name]:
        print(str(len(available[name]))+" available")
        for time in available[name]:
            print(str(time[0]).zfill(2)+'-'+time[1].zfill(2))
    else:
        print('Not available')
    if i<N-1:
        print('----')
    i+=1    
        
