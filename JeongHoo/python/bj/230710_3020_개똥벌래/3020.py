# 10:08 ~ 10:37
#
# 풀이 : 그래프로 구현을 완료하고 -> 모든 경우를 탐색하면 된다..? (500,000) + 200,000*500,000
#
#
# 풀이 1 : 실제 graph 구현하는거          -> 메모리 초과
#
# 풀이 2 : 실제 graph를 구현하지 말고 h에다 전부 기록      -> 시긴 초과
#         쌓아올리는 느낌의 풀이기 때문에 ... worst case 1,000,000,000 + 500,000
#
# 풀이 3 : 추가하는것을 한번에(iterat) 하지 말고 누적합
#
# https://www.acmicpc.net/problem/3020
#################################################################################################################################

n,h = map(int, input().split())

# 그래프를 만든다
graph = [0]*(h+1)
graph_bottom = [0]*(h+1)   

# 석순, 종유석을 기입한다
for a in range(n):
    tmp = int(input())
    if a % 2 == 0:
        graph_bottom[tmp] += 1
    elif a % 2 == 1:
        graph[tmp] += 1

# 누적 한번에 더하기
for a in range(h-1, 0,-1):
    graph[a]+= graph[a+1]
    graph_bottom[a] += graph_bottom[a+1]  


#모든 높이를 지나가보고 기록한다

current_min = 1e8
consecutive = 0
for a in range(1,h+1):
    total_collide = graph[a]+graph_bottom[h-a+1]

    if total_collide < current_min:
        current_min = total_collide
        consecutive = 1

    elif total_collide == current_min:
        consecutive += 1

print(current_min, consecutive)


#################################################################################################################################


# n,h = map(int, input().split())

# # 그래프를 만든다
# graph = [[0]*(n) for _ in range(h)]

# # 석순, 종유석을 기입한다
# for a in range(n):
#     tmp = int(input())
#     if a % 2 == 0:
#         for b in range(tmp):
#             graph[h-b-1][a] = 1
#     elif a % 2 == 1:
#         for b in range(tmp):
#             graph[b][a] = 1

# # 모든 높이를 지나가보고 기록한다

# current_min = 1e8
# consecutive = 0
# for a in range(h):
#     count = 0
#     for b in range(n):
#         if graph[a][b] == 1:
#             count += 1
        
#     if count < current_min:
#         current_min = count
#         consecutive = 1
#     elif count == current_min:
#         consecutive += 1

# print(current_min, consecutive)