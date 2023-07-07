
# 09:43 ~ 10:19 + 10:44 ~ 10:50 = 42분
#
# skills -> 20*26*26 -> OK
#
#
# 풀이법 : 완전탐색 + 스택 / 큐
#
# 풀이 2) 
#
# 생각해야하는 상황 - 
# - 다음께 split된 배열에 전부 들어 있을때 -> count += 1
# - 현재꺼 이후에 전부가 왼쪽, 오른쪽 둘다 없을때 -> count += 1
# - 다음껏들 중 하나가 splite된 배열에 없을때 -> 실패
# - 다음것들 중 하나가 split된 왼쪽 배열에 하나라도 있을때 -> 실패
#
# 잠재적 풀이 ) skill_trees에서 skills 뺴고 다 제거한 배열을 하나 만들고 풀이
#

def solution(skill, skill_trees):    
    count = 0
    # skill trees 하나하나 iterate (BACDE -> CBADF -> AECB -> ...)
    for a in range(len(skill_trees)):    
        order = list(skill) # C, B, D
        current_skill_tree = list(skill_trees[a]) # B, A, C, D, E
        left_skill_tree = []
        
        for b in range(len(order)):
            # 만약 왼쪽에 있다면 break
            if order[b] in left_skill_tree:
                break
                
            # 만약 새로운 왼쪽에 없었고 마지막이라면 count += 1
            if b == len(order)-1:
                count += 1
                break
            
            if order[b] in current_skill_tree:
                split = skill_trees[a].split(order[b])
                left_skill_tree = list(split[0])
                current_skill_tree = list(split[1])
                
            # 만약 마지막이 아니었는데 현재 list에도 없다.. 
            else:
                # 이 라인이 굉장히 중요!!!
                # 지금 split된 값에 없었어도 계속 진행하는 조건 = 양쪽에 없다
                if order[b+1] not in left_skill_tree and order[b+1] not in current_skill_tree:
                    continue
                else:
                    break

    return count

            
            
            
            
            
            
            
