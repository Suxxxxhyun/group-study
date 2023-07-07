
## 퀴드압축후개수세기 lv2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/6893668936

### 알고리즘 사용 : 재귀함수
- 딱 패턴을 봐도 재귀함수 처럼 생겼다
- 구현은 쉬웠지만 spli부분에서 은근 햇갈렸다
    - 결국 bruteforce

### 단계
- 생략

### 코드리뷰
```py
        new_graph_1 = []
        new_graph_2 = []
        new_graph_3 = []
        new_graph_4 = []
        x = len(arr)//2
        for a in range(x): 
            l = []
            for b in range(x):
                l.append(arr[a][b])    
            new_graph_1.append(l)
        for a in range(x): 
            l = []
            for b in range(x, len(arr)):
                l.append(arr[a][b])    
            new_graph_2.append(l)
        for a in range(x, len(arr)):
            l = []
            for b in range(x):
                l.append(arr[a][b])    
            new_graph_3.append(l)
        for a in range(x, len(arr)):
            l = []
            for b in range(x, len(arr)):
                l.append(arr[a][b])    
            new_graph_4.append(l)
               
```
