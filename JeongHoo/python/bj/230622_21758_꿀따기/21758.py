# 14:30 ~ 14:53 + 15:03 ~
# https://www.acmicpc.net/problem/21758
# 
# 입력 : 100,000
# 
# 1번 벌은 무조건 맨 앞에
# 2번 벌은 적당한 곳에..
# 

n = int(input())
l = list(map(int, input().split()))

current_max = 0

# Sum DP
s = [l[0]]*len(l)
for a in range(1,len(l)):
    s[a] = l[a] + s[a-1] # [9,18,22,23,27,36,45]
# print(s)

# 1) 벌벌꿀
total = s[-1] # total sum of list

for a in range(1, len(l)-1):
    first = s[-1]-l[0] -l[a]
    second = s[-1] - s[a]
    current_max = max(current_max, first+second)
    print(current_max)
    

# 2) 꿀벌벌
for a in range(len(l)-1, 0, -1):
    first = total - l[-1] - l[a]
    second = s[a-1]
    current_max = max(current_max, first+second)
    
# 3) 벌꿀벌
for a in range(1,len(l)-1):
    first = s[a]-l[0]
    second = s[-1]-s[a-1]-l[-1]
    current_max = max(current_max, first+second)

print(current_max)


########## 실패 #############
#
# current_max = 0
# for a in range(len(l)):
#     target = a
#     if a == len(l)-1:
#         for b in range(1, a):
#             sum_1 = sum(l[1:]) - l[b]
#             sum_2 = sum(l[b+1:])
#             current_max = max(current_max, sum_1+sum_2) 
    
#     # if a -> within two of the left wall
#     elif a < 2:
#         for b in range(len(l)-1, a-1, -1):
#             sum_1 = sum(l[a+1:]) - l[b]
#             sum_2 = sum(l[b:len(l)-1])
#             current_max = max(current_max, sum_1+sum_2)    

        
#     # if a -> within two of the right wall
#     elif a > len(l)-3:
#         for b in range(1, len(l)-1):
#             sum_1 = sum(l[1:a+1]) - l[b]
#             sum_2 = sum(l[b+1:a+1])
#             current_max = max(current_max, sum_1+sum_2)
    
#     # else 0+2 <= a <= len-2
#     else:
#         pass
             
    
    
    
    
    


