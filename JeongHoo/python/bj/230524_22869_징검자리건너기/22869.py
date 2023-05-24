# start from 1 -> if you can go -> 
# append to queue -> if queue reaches end

# 본래 DP로 풀려고 했던 문제이지만 풀리지 않아 큐를 사용한 BFS로 풀었다.
# visited의 중요성을 알게 되었다
# 계속 시간초과가 나와서 결국 DP 문제라고 결론 내렸지만
# visited를 추가하니 시간초과가 나지 안았다..

# https://www.acmicpc.net/status?user_id=9907daniel&problem_id=22869&from_mine=1


from collections import deque
import sys
n, k = map(int, input().split())
l = list(map(int, input().split()))
visited = [False for _ in range(n)]

q = deque()
q.append(0)

while q:
    a = q.popleft()
    if a == n-1:
        print("YES")
        sys.exit()
    
    for b in range(a+1,n):
        if (b-a)*(1+abs(l[a]-l[b])) <= k and visited[b] == False:
            visited[b] = True
            q.append(b)
print("NO")
