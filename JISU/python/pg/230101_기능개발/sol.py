import math
def solution(progresses, speeds):
    answer = []
    time=[]
    
    for i,p in enumerate(progresses):
        time.append(math.ceil((100-p)/speeds[i]))
    
    max=time[0]
    deploy=0
    for d in time:
        if d>max:
            answer.append(deploy)
            max=d
            deploy=1
        else:
            deploy+=1
    answer.append(deploy)
    
    return answer