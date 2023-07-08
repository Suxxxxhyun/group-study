# 10:28 ~ 10:38
#
# 입력값 : 100만 -> for문 하나에 풀자 -> nlogn / n
#
# dictionary 사용해서 greedy 풀이를 해보자 

def solution(topping):
    dic_a = {}
    dic_b = {}
    type = 0
    
    # calculate types of fruit
    # create a total dictionary
    for a in range(len(topping)):
        if topping[a] not in dic_a:
            dic_a[topping[a]] = 1
            type += 1
        else:
            dic_a[topping[a]] += 1
    # {1: 4, 2: 2, 3: 1, 4: 1}
    # type = 4

    #  {1: 4, 2:1}
    #  type += 2 
    
    # {1: 0, 2: 1, 3: 1, 4: 1}
    # type_b -= 1
    # -> 3 
    
    type_b = 0
    count = 0
    for a in range(len(topping)):
        if topping[a] not in dic_b:
            dic_b[topping[a]] = 1
            type_b += 1
        else:
            dic_b[topping[a]] += 1
            
        dic_a[topping[a]] -= 1
        if dic_a[topping[a]] <= 0:
            type -=1
        if type == type_b:
            count += 1
            
    return count
            
    
        
            
            
            
            
    
    
        