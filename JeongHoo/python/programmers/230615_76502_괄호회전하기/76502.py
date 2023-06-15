from collections import deque

possible = ["[","{","("]

def check(current):
    tmp = []
    opposite_tmp = []
    for a in current:
        if a in possible:
                tmp.append(a)
        else:
            opposite_tmp.append(a)
            if a == "]" and len(tmp) != 0:
                if tmp[-1] == "[":
                    tmp.pop()
                    opposite_tmp.pop()
            elif a == ")" and len(tmp) != 0:
                if tmp[-1] == "(":
                    tmp.pop()
                    opposite_tmp.pop()

            elif a == "}" and len(tmp) != 0:
                if tmp[-1] == "{":
                    tmp.pop()
                    opposite_tmp.pop()

    if len(tmp) == 0 and len(opposite_tmp) == 0:
        return True
    else:
        return False

def solution(s):
    count = 0
    new_s = deque(s)
    for a in range(len(new_s)):
        if check(new_s):
            count += 1
        tmp = new_s.popleft()
        new_s.append(tmp)
    return count