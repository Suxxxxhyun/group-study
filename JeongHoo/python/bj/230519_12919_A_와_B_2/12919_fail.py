from collections import deque

s = input()
t = input()

result = []
def possibility(possible):    
    q = deque()
    q.append(possible)
        
    while q:
        current = q.popleft()

        if len(current) >= len(t):
            if current == t:
                print(1)
                return
            elif len(current) > len(t):
                print(0)
                return 
        
        current_a = current + "A"
        q.append(current_a)
        current_b = current + "B"
        new = ""
        for a in range(len(current_b)-1,-1,-1):
            new += current_b[a]
        q.append(new)

possibility(s)


        