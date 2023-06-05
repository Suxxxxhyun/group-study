from itertools import permutations
            
def solution(k, dungeons):
    # 모든 조합을 구하는 브루트 포스
    current_max = 0
    for a in permutations(dungeons):
        current_health = k
        count = 0
        
        for b in range(len(a)):
            if a[b][0] <= current_health:
                current_health -= a[b][1]
                count += 1
        
        current_max = max(current_max, count)

    return current_max
    

# def combinations():
#     global current_max
#     global tmp
#     global health
    
#     current_max = max(current_max, tmp)
    
#     for a in range(len(dungeons)):
#         if dungeons[a][0] <= health and visited[a] == False:
#             tmp += 1
#             health -= dungeons[a][1]-dungeons[a][0]
#             visited[a] = True
#             combinations()
#             visited[a] = False
#             health += dungeons[a][1]-dungeons[a][0]
#             tmp -= 1
    
