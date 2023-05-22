n = int(input())
l = list(map(int, input().split()))

m = int(input())
check = list(map(int, input().split()))

l.sort()

have = [0 for _ in range(m)]

for a in range(len(check)):
    current = check[a]
    
    start = 0
    end = len(l)-1
    
    while start <= end:
        middle = ((start+end)//2)

        if l[middle] == current:
            have[a] = 1
            break
        elif l[middle] < current:
            start = middle+1
        elif l[middle] > current:
            end = middle-1

print(*have)
        
    

