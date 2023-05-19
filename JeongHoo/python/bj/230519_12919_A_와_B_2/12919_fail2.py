
s = input()
t = input()

result = 0
def possibility(possible):    
    global result
    print(possible, t)
    if possible == t:
        result = 1
        return
    if len(possible) > len(t):
        return

    possibility(possible + "A")
    current_b = possible + "B"
    possibility(current_b[::-1])
    
possibility(s)

print(result)

