

# 시간초과 알아보기...
# DFS 입력값 -> 몇천대 올라가면 ..


# 09:48 ~ 10:14
#
# 최대 깊이를 구하는 DFS(?)
# -> 추선 Coupon는 처음부터 방문처리
# -> 입력값이 30000 이기때문에 가능할듯
#
#
# DFS : 30,000 * 3000 -> 90,000 -> 시간초과..
# 그냥 배열 iterate.. 완탐
#
# 1) recursion limit 연습 return 제귀 연습
#

# import sys
# sys.setrecursionlimit(100000)

# # 전체 초밥수, 가짓수, 연속 수, 추가로 얻어먹는
# n,d,k,c = map(int, input().split())

# l = []
# for _ in range(n):
#     l.append(int(input()))
    
# #####################################################

# 초밥 종류 (가짓수)
def dfs(sushi_list, start, sushi_count, depth):
    # 깊이가 최대 길이를 찍으면 return
    if depth == k:
        return sushi_count
    # 이미 먹었다면 종류 추가하지 않는다
    if visited[sushi_list[start]]:
        pass
    else:
        # 먹어 보지 않았다면 방문처리 + 카운트
        visited[sushi_list[start]] = True
        sushi_count += 1
        
    # 마지막 초밥에서 +1 을 하면 0에서 다음꺼 시작
    if start+1 < len(sushi_list):
        return dfs(sushi_list, start+1, sushi_count, depth+1)
    else:
        return dfs(sushi_list, 0, sushi_count, depth+1)
    
results = []
# 모든 시작지점을 iterate
for a in range(len(l)):
    # 방문 초기화 (가짓수만큼)
    visited = [False]*(d+1)
    # 쿠폰은 항상 방문처리
    visited[c] = True
    # count는 항상 1에서 시작
    x = dfs(l, a, 1, 0)
    results.append(x)

print(max(results))


######################################

n,d,k,c = map(int, input().split())

l = []
for _ in range(n):
    l.append(int(input()))
    
results = []

for a in range(len(l)):
    visited = [False]*(d+1)
    # 쿠폰은 항상 방문처리
    visited[c] = True
    count = 1
    for b in range(a,a+k):
        if b >= len(l):
            b = b-len(l)
            if visited[l[b]] == True:
                pass
            else:
                visited[l[b]] = True
                count += 1
        else:
            if visited[l[b]] == True:
                pass
            else:
                visited[l[b]] = True
                count += 1
    results.append(count)
    
print(max(results))
