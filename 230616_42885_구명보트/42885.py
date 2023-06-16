from collections import deque

def solution(people, limit):
    
    # 1. 정렬 + 그리디
    people.sort()
    new_list = deque(people)
    
    answer = 0
    while len(new_list) != 0:
        if new_list[0]+new_list[-1] <=limit and len(new_list) > 1:
            new_list.pop()
            new_list.popleft()
            answer += 1
        else:
            new_list.pop()
            answer += 1
    return answer
    
    
    