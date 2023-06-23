# 09:03 ~ 09:33
# 입력 : 1,000,000 -> O(n)
# 
# 
# stack..?
#
# 1) 일단 iterate
# 2) stacak empty -> append

n = int(input())
m = int(input())
l = list(input())

answer = 0

o_count = 0
l_count = 0
current = ""
for a in l:
    if o_count == n and l_count == n+1:
        answer += 1
        l_count -= 1
        o_count -= 1
    if a == "O" and current == "I":
        o_count += 1
        current = "O"
    elif a == "I" and current == "O":
        l_count += 1
        current = "I"
    elif a == "I" and current != "O":
        l_count = 1
        o_count = 0 
        current = "I"
    elif a == "O" and current != "I":
        o_count = 0
        l_count = 0
        current  = ""

if l_count == n+1 and o_count == n:
    answer += 1

print(answer)

# I -> 1, current = I
# O -> 1, current = O
# I -> 2, current = I
# answer = 1, I=1, O=0  --> I=1,0=1, current = "O"
# I -> 2, O = 1, current = "I"
# answer = 2. I=1, O=0 -> I=1,O=1, current = "O"
# I=2, O=1, current = "I"
# answer = 3, I=1, O=0 -> I=1, O=0, current = "I"
# I->1, O->1, current = "O"
# I->2, O->1, current = "I"
# answer = 4, I=1,0=0, -> I=1, current = "I"


            
        
    









