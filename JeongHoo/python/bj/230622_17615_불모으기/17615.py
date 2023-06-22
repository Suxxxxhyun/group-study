# 16:00 ~ 16:15
# 
#  입출력 : 500,000
#  -> 빨간 1, 파란 1 그리디


n = int(input())
l = list(input())

red_count = 0
for a in l:
    if a == "R":
        red_count += 1
blue_count = n-red_count

# Blue
def blue(l, blue_count):
    # left
    # farthest red in left
    count = 0
    for a in l:
        if a == 'B':
            count += 1
        else:
            break
    current_min = blue_count-count
    
    # right
    # farthest red in right
    count = 0
    for a in range(len(l)-1, -1, -1):
        if l[a] == 'B':
            count += 1
        else:
            break
    current_min = min(current_min, blue_count-count)
    return current_min



# Red
def red(l, red_count):
    # left
    # farthest red in left
    count = 0
    for a in l:
        if a == 'R':
            count += 1
        else:
            break
    current_min = red_count-count
    
    # right
    # farthest red in right
    count = 0
    for a in range(len(l)-1, -1, -1):
        if l[a] == 'R':
            count += 1
        else:
            break
    current_min = min(current_min, red_count-count)
    return current_min


print(min(red(l, red_count),blue(l,blue_count)))