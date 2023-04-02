import re
def solution(new_id):
    answer = ''
    step1=new_id.lower()
    step2=re.sub('[^a-z0-9\.\-\_]','',step1)
    step3=''
    i=-1
    for c in step2: #while문을 사용하는 방법이 있으나 O(n^2)임. 짧아서 상관 없을듯?
        i+=1
        if i>0 and c=='.' and step2[i-1]==c:
            continue
        else:
            step3+=c
    
    
    step4=step3.lstrip('.').rstrip('.')
    
    #step5
    if step4=='':step4='a'
    
    step6=step4[:15].rstrip('.')
    
    while len(step6)<=2:
        step6+=step6[-1]
        
    return step6