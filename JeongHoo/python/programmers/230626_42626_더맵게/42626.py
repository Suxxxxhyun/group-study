# 09:03 ~ 09:14
# 입출력 : 100만 -> for문 하나로 끝내기
#
# 알고리즘:
# 힙사용해서 최소값 두개 pop -> 한가지를 넣음
# if 최소 >= K -> return

import heapq

def solution(scoville, K):
    q = []
    for a in scoville:
        heapq.heappush(q, a)
    
    count = 0
    while True:
        if len(q) == 0:
            return -1
        elif len(q) == 1 and q[0] < K:
            return -1
        elif len(q) == 1:
            first = heapq.heappop(q)
        else:    
            first = heapq.heappop(q)
            second = heapq.heappop(q)
        
        if first >= K:
            return count
        
        combination = first + second*2
        heapq.heappush(q, combination)
        count += 1
        
        
        
        
        
        
        
        
        
        