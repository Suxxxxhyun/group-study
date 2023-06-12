def solution(k, ranges):
    # 1. 각 넓이 기록
    # 1. ranges 에 따른 넓이 -> 구현 문제
    
    tmp = k
    height = [k]
    while tmp != 1:
        if tmp % 2 == 0:
            tmp = tmp//2
            height.append(tmp)
        else:
            tmp = (tmp*3)+1
            height.append(tmp)

    l = [[] for _ in range(len(height)-1)]

    for a in range(len(l)):
        if height[a] < height[a+1]:
            l[a] = height[a] + (abs(height[a]-height[a+1]))/2
        else:
            l[a] = height[a+1] + (abs(height[a]-height[a+1]))/2
    
    results = []
    for a in ranges:
        if a[1] == 0 and a[0] ==0:
            results.append(sum(l))
        else:
            i = len(l) + a[1]
            if i < a[0]:
                results.append(-1.0)
            else:
                results.append(sum(l[a[0]:i]))
                
    return(results)

        
        