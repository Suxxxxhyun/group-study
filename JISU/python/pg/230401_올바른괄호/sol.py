def solution(s):
    answer = True
    stack=[]
    brac={'(':')', '[':']', '{':'}'}

    for i in range(len(s)):
        if s[i] in brac:
            stack.append(brac[s[i]])
        else:
            if not stack: 
                return False
            if s[i]!=stack.pop():
                return False

    return True if not stack else False
