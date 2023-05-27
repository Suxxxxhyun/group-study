## 요격시스템 lvl2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/181188

### 알고리즘 사용 : 그리디 + 정렬

그리디는 보통 풀이를 for-loop 하나로 끝내야한다는 생각이 강하기 떄문에
늘 풀이를 떠올릴때 힘들다고 생각했다 -> 복습하기 좋은 문제였다
일단 정렬의 중요함을 또 느낄 수 있는 문제이기도 했다.


### 단계
1. sort list
2. if start of the next missile is further than the shortest 
end of our current missile count, we count it as another projection


### 복습
```
l = [[3,1],[2,4],[6,6],[5,4],[5.1]]

l.sort()
l.sort(key = lambda x:x[1])

```