def solution(targets):
    # 겹치면 하나가 된다
    # 하지만 다른거를 추가하려 할떄, 추가하는게 겹치는것중 끝닝 가장 짧은것보다 앞에 있다면 미포함
    targets.sort()
    targets.sort(key = lambda x:x[1])
    # [[1,4][3,7][4,5][4,8][5,12],[10,14],[11,13]]

    tmp = targets[0][1]
    count = 1
    
    for a in range(1,len(targets)):
        # if in current bullet range
        if targets[a][0] < tmp:
            tmp = min(targets[a][1], tmp)
        # if not
        else:
            count += 1
            tmp = targets[a][1]
            
    return count
    