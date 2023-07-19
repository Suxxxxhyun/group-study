## 단속카메라 lv3 프로그래머스
https://school.programmers.co.kr/learn/courses/30/lessons/42884#

### 알고리즘 사용 : sort + stack
- 일반 교실 예약 문제랑 비슷하지만 min, max와 같은 추가 사항을 고려해야한다는 좀에서 더 응용이 된다.

### 단계
1. 전채 정렬
2. 첫번째 스택에 추가
3. 끝나는시간과 시작시간을 지속 비교 해주면서 min을 비교해서 update

### 복습
```py
def solution(routes):
    # 우선 크기 순대로 sort
    # [-20,-15], [-18,-13], [-14,-5], [-5,-3]
    routes.sort(key=lambda x:(x[0],x[1]))
    if len(routes) == 1:
        return 1
    
            # -15 -? 어차피 정렬이 되어있기 때문에 끝나는 숫자만 범위 안에 들어오면 된다
    stack = [routes[0][1]]
    for a in range(1, len(routes)):
        
        # -18 < -15
        if routes[a][0] <= stack[-1]:
            # update range
            stack[-1] = min(routes[a][1], stack[-1])
        else:
            stack.append(routes[a][1])
    
    return len(stack)
```

