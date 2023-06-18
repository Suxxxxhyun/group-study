## 카펫 lvl2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/42842

### 알고리즘 사용 : 완전탐색 + Math
- 완탐보다는 수학 공식을 찾는것이 중점인 문제
- 핵심은 brown이 아닌 yellow에 있다
- 처음에 굉장히 복잡하고 DP를 사용해야 하는줄 알았다
- 예전 삼각형 절반 문제와 비슷하게 도형을 보고 알고리즘으로 풀리지 않는다면 수학적으로 풀 생각을 해야하는거 같다. 


### 단계
1. 1~yellow 중 나눠서 딱 떨어지는 조합들을 구한다 (직사각형이 가능한)
2. 만약 조합들을 구했다면 꼭짓점 4개 + 가로*2 + 세로*2 가 brown이랑 맞는거를 return

### 복습
```
for a in range(1, yellow+1):
    # 노란이 이룰 수 있는 모든 조합을 구해보자 (만약 a로 나눈 값이 맞다면 가능)
    if yellow % a == 0:
        tmp.append([(yellow)//a, a])
```
