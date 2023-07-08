# 09:58 ~ 10:28
#
# 입력값 : 200
# 
# 풀이 : 완탐 문자열
#
# 1. 가장 안에서 부터 제거해야한다
# 2. iterate를 통해 배열에다 가로를 마킹하는것은 어떨까..?
# -> 모든 조합을 구한다면 백트래킹을 활용해야하나?
# 
# 모든 () 의 세트를 구하고, 조합을 구하는데, 이때 삭제할때 맨 뒤부터 삭제한다 (index out of bounds)
#
# <반례>
#
# 1+2+3*(3-2)+2+2 -> 1+2+3*3-2+2+2 


from itertools import combinations

n = list(input())

# 모든 갈호의 위치를 세트지어 관리한다
track = []
stack = []
for a in range(len(n)):
    if n[a] == '(':
        stack.append(a)
    elif n[a] == ')':
        x = stack.pop()
        track.append([x,a])
print(track)

combis = []
for a in range(1, len(track)+1):
    for b in combinations(track, a):
        tmp = []
        for c in b:
            for d in c:
                tmp.append(d)
        combis.append(tmp)
        
results = []
for a in combis:
    tmp = n[:]
    a.sort(reverse = True)
    
    for b in a:
        tmp.pop(b)
        
    # 반례 : ((((9)))) -> 중복값
    if tmp not in results:
        results.append(tmp)

results.sort()

for a in results:
    print("".join(a))

