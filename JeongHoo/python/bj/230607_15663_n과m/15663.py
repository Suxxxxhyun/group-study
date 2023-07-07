# 09:28 ~ 09:42 + 10:28 ~ 10:41
#
# 알고리즘 : 백트래킹

n,m = map(int, input().split())
l = list(map(int, input().split()))
l.sort()
visited = [False]*n
tmp = []

def combinations(start):
    # 처음에 if not in results ..
    if start == m:
        print(*tmp)
        return
    current = 0
    for a in range(len(l)):
        if visited[a] == False:
            visited[a] = True
            tmp.append(l[a])
            current = l[a]
            combinations(start+1)
            tmp.pop()
            visited[a] = False


combinations(0)


