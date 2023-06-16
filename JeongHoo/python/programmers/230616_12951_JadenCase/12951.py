def solution(s):
    l = [a for a in s]
    
    current = False
    numbers = ["0","1","2","3","4","5","6","7","8","9"]
    
    # 1번째 인덱스
    if l[0] not in numbers:
        l[0] = l[0].upper()
    
    for a in range(1, len(l)):
        if l[a] == " ":
            current = True
            continue
        
        # 전에 공백이었을떄
        if current:
            if l[a] == " ":
                continue
            # 공백 이후에 또 공백이 아닐때
            current = False
            l[a] = l[a].upper()
        else:
            l[a] = l[a].lower()
        
    return "".join(l)
