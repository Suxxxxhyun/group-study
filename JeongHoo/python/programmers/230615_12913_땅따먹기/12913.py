
def solution(land):
    # 100,000
    # 그리디 o, 콤비x, dfs o, dp o
    
    #DP 풀이#
    dp = [[] for _ in range(len(land))]
    
    # dp 매번 max 구하기 전꺼를 자기 
    for a in range(1, len(land)):
        for b in range(4):
            x = 0
            y = 0
            if len(land[a-1][:b]) != 0:
                x = max(land[a-1][:b])
            if len(land[a-1][b+1:]):
                y = max(land[a-1][b+1:])
                
            land[a][b] = land[a][b] + max(x,y)
    

    return max(land[-1])

