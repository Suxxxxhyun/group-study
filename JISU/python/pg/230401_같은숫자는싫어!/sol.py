def solution(arr):
    answer = []
    stack=[]

    for i,n in enumerate(arr):
        if not(stack and stack.pop()==n):
            answer.append(n)
        stack.append(n)

    return answer