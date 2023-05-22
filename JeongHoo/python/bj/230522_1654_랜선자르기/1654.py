# 처음에 이 문제를 풀때는 완탐을 사용했다 -> 왜 이분탐색인지 잘 이해가..
# 전채를 본느거는 맞지마, 이분탐색을 이용해 서치를 줄여나간다.

n,k = map(int, input().split())

l = []
for _ in range(n):
    l.append(int(input()))
  
# 802,743,457,539
start = 1
end = max(l) # 802

# current_max = 0
while start <= end:
    middle = (start+end)//2 # 402
    count = 0 
    for a in range(len(l)):
        count += l[a]//middle
        # count += cut
        
    if count >= k:
        start = middle + 1
    elif count < k:
        end = middle - 1

print(end)

  
  
############## Brute Forced ##############
    
# start = max(l)
# count = 0

# while count <= k:
#     count = 0
#     for a in range(len(l)):
#         current = (l[a]//start)
#         count += current
#     if  count == k:
#         break
#     start -= 1


# print(start)
# ############## Brute Forced ##############
