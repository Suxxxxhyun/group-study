# 09:06 ~ 09:17
# 조합 / 백트레킹

from itertools import combinations


l = []
while True:
    x = list(map(int, input().split()))
    if x == [0]:
        break
    else:
        x.pop(0)
        l.append(x)

results = []
for b,a in enumerate(l):
    if b != 0:
        print(" ") 
    a.sort()
    for b in combinations(a, 6):
        print(*list(b))
