## 광물캐기 lvl2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/172927#

### 알고리즘 사용 : 구현 + 정렬
- 처음에 n,m < 50 인거를 보고 백트래킹으로 풀었다.
    - 무조건 입력 낮다고 백트래킹이라고 생각하지 말자 ..
- 광물을 5개씩 묶어서 구현으로 풀었다
    - 여기서 Test Case 8을 제외하고 전부 통과했다..
    - 단순 picks가 부족하거나 광물이 끝나면 멈추면 된다고 생각했는데
        - 생각해보니 정렬을 할때 만약 광물이 부족하다면 뒤부분의 최대치가 앞으로 올수도 있는거기 때문에 추가적으로 아예 picks을 넘는 양의 광물은 추가하면 안된다는것을 알 수 있었다
- 좋은 구현 문제인듯 함
    - 조금 아쉬운점은 마지막 테케를 찾기 위해 print()를 사용했다는거


### 단계
1. sort picks in order and save pick numbers
2. make list of 5 minerals and stop if either end / no more picks left
3. iterate over the 5-set minerals and calcualte stamina



### 복습
None