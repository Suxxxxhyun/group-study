N=int(input())
A=[int(e) for e in input().split()]

result=[-1]

prev_max=-1
for i in range(N-2,-1,-1):
    if A[i+1]>A[i]:
        result.append(A[i+1])
        prev_max=A[i+1]
    elif A[i+1]<=A[i]:
        if prev_max>A[i]:
            result.append(prev_max)
        else:
            result.append(-1)
            prev_max=-1

result.reverse()
result=[str(e) for e in result]
print(" ".join(result))