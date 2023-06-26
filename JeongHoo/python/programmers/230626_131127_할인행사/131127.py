# 09:15 ~ 09:43
#
# 입출력 : 100만 -> O(n^2)까지 가능할수도..?
# 현재 날부터 + want개수(1~10) 만큼 넘어가는 방법으로..?
# 결과 : 시간 초과 날 줄 알았는데 통과

from collections import deque

def solution(want, number, discount):
    count = 0
    dic = {}
    
    # 마지막 9일은 개수가 맞지 않기 때문에 확인할 필요가 없다
    for a in range(len(discount)-9):
        # 해쉬맵으로 관리
        for i in range(len(want)):
            dic[want[i]] = number[i]
        # 오늘 기준으로 10일
        current = discount[a:a+10]      # a,a+1,a+2,a+3,a+4,a+5,a+6,a+7,a+8,a+9

        # pop를 하는데 index out of bounds 해서 반대로 itereate
        for b in range(len(current)-1,-1,-1):
            if current[b] in dic:
                if dic[current[b]] != 0:
                    dic[current[b]] -= 1
                    current.pop(b)
                else:
                    break
            else:
                 break
        
        if len(current) == 0:
            count += 1
    return count
                    
                    
                    
                    
                    

        
        
        
        
        
        
        