def solution(n, words):
    # 모든 단어들을 저장할 배열
    word_bank = [words[0]]
    
    # 몇번째 턴인지 확인하는 count
    count = 1
    current_person = 2
    
    # 현재 마지막 단어 
    tmp = list(words[0])
    current = tmp[-1]
    
    # iterate
    for a in range(1, len(words)):
        if words[a] not in word_bank:
            # print(word_bank)
            word_bank.append(words[a])
            
            if words[a][0] == current:
                if a == len(words)-1:
                    return [0,0]
                
                current = words[a][-1]
                current_person += 1
                
                # iterate 속에 n의 수마다 count 업데이트
                if current_person > n:
                    current_person = 1
                    count += 1
            else:
                break
        else:
            break
            
    return [current_person, count]
        
    
    
    
    
    
    
    
    
    
    