n = int(input())
k = int(input())

l = []

for a in range(n):
    l.append(input())
    
tmp = []
results = []
visited = [False for _ in range(n)]
def combinations(start):
    if start == k:
        j = ""
        for a in range(len(tmp)):
            j += tmp[a]
        if j not in results:
            results.append(j)
        return
    
    for a in range(n):
        if visited[a] == False:
            tmp.append(l[a])
            visited[a] = True
            combinations(start+1)
            tmp.pop()
            visited[a] = False

combinations(0)

print(len(results))