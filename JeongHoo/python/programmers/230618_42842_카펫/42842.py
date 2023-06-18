# 15분 팔이
# 입력값 : 2,000,000 (?)
#
# 생각하는 알고리즘 : DP / 완탐 -> 사실 DP는 입출력 너무 큼
#
# <풀이법>
# 1. 노란거를 나눌 수 있는 방법들을 구하자 -> % == 0 이면 가능..?
# 2. 이에 맞는 테두리를 구하자 (4 + 가로*2 + 세로*2)

# 24
# 1,2,3,4,5,6,7,8,9,10 .. 
# 1-24, 2-12, 3-8, 4-6

def solution(brown, yellow):
    tmp = []
    for a in range(1, yellow+1):
        # 노란이 이룰 수 있는 모든 조합을 구해보자 (만약 a로 나눈 값이 맞다면 가능)
        if yellow % a == 0:
            tmp.append([(yellow)//a, a])

    for a in tmp:
        # 모든 노란의 조합에 꼭짓점들, 가로&세로를 더해서 맞다면 return
        count = 4
        count += a[0]*2
        count += a[1]*2   
        
        if count == brown:
            return [a[0]+2, a[1]+2]
        
        