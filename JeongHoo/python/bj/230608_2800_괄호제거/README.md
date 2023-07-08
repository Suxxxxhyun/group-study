
## 괄호제거 골5 bj
https://www.acmicpc.net/problem

### 알고리즘 사용 : 완전탐색 + 문자열 + 스택
- 모든 세트를 구하는것어 중점을 주었다
- 15%에 반례가 걸렸다 -> 중복처리 제거
- 괄호가 보이면 보통 스택이 떠올른다

### 반례
```
(((9)))
```

### 단계
- 스택을 먼저 구현해 안에서 부터 pop을 하면서 (, ) 의 인덱스를 기록한다
- 스택이 구해진 체로 조합을 진핸해서 모든 조합을 구한다
- 중복처리는 없앤다
- sort 실행

### 코드리뷰
```py
n = list(input())

# 모든 갈호의 위치를 세트지어 관리한다
track = []
stack = []
for a in range(len(n)):
    if n[a] == '(':
        stack.append(a)
    elif n[a] == ')':
        x = stack.pop()
        track.append([x,a])
print(track)
               
```
