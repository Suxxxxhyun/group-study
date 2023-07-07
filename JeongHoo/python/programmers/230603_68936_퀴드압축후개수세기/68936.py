# 10:15 ~ 10:54
#
#
# 우선 계속 분할을 해야 하기 때문에 재귀 함수일듯 하다 + 구현...
arr = [[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]
entire_zero = 0
entire_one = 0

def split(arr):
    count_zero = 0
    count_one = 0
    global entire_one
    global entire_zero
        
    if len(arr) == 1:
        if arr[0][0] == 1:
            entire_one += 1
        else:
            entire_zero += 1
        return
    
    # 일단 현재 정사각형의 0 / 1의 개수를 측정
    for a in range(len(arr)):
        for b in range(len(arr[0])):
            if arr[a][b] == 1:
                count_one += 1
            else:
                count_zero += 1
    
    # 만약 같다면 전체를 count=1으로 간주하고 멈춘다
    if count_one == len(arr)*len(arr):
        entire_one += 1
        return
    elif count_zero == len(arr)*len(arr):
        entire_zero += 1
        return
    else:
        # 같지 않다면 정사각형을 4개로 나누고 실행!
        new_graph_1 = []
        new_graph_2 = []
        new_graph_3 = []
        new_graph_4 = []
        x = len(arr)//2
        for a in range(x): 
            l = []
            for b in range(x):
                l.append(arr[a][b])    
            new_graph_1.append(l)
        for a in range(x): 
            l = []
            for b in range(x, len(arr)):
                l.append(arr[a][b])    
            new_graph_2.append(l)
        for a in range(x, len(arr)):
            l = []
            for b in range(x):
                l.append(arr[a][b])    
            new_graph_3.append(l)
        for a in range(x, len(arr)):
            l = []
            for b in range(x, len(arr)):
                l.append(arr[a][b])    
            new_graph_4.append(l)
        
        split(new_graph_1)
        split(new_graph_2)
        split(new_graph_3)
        split(new_graph_4)
        # split(arr[:(len(arr)//2)][:(len(arr)//2)])
        # split(arr[len(arr)//2:][len(arr)//2:])
        # split(arr[:len(arr)//2][len(arr)//2:])
        # split(arr[len(arr)//2:][:len(arr)//2])
    
def solution(arr):
    global entire_zero
    global entire_one
    split(arr)
    
    result = [entire_zero, entire_one]
    return result
    

    

    
