# # 09:17 ~ 09:42
# #
# # 입출력 : 3x3 이기때문에 신경 크게는 안써도 될듯 하다
# #
# # 알고리즘 : 틱택토의 규칙을 찾는것이 중요할꺼 같다
# #
# # 1) 시작은 항상 O 여야 한다 -> X+1 >= O >= X    여야한다  
# #    -> O,X count진행
# #     
# # 2) 한명 이상이 승리를 하면 안된다
# #    -> 3개짜리 줄은 오직 한가지
# #
# # 3) O가 이겼으면 -> o 는 x 보다 하나 많아야하고
# #    x가 이겼으면 -> X 는 O 
# #

def solution(board):
    graph = []
    for a in board:
        graph.append(list(a))
    
    x_total_count = 0
    o_total_count = 0
    
    for a in graph:
        for b in a:
            if b == 'X':
                x_total_count += 1
            elif b == 'O':
                o_total_count += 1
    
    if x_total_count > o_total_count or o_total_count > x_total_count + 1:
        return 0
    
    winner_x = False
    winner_o = False
    
    win_count = 0
    for a in range(3):
        x_count = 0
        o_count = 0
        for b in range(3):
            if graph[a][b] == 'X':
                x_count += 1
            elif graph[a][b] == 'O':
                o_count += 1
        if x_count == 3:
            winner_x = True
            win_count += 1
        if o_count == 3:
            winner_o = True
            win_count += 1
            

    for a in range(3):
        x_count = 0
        o_count = 0
        for b in range(3):
            if graph[b][a] == 'X':
                x_count += 1
            elif graph[b][a] == 'O':
                o_count += 1
        if x_count == 3:
            win_count += 1
            winner_x = True
        if o_count == 3:
            win_count += 1
            winner_o = True
    
    # 대각선
    if graph[0][0] == 'X' and graph[0][0] == graph[1][1] and graph[0][0] == graph[2][2]:
        win_count += 1
        winner_x = True
    if graph[1][1] == 'X' and graph[2][0] == graph[1][1] and graph[1][1] == graph[0][2]:
        win_count += 1
        winner_x = True
    if graph[0][0] == 'O' and graph[0][0] == graph[1][1] and graph[0][0] == graph[2][2]:
        win_count += 1
        winner_o = True
    if graph[1][1] == 'O' and graph[2][0] == graph[1][1] and graph[1][1] == graph[0][2]:
        win_count += 1
        winner_o = True
    
    if win_count > 1:
        return 0
    
    if win_count == 1 and x_total_count != o_total_count and winner_x:
        return 0
    elif win_count == 1 and x_total_count != (o_total_count-1) and winner_o:
        return 0
    
    if x_total_count+o_total_count==9 and x_total_count != 4:
        return 0
    return 1
    
    
    
    
    
    
    
    
    