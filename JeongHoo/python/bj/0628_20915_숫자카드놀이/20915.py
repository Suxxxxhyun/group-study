# 09:31 ~ 09:58 + 10:10~10:20 + 11:07~ 11:23 (총 55분)
#
# 알고리즘 : 힙을 사용해서 모든 최대수를 합너식 남는다
#
#
# 풀이: 
# 모든 6은 9로 변경하자
# 문제 핵심 : 차이를 없엔다
#
# 300 * 210 -> 63000
#
# 20202021
# ->2200 2210
# 102030
# -> 300   210
# 10203040
# -> 4100   3200 -> 13120000
#
#
# 첫쨰 이후, 다번씩 넣는다..? 
#
# <반례> -> 실패
# 00000000011
# 100000
# 10000 -> 1000000000
# 521 43 -> 22403
#
# 456 -> 6 & 54 -> 324 OK
# 931 -> 9 & 31 -> 279 OK
# 910 -> 9 * 10 -> 90
# 945 -> 9 * 54 -> 486 OK
# 
# 12345789
# 9531 * 8742 = 83320002
# -> 두개식 삭제를 하면 안되고 하나씩이다.
#
# 921 8510 -> 7837710
#          ->
#
# 123123189891238923 -> 
# 98833221 998332211 -> 986683881410148521
# 988332211 99833221 -> 9866838804218
#
#
# 12312323879 -> 93321   873221
#


import heapq

t = int(input())

results = []
for _ in range(t):
    current = list(input())
    q = []
    zero_count = 0
    
    # 우선 모두 integer로 변환 + 6->9로 변경
    for a in range(len(current)):
        if int(current[a]) == 6:
            heapq.heappush(q, -9)
        elif int(current[a]) != 0:
            heapq.heappush(q, -int(current[a]))
        elif int(current[a]) == 0:
            zero_count += 1
            
    stack_1 = ""
    stack_2 = ""
    
    if len(q) != 0:
        stack_1 += str(-heapq.heappop(q))
    if len(q) != 0:
        stack_2 += str(-heapq.heappop(q))
    
    current_is_2 = True
    while len(q) != 0:
        i = -heapq.heappop(q)
        if int(stack_1) > int(stack_2):
            stack_2 += str(i)
        else:
            stack_1 += str(i)
    
    stack_2 += "0"*zero_count
    # print(stack)

    if stack_2 != "" and stack_1 != "":
        results.append((abs(int(stack_1))*abs(int(stack_2))))
    else:
        results.append(0)
    
for a in results:
    print(a)
    
    
    
        # # current >= 1개 이상일때
        # i = -heapq.heappop(q)
        # if current_is_2:
        #     stack_2 += str(i)
        #     current_is_2 = False
        # else:
        #     stack_1 += str(i)
        #     current_is_2 = True


