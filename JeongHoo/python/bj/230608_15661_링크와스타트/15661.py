#
# 09:36 ~ 09:57 + 10:38~ 11:02
# 
# 풀이)
# 1. 일단 그래프를 너무 신경쓰지 말고, 헙을 존부 구하자 
# 2. 아휴 브루투 포스 / 조헙을 통해 모든 조합을 구하자 -> 팀인원은 동일 하지 않아도 된다
#
# 힌트 확인

# 풀이 2
n = int(input())
graph = []
for _ in range(n):
    graph.append(list(map(int,input().split())))
visited = [False] * n

min_value = 1e8

def recur(target):
    # n 번만큼 iterate!!
    if target == n:
        print(visited)
        score()
        return

    # 백트래킹 모든 조합을 구해준다 
    # True = Linked Team, 
    visited[target] = True
    recur(target+1)
    visited[target] = False
    recur(target+1)
    

def score():
    global min_value
    start = 0
    link = 0

    #짝수를 구하는 for 문 
    for i in range(n-1):
        for j in range(i+1,n):
            # 둘 다 고려
            if visited[i] and visited[j] :
                start += graph[i][j] + graph[j][i]
            elif not visited[i] and not visited[j]:
                link += graph[i][j] + graph[j][i]
    
    diff = abs(start-link)

    if  min_value > diff:
        min_value = diff

recur(0)
print(min_value)


########################################

# # from itertools import combinations

# n = int(input())
# graph = []
# total_sum = 0
# for _ in range(n):
#     x = list(map(int,input().split()))
#     total_sum = sum(x)
#     graph.append(x)

# pairs = []
# for a in range(n-1):
#     for b in range(a+1, n):
#         tmp = graph[a][b] + graph[b][a]
#         pairs.append(tmp)

# current_min = 1e8

# for a in range(1, len(pairs)+1):
#     for b in combinations(pairs, a):
#         t1 = sum(b)
#         t2 = total_sum - t1
#         current_min = min(current_min, abs(t2-t1))
# print(current_min)
        
# 팀인원이 달라도 되기 떄문에 -> 모든 조합을 구해야 한다
# 중요!! -> 여기서 모든 하나만 골라도 된다 ..
# 예시 ) 2 2 2 2 2 2 100000

# current_min = 1e8
# total_sum = sum(pairs)
# for a in range(len(pairs)):
#     for b in range(a+1,len(pairs)):
#         tmp = sum(pairs[a:b])
#         tmp_2 = total_sum - tmp
        
#         print(pairs)
#         current_min = min(current_min, abs(tmp_2-tmp))
#         print(tmp, tmp_2)

# print(current_min)
