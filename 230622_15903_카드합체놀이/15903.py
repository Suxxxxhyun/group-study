
# 14:20 ~ 14:26

n, m = map(int, input().split())

l = list(map(int,input().split()))


for _ in range(m):
    l.sort()
    tmp = l[0]+l[1]
    
    l[0] = tmp
    l[1] = tmp
    
print(sum(l))




