## 호텔 대실 lv2 pg
https://school.programmers.co.kr/learn/courses/30/lessons/155651#

### 풀이시간 : 24분

### 알고리즘 사용 : 스택 + 정렬
- 일반적인 스택 문제이다
- split, join function을 연습하기에 편하고 시간 문자열을 연습하기에도 좋다

### 단계
- timeslot을 : 기준으로 split
- end timeslot + 10
- 스택에 추가하며 비교


### 복습
```py
# a = "10:30"

x,y = a.split(":")
# 10 30
```

```py
l = [1,2,3,4,5]

"".join(l)

12345
```

```py
if int(i[2])+1 >= 6:
        i[1] = str(int(i[1])+1)
        i[2] = "0"
else:
    i[2] = str(int(i[2])+1)

```