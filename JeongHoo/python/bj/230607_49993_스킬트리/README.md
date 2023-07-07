
## 스킬트리 lv2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/49993#

### 알고리즘 사용 : 완탐
- 입력값이 낮아서 완탐으로 풀어도 괜찮겠다고 생각했다
- 슾핏을 한 후에 왼쪽, 오른쪽을 반례를 통해 비교하는 풀이를 진행했다
- 풀고 나서 더 좋은 풀이도 떠올랐다 -> 최적의 풀이는 아니라고 생각한다

### 단계
- 생략

### 코드리뷰
```py
        for b in range(len(order)):
            # 만약 왼쪽에 있다면 break
            if order[b] in left_skill_tree:
                break
                
            # 만약 새로운 왼쪽에 없었고 마지막이라면 count += 1
            if b == len(order)-1:
                count += 1
                break
            
            if order[b] in current_skill_tree:
                split = skill_trees[a].split(order[b])
                left_skill_tree = list(split[0])
                current_skill_tree = list(split[1])
                
            # 만약 마지막이 아니었는데 현재 list에도 없다.. 
            else:
                # 이 라인이 굉장히 중요!!!
                # 지금 split된 값에 없었어도 계속 진행하는 조건 = 양쪽에 없다
                if order[b+1] not in left_skill_tree and order[b+1] not in current_skill_tree:
                    continue
                else:
                    break
               
```
