# 09:45 ~ 11:00
#
# 입력 : n <= 16
#
# 알고리즘 : DP, BFS/DFS/백트레킹(?) -> DFS 인가..? 
#
#
# 격자가 2x2 -> 3x3 -> 4x4 이동 횟수를 구하면 된다..?
#
# 위에서 n-1,n-1은 추가 가능
# 옆에서는 n,n-1은 추가 가능
 
n = int(input())
graph = []

for _ in range(n):
    graph.append(list(map(int, input().split())))
    

# x축은, 첫번째 두개는 절대 가지 못한다
dp = [[0]*(n) for _ in range(n)]

for a in range(n):
    if graph[a][2] != 1:
        dp[a][2] = 1
    else:
        break
for a in range(n):
    if graph[0][a] != 1:
        dp[0][a] = 1
    else:
        break

for a in range(1, n):
    for b in range(2, n):
        if graph[a][b] == 1:
            dp[a][b] = 0
        else:    
            if b < 4 and a > 2:
                dp[a][b] = dp[a-1][b-1] + dp[a-1][b]
            elif a < 2 and b > 1:
                dp[a][b] = dp[a-1][b-1] + dp[a][b-1]
            # elif a > 1 and b > 1:
            #     dp[a][b] = dp[a-1][b-1] + dp[a-1][b]
            else:
                dp[a][b] = dp[a-1][b] + dp[a][b-1] - dp[a-1][b-1]
# 1 1 1 1 1
# 0 0 1 2 3
# 0 0 1 3 8
# 0 0 1 4 15
# 0 0 1 5 24

for a in dp:
    print(*a)