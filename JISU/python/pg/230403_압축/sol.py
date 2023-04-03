import collections
def solution(msg):
    answer = []
    dic={chr(64+i):i for i in range(1,27)}
        
    msg=list(msg)
    msg.reverse()
    
    w=''
    while msg:
        c=msg.pop()
        if w+c not in dic:
            answer.append(dic[w])
            dic[w+c]=len(dic)+1
            w=''
        w+=c
    answer.append(dic[w])

    return answer
            