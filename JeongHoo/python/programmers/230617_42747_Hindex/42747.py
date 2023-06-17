def solution(citations):
    
    citations.sort()
    

    h_index = 0
    for a in range(1,len(citations)+1):
        count = 0
        for b in range(len(citations)):
            if citations[b] >= a:
                count += 1
        
        if count >= a and (len(citations)-count) < a:
            h_index = a
    
    return h_index