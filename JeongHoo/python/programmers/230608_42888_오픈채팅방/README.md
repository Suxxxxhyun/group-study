
## 오픈채팅방 lv2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/42888

### 알고리즘 사용 : 해쉬맵, 문자열
- 전형적인 다익스트라 + 힙 문제

### 단계
- 우선 주어진 문자열을 split활용해서 나눈다
- split값에 따라 해쉬맵을 사용해 출력문자를 한다
- 이름은 마지막 이름으로 초기화 (uid 이용해서)

### 코드리뷰
```py
# 이름 스플릿
for a in record:
    x = list(a.split(" "))
    changed.append(x)

# 마지막 이름으로 초기화
for a in range(len(changed)):
    if changed[a][0] != 'Leave':
        dic[changed[a][1]] = changed[a][2]
```
