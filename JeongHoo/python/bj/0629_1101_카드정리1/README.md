
## 카드정리1 골4 bj
https://www.acmicpc.net/problem/1101

### 알고리즘 사용 : 그리디 + 브루트 포스
- 입출력을 보고 백트레킹인가를 생각해 봤다.
    - 너무 크다 -> 차라리 완탐
- 문제를 잘못 이해했다.. 주어진 인풋이 상자의 구성인줄 알았다
- 문제를 푸는데 핵심은 같은게 아닌것이 나타나자 말자 바로 joker로 설정
- 전부 동일한 상자는 방문처리를 하고 한번 더 나타나면 이또한 무조건 joker로 옮긴다
-> 이것이 최소 횟수

### 단계
- 각 방스 숫자 개수만큼 graph에 추가
- 박스에 처음있는 값을 current -> 다른게 나타나면 바로 joker
- 첫 다른 값 / 중복 방문값을 joker로 설정
- joker가 설정 되어있음 바로 count += 1

### 코드리뷰
```py
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
               
```