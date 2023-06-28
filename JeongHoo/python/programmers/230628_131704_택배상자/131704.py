# 12:41 ~ 13:35
# 입출력 100만 -> 한개 for 문
#
# first-in-first-out & first-in-last-out 둘 다 사용해야하는것 같다
#
# 가장 작은수 -> 가장 안에 넣어야지 택배가 가능하다..?
#
# [1,2,3,4,5] 로 들어온다
# [4,3,1,2,5] 로 처리를 해야한다

def solution(order):
    tmp = []
    count = 0
    current = 0
    a = 1
    while a <= len(order)+1 and current <= len(order)-1:
        if len(tmp) != 0:
            if a == tmp[-1]:
                count += 1
                tmp.pop()
            elif a == order[current]:
                current += 1
                count += 1
            else:
                tmp.append(a)
            while len(tmp) > 0 and current <= len(order)-1:
                if tmp[-1] == order[current]:
                    tmp.pop()
                    current += 1
                    count += 1
                else:
                    break  
        elif a != order[current]: # tmp = [1] -> [1,2] -> [1,2,3]
            tmp.append(a)         # tmp = [5,4,3,2]
        elif a == order[current]:
            current += 1
            count += 1
        a += 1
        
    return count
        
        
        
        
        
        