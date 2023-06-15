## 괄호 회전하기 lvl2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/76502/solution_groups?language=python3

### 알고리즘 사용 : 큐 + 완전탐색

- 비슷 한 문제를 푼적 있는거 같다 (Leet code)
- 크게 두개 로 나뉜다 (큐를 활용해 계속해서 리스트를 돌리기 + 돌린 리스트가 올바른 괄호인지 판단하기)
- 이제 큐는 편안하게 사용하느고 떠올리는거 같다


### 단계
1. queue.pop -> append to end
2. check if queue is a 올바른 괄호 (pop if closing is same as last appended opening)


### 복습
```
new_list = queue(l)

for a in range(len(new)s):
    tmp = new_list.popleft()
    new_s.append(tmp)

    # 1,2,3,4
    # 2,3,4,1
    # 3,4,1,2
    # 4,1,2,3

```
