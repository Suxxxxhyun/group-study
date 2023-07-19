## 단어변환 lv2 프로그래머스
https://school.programmers.co.kr/learn/courses/30/lessons/43163

### 알고리즘 사용 : BFS
- 그래프가 아닌 BFS 문제이다
- 알고리즘 생각 하는것이 중요하다!
- 반례가 for 문이 아닌 if in tmp 로 진행했을때 중복 단어를 고려 안해 걸렸었다

### 단계
1. 현대 단어 큐 추가
2. 현재 단어 카피
3. for문을 통해 count를 진행하고 만약 count-1이면 큐에 추가 가능하다

### 복습
```py
for a in range(len(words)):
            if visited[a] != True:
                compare_len = len(word_l)
                count = 0
                # pop할 임시 리스트 하나 만들기
                tmp = word_l[:]
                for b in list(words[a]):
                    # 한 단어에 같은 글자가 두번있다면..?
                    if b in tmp:
                        tmp.pop(tmp.index(b))
                        count += 1
                if count == compare_len-1:
                    visited[a] = True
                    q.append((words[a], steps+1))
```

