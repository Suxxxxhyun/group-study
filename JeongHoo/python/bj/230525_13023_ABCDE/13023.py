# 문제 설명이 좀 많이 부족하다
# 풀이 -> DFS를 이용해 깊이가 4 이상인 노드가 있는지 탐색하는것이다
# DFS + 트리


n,m = map(int, input().split())
l = []
for _ in range(m):
    l.append(list(map(int,input().split())))
tree = [[] for _ in range(n)]

for a in range(m):
    tree[l[a][0]].append(l[a][1])
    tree[l[a][1]].append(l[a][0])
    
    
answer = False
visited = [False for _ in range(n)]
def dfs(vertex, count):
    global answer
    if count == 4:
        answer = True
        return 
    
    for a in range(len(tree[vertex])):
        if visited[tree[vertex][a]] != True:
            visited[vertex] = True
            dfs(tree[vertex][a], count+1)
            visited[vertex] = False
    
for a in range(n):
    dfs(a, 0)
    if answer:
        break

if answer:
    print(1)
else:
    print(0)

