import collections
def solution(msg):
    answer = []
    dic={}
    for i in range(26):
        dic[chr(65+i)]=i+1
        
    msg=list(msg)
    msg.reverse()
    
    w=''
    zip=0
    while msg:
        w+=msg.pop()
        if w in dic:
            zip=dic[w]
        else:
            answer.append(zip)
            dic[w]=len(dic)+1
            msg.append(w[-1])
            w=''
            zip=0
    answer.append(dic[w])
    return answer
            