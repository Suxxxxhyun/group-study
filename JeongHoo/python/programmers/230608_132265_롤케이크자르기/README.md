
## 링크와스타트 실1 bj
https://school.programmers.co.kr/learn/courses/30/lessons/132265?language=python3

### 알고리즘 사용 : 그리디 + 해쉬맵
- 3번정도 실패한 문제인데 드디어 풀었다
- 또한번 자료구조의 중요성을 느꼈다

### 단계
1. 형이라는 해쉬맵에 케이크를 전부 기록
1-1. 키가 추가해질때 마다 종류 추가
2. 동생이라는 해쉬맵이 iterate 하면서 케이크를 하나씩 제거
2-1. 키가 추가해질때마다 종류 추가
2-2. 형이 0 이 되면 종류 하나 제거
3. type_1 == type_2 하면 count + 1

### 코드리뷰
```py
for a in range(len(topping)):
    if topping[a] not in dic_b:
        dic_b[topping[a]] = 1
        # 타임 추가
        type_b += 1
    else:
        dic_b[topping[a]] += 1
        
    dic_a[topping[a]] -= 1
    if dic_a[topping[a]] <= 0:
        # 0이 된다면 타입 제거
        type -=1
    if type == type_b:
        count += 1
               
```
