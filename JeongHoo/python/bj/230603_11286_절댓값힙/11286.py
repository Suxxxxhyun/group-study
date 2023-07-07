#09:19 ~ 09:47 -
#
# 입력 100,000 -> O(n^2) 이하로 풀자
# --> logn 을 풀어여자 퓰라눈 뮨재더
# ->for + if + if
#
# 알고리즘 : 힙
#
# 반레: 0 이 없을떄 : 10 -1 -2 -3 10 100 1000 -2003 12 
#      0 이 1나일때 : 10 -1 -2 -3 10 100 1000 -2003 12  -> -1
#
#
# 풀이 1) 헤쉬맵 떄문에 시간초과
# 풀이 2) 힙 + 스탥 -> 시간초과 -> pypy
# 풀이 3) 그냥 스택 -> 시간초과


n = int(input())
q = []
results = []
stack = []

for _ in range(n):
    tmp = int(input())
    
    if tmp != 0:  
        stack.append(tmp)
        q.append(abs(tmp))
    else:
        if len(q) == 0:
            results.append(0)
        else:
            q.sort(reverse=True)
            j = q.pop()
            if -j in stack:
                results.append(-j)
                stack.remove(-j)
            else:
                results.append(j)
                stack.remove(j)
for a in results:
    print(a)


###########################################
    

import heapq

n = int(input())
q = []
results = []
stack = []


for _ in range(n):
    tmp = int(input())
    stack.append(tmp)

    # 우선 전부 절대값으로 힙에다가 추가
    if tmp < 0:
        heapq.heappush(q, -tmp)
    elif tmp > 0:
        heapq.heappush(q, tmp)
    else:
        if len(q) == 0:
            results.append(0)
        else:
            x = heapq.heappop(q)
            if -x in stack:
                results.append(-x)
                stack.remove(-x)
            else:
                results.append(x)

for a in results:
    print(a)

###########################################

import heapq

n = int(input())

q = []
dic = {}
results = []

for _ in range(n):
    tmp = int(input())
    
    if tmp not in dic:
        dic[tmp] = 1
        if -tmp not in dic:
            dic[-tmp] = 0
    else:
        dic[tmp] += 1

    # 우선 전부 절대값으로 힙에다가 추가
    if tmp < 0:
        heapq.heappush(q, -tmp)
    elif tmp > 0:
        heapq.heappush(q, tmp)
    else:
        if len(q) == 0:
            results.append(0)
        else:
            x = heapq.heappop(q)
            if dic[-x] > 0:
                results.append(-x)
                dic[-x] -= 1
            else:
                results.append(x)
                dic[x] -= 1 

for a in results:
    print(a)
    

