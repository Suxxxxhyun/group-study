
## 개똥벌래 골5 bj
https://www.acmicpc.net/problem/3020

### 알고리즘 사용 : 누적합
- 누적합을 통해 풀었는데 시간초과가 + 메모리 초과
- 내가 푼 누적합은 O(500,000*200,000) 까지 가서 그랬다

### 단계
- %2 여부에 따라 위, 아래 선정
- 위 아래 각각 누적 합치기 (뒤부터)
- 최소 비교

### 코드리뷰
```py
for a in range(h-1, 0, -1):
    graph[a] += graph[a+1]
    graph_bottom[a] += graph_bottom[a+1]          
```
