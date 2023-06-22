# https://www.acmicpc.net/problem/11000
# 
# 16:22 ~ 16:52
# 입력값 : 200,000
#
# 최소한의 숫자로 강의실 배정.
# 타임테이블 문제 / 철선 문제 생각
#
import heapq

n = int(input())
l = []
for _ in range(n):
    l.append(list(map(int, input().split())))
    
# sort timeslots first
l.sort()    
    
timeslots = []
heapq.heappush(timeslots, l[0][1])

for a in range(1, len(l)):
    if l[a][0] >= timeslots[0]:
        heapq.heappop(timeslots)
        heapq.heappush(timeslots, l[a][1])
    else:
        heapq.heappush(timeslots, l[a][1])
        
print(len(timeslots))