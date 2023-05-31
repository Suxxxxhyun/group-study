## 이모티콘 할인행사(카카오톡 키출) lv2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/150368

### 알고리즘 사용 : 백드태킹 + 정렬
- 백트래킹을 활용해서 모든 조합을 구한
- 백트래킹 응용문제로 좋은거 같다
- 정렬을 할때 두가지 인덱스 최대로 정렬을 한다


### 단계
1. 처음에 모든 할인률조합을 구한다 (중복 사용하기 떄문에 visited을 하면 안된다)
2. 조합을 기반으로 할인률 기준 모든 이모티콘 구매
3. 만약 budget 초과시 그냥 이모티콘 구독을 한다
4. 정렬을 한다



### 복습
- 이중 정렬
```
list = [[0,33],[1,20],[5,10],[1,400]]

list.sort(key = lambda x: (x[0],x[1]), reverse = True)
```
- [[5,10],[1,400],[1,20],[0,33]]

- 중복이 가능한 조합
```
def combinations(start):
    if start == target:
        append
        return

    for a in range(options):
        tmp.append(a)
        combinations(start+1)
        tmp.pop()
```