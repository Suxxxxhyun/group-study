## 피로도 lvl2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/87946#

### 알고리즘 사용 : 완전탐색 + permutation
- 오늘 집중령 안좋아서 쉬운 문제였지만 이상한 방향성으로 계속 문제를 풀었다
- input값이 작기 때문에 조합을 생각했지만 Backtrack으로 직접 구현 하려 했다
- 단순 permutations만 사용하면 된다


### 단계
1. permutate over dungeons
2. iterate


### 복습
```
from itertools import permutations

dungeons = [a,s,d,f,g]

for a in permuations(dungeons):

```
- permutates over all