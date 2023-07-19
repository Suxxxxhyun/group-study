# 09:40 ~ 10:00
#
#
# 반례)
# 한 단어에 같은 글자가 두번있다면..?
# hott doto
#

from collections import deque


def bfs(current, target, words, visited):
    
    q = deque()
    q.append((current, 0))
    
    while q:
        word, steps = q.popleft()
        if word == target:
            return steps
        
        word_l = list(word)
        
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

    return 0

def solution(begin, target, words):
    visited = [False]*len(words)
    
    return(bfs(begin, target, words, visited))


