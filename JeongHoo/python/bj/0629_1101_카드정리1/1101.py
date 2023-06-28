# 10:13 ~ 10:55
# n,m -> 50 -> 백트래킹인가..?
#               -> 50*50 -> 2500이 되므로 Timeout;
# 완탐..?
# - 어제 램프랑 비슷한 풀이일수 도 있을꺼 같다.
# - 일단 만약 다른게 있으면 그것은 옮겨야한다.
#   -> 어차피 한번에 여러개를 옮길 수 있다면 그냥 혼자있는것이 아니라면 모든것을 무조건 조커박스에 넣으면..?
#
# 문제 잘못 이해 -> 보이는것이 실제 벅스듣 뜻하는줄..
# 실제 풀이 -> 박스 들어있는 값의 개수를 뜻함.. 
#
# 예제 4)
# 1 2 -> joker 설정
# 1 2 -> move to joker
# 1 2 -> move to joker
# 1   
# 1   -> move to joker (전꺼에 이미 있었으니)
# 2
#
# => moves = 3


# 각 박스당 숫자가 들어있는 개수를 그만큼 박스 안에 넣는다
n,m = map(int, input().split())
graph = []
for a in range(n):
    l = list(map(int, input().split()))
    tmp = []
    for b in range(len(l)):
        for _ in range(l[b]):
            tmp.append(b+1)
    graph.append(tmp)
    
count = 0

# 조커 설정을 무조건 처음 만난 박스로 한다는것에서 greedy 라고 생각
# 조커를 한번 무조건 쓴다 (전부 다 동일 숫자가 들어있는 박스가 아닌 이상 (이미 존재한 동일 숫자 박스면 그것도 그냥 조커로 설정))-> 조커를 사용했는지를 표시
joker_activated = False

# n만 들어있는 박스를 표기 -> 이미 존재한다면 그것 또한 옮겨야한다
visited_colors = [False]*51

# 전테 칸들 iterate
for a in range(len(graph)):
    current = 0
    for b in range(len(graph[a])):
        
        # 만약 같은 box에서 current아닌 다른 숫자가 한번이라도 나왔다.. 혹은 하나만 들어있더라도 그 숫자만 존재하는 box가 이미 있었다!
        if current != 0 and graph[a][b] != current or visited_colors[graph[a][b]] == True:
            # joker 설정 이후 이제부터는 무저건 +1
            if joker_activated:
                count += 1
            # 첫번째는 무조건 봐주고 그거를 joker로 만든다
            else:
                joker_activated = True
            break
        # 최초로 0이 아닌 박스를 현재로 표기 (즉 -> current에서 하나라도 다른게 있는 순간 -> joker box)
        elif graph[a][b] != 0:
            current = graph[a][b]
            
        # 맨끝까지 와서, 하나의 색상만 있는것은 알지만 .. current의 색상 묶음 박스가 이미 존재 했을때
        if b == len(graph[a])-1 and current != 0:
            visited_colors[graph[a][b]] = True
               
print(count)