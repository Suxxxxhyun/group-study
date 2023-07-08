# 09:23 ~
#
# 입출력 : 100,000
#
# <알고리즘>
# - 해쉬맵


def solution(record):
    changed = []
    dic = {}
    
    for a in record:
        x = list(a.split(" "))
        changed.append(x)

    for a in range(len(changed)):
        if changed[a][0] != 'Leave':
            dic[changed[a][1]] = changed[a][2]
    
    print(dic)
    
    
    results = []
    for a in range(len(changed)):
        tmp = ""
        tmp += dic[changed[a][1]]
        tmp += "님이"
        if changed[a][0] == 'Enter':
            tmp += " 들어왔습니다."
        elif changed[a][0] == 'Leave':
            tmp += " 나갔습니다."
        else:
            continue
        results.append(tmp)
    
    return results
    
    
    
    
    
    
    
    
    
    
    
    