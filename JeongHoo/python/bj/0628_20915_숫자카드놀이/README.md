
## 숫자카드놀이 실1 bj
https://www.acmicpc.net/problem/20915

### 알고리즘 사용 : 그리디 + 정렬
- 문제 핵심은 곱하기의 최대값이 되기 위해서는 두개간 최대한 차이를 적개 하는것이다
- 힙으로 돌아가면서 추가를했다..
    - 이 방법보다는 그냥 하나씩 돌아가면서 더 작아진 숫자에 추가를 하는게 더 좋다
    - 0 은 상관 없기 떄문에 마지막에 곱하고 추가를 하자

### 단계
- str 을 int로 변화
- 최대값 지속적으로 힙을 통해 제거
- 더 작은 값에 추가

### 코드리뷰
```    
stack_1 = ""
    stack_2 = ""
    
    if len(q) != 0:
        stack_1 += str(-heapq.heappop(q))
    if len(q) != 0:
        stack_2 += str(-heapq.heappop(q))
    
    current_is_2 = True
    while len(q) != 0:
        i = -heapq.heappop(q)
        if int(stack_1) > int(stack_2):
            stack_2 += str(i)
        else:
            stack_1 += str(i)
    
    stack_2 += "0"*zero_count
```