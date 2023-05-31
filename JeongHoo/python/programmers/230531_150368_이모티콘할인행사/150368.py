from itertools import combinations_with_replacement

def solution(users, emoticons):

    # all combinations sale for the emotions

    sale = [40, 30, 20, 10]
    tmp = []
    options = []
    def combinations(start):
        if start == len(emoticons):
            options.append(tmp[:])
            return
        
        for a in range(len(sale)):
            tmp.append(sale[a])
            combinations(start+1)
            tmp.pop()
    
    combinations(0)

        
    # for combinations -> for users - > calculate
    results = []
    for a in range(len(options)):
        numbers = 0
        amount = 0
        for b in range(len(users)):
            count = 0
            for c in range(len(options[a])):
                if count < users[b][1] and options[a][c] >= users[b][0]:
                    count += ((100-options[a][c])/100)*emoticons[c]
            if count >= users[b][1]:
                numbers += 1
            else:
                amount += count
        results.append([numbers, amount])
    
    # sort list by biggest.
    results.sort(key = lambda x:(x[0],x[1]), reverse = True)
    
    return results[0]
                
        
            
    
    
    