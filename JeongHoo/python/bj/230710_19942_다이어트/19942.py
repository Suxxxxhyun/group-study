# 09:18 ~ 09:53 + 10:38 ~ 
#
# 입출력 3~15가 주어지며 최소를 구하는것이기 때문에 백트래킹을 사용해보고 싶다
#
#
# 모든 방문처리, 중복값 X
#
#

# n = int(input())
# min_required = list(map(int, input().split()))
# graph = []
# for _ in range(n):
#     graph.append(list(map(int, input().split())))

# visited = [False]*n
# results = []
# tmp = [0]*5
# current_cost = []
# chosen = []
# already_over = [False]*4

# # 백 트키링을 할때, 옆으로 바꾸지 말고, nested array를 고르는 식으로 하자
# def combinations(start, visited, count, already_over):
#     # if sum of all current protein is higher -> add to results    
#     if count == 4:
#         results.append([sum(current_cost), chosen[:]])
#         return
    
#     for a in range(start, n):
#         if visited[a] != True:
#             current_cost.append(graph[a][4])
#             visited[a] = True 
#             chosen.append(a+1)
            
#             changed = False
#             how_many = 0
#             for b in range(4):
#                 tmp[b] += graph[a][b]
#                 # print(tmp[b])
#                 if tmp[b] >= min_required[b] and already_over == False:
#                     how_many += 1
#                     already_over = True
#                     changed = True
#             combinations(start+1, visited, count+how_many, already_over)
            
#             if changed:
#                 already_over = False
            
#             visited[a] = False
#             for b in range(4):
#                 tmp[b] -= graph[a][b]
#             current_cost.pop()
#             chosen.pop()


# combinations(0, visited, 0, already_over)
# results.sort(key=lambda x:x[0])
# print(results[0][0])
# print(*results[0][1])



###########################################


n = int(input())
min_required = list(map(int, input().split()))
graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

visited = [False]*n
results = []
tmp = [0]*5
current_cost = []
chosen = []
current_min = 1e8
current_index = []

# 백 트키링을 할때, 옆으로 바꾸지 말고, nested array를 고르는 식으로 하자
def combinations(start, visited):
    count = 0
    global current_min
    global current_index
    
    ##### 이쪽을 수정해야함 .. -> count를 parameter 로 넒기기
    
    if tmp[0] >= min_required[0] and tmp[1] >= min_required[1] and tmp[2] >= min_required[2] and tmp[3] >= min_required[3]:
        if sum(current_cost) < current_min:
            current_min = sum(current_cost)
            current_index = chosen[:]
        return
    
    # 여기 안에 넣으면 되나??
    for a in range(start, n):
        if visited[a] != True:
            for b in range(4):
                tmp[b] += graph[a][b]
            current_cost.append(graph[a][4])
            chosen.append(a+1)
            visited[a] = True    
            combinations(start+1, visited)
            visited[a] = False
            for b in range(4):
                tmp[b] -= graph[a][b]
            current_cost.pop()
            chosen.pop()
    
combinations(0, visited)

print(current_min)
print(*current_index)