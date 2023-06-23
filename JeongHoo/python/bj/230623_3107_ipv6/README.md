## IPv6 골5 백준
https://www.acmicpc.net/problem/3107

### 알고리즘 사용 : String + Implementation

- 구현 문제이다
- 세미골런 2개에 의한 반례들을 빨리 파악하는것이 중요하다


### 단계
- iterate 하면서 :: 가 나타나면 True 표시
- 일반 : 가 나타나기 전에 문자를 count 하고 0을 채운다
- 생각해야할 반례들
    - ::
    - 4::
    - ::4
    - 4::4

### 복습
```py
results += "0"*(4-count)

x = results.split("::")
```