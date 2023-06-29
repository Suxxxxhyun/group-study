# 14:04 ~ 14:28
#
# 입출력 : 1000 배열 -> for x for
#
# 스택 / 큐로 풀어야 할꺼 같다 + 정렬

def solution(book_time):
    timeslots = []
    for a in book_time:
        x,y = a[0].split(":")
        start = x+y
        x,y = a[1].split(":")
        end = x+y
        i = list(end)
        if int(i[2])+1 >= 6:
                i[1] = str(int(i[1])+1)
                i[2] = "0"
        else:
            i[2] = str(int(i[2])+1)
        end = ("").join(i)
        timeslots.append([start,end])
    timeslots.sort(key=lambda x:(x[0],x[1]))
    
    stack = []
    for a in timeslots:
        if len(stack) == 0:
            stack.append(a[1])
        else:
            for b in range(len(stack)):
                if int(a[0]) >= int(stack[b]):
                    stack[b] = a[1]
                    break
                elif b == len(stack)-1 and int(a[0]) < int(stack[b]):
                    stack.append(a[1])

    return len(stack)
                
                
                
                
                
                
                
                
                
    
    
    
    
    
    