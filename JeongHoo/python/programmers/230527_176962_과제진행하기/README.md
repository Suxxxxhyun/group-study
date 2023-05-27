## 과제진행하기 lvl2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/176962#

### 알고리즘 사용 : 큐 + 정렬 (구현에 가깝게 느껴짐)

- 최적화된 풀이로 풀었는지는 전혀 모르겠다.
- 11:23 와 같이 시간을 숫자로 변환하는 방법을 까먹었는데 복습할 수 있었다
- 시간을 비교후 만약 끝내지 못한다면 미루는 q로 삽입한다
- 복잡한 구현만큼은 아니지만, 풀면서 사소한 실수들과, 벗어나는 인덱스, 범위를 생각하고 찾아야해서 좋은 연습이었다
- 코드를 풀면서 계속 주석처리로 설명을 적는 연습을 하자


### 단계
1. sort the list by starting time
2. for loop the list
3. within the for loop, we first check for the queue and if current time is before the current task

-> if it is, we finish queue until the task starts
-> if it isnt, we start the task


### 복습
```
l.sort()
l.sort(key = lambda x:x[1])
```

```
l = ["11:20", "12:40", "15:10"]

for a in range(len(l)):
    l[a] = int(l[a][:2]) + int(l[a][3:])
```

```
from collections import deque

q = deque()
q.popleft()
q.pop()

q.appendleft()
q.append()
```