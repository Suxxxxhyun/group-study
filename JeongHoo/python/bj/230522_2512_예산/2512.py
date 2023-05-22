n = int(input())
l = list(map(int, input().split()))
target = int(input())

start = 1
end = max(l) # 150

while start <= end:
    middle = (start+end)//2
    count = 0
    for a in range(len(l)):
        if l[a] < middle:
            count += l[a]
        else:
            count += middle
    if count > target:
        end = middle - 1
    if count <= target:
        start = middle + 1
        
print(end)
    