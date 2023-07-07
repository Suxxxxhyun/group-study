
## 회전초밥 실1 bg
https://www.acmicpc.net/problem/2531

### 알고리즘 사용 : DFS
- 사실 DFS 보다는 그냥 깊이를 확인하면서 푸는 문제이다


### 단계
- 생략

### 코드리뷰
```py
for a in range(len(l)):
    visited = [False]*(d+1)
    # 쿠폰은 항상 방문처리
    visited[c] = True
    count = 1
    for b in range(a,a+k):
        if b >= len(l):
            b = b-len(l)
            if visited[l[b]] == True:
                pass
            else:
                visited[l[b]] = True
                count += 1
        else:
            if visited[l[b]] == True:
                pass
            else:
                visited[l[b]] = True
                count += 1
    results.append(count)
```
