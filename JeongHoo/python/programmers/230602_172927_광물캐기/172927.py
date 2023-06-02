# 테스트게이스 8번만 제외하고 다 통과
# 만약 picks가 부족하다면, 뒷부분은 수정할 필요가 없다. 
def solution(picks, minerals):
    # iterate over picks
    a = 0
    q = []
    pick_count = 0
    while a < 3:
        if picks[a] == 0:
            a += 1
        else:
            if a == 0:
                q.append("d")
            elif a == 1:
                q.append("i")
            elif a == 2:
                q.append("s")
            picks[a] -= 1
            pick_count += 1
        # q = [d,i,i,i,s,s]
        
    # iterate over minerals and make a list of 5
    track = []
    count = 0
    tmp = 0
    tmp_mines = []
    for a in range(len(minerals)):
        if a == (pick_count*5):
            track.append([tmp, tmp_mines])
            break
        
        if minerals[a] == "diamond":
            tmp_mines.append("diamond")
            tmp += 25
        elif minerals[a] == "iron":
            tmp_mines.append("iron")
            tmp += 5
        elif minerals[a] == "stone":
            tmp_mines.append("stone")
            tmp += 1
        count += 1
        
    # [0][0], [0][1]
    # [[125,  ["diamond","diamond","diamond","diamond","diamond"]],[25,["iron","iron","iron","iron","iron"]]

        if count == 5 or a == len(minerals)-1:
            track.append([tmp, tmp_mines])
            count = 0
            tmp = 0
            tmp_mines = []
    
    track.sort(key= lambda x:x[0], reverse = True)
    
    # iterate over track
    count = 0
    recovery = 0
    for c in range(len(track)):
        if count == len(q):
            break
        else:
            for b in track[c][1]:
                # b = ["diamond","diamond","diamond","diamond","diamond"]
                if b == "diamond" and q[count] == 'd':            
                    recovery += 1
                elif b == "diamond" and q[count] == 'i':            
                    recovery += 5
                elif b == "diamond" and q[count] == 's':            
                    recovery += 25
                elif b == "iron" and q[count] == 'd':            
                    recovery += 1
                elif b == "iron" and q[count] == 'i':            
                    recovery += 1
                elif b == "iron" and q[count] == 's':            
                    recovery += 5
                elif b == "stone" and q[count] == 'd':            
                    recovery += 1
                elif b == "stone" and q[count] == 'i':            
                    recovery += 1
                elif b == "stone" and q[count] == 's':            
                    recovery += 1
            count += 1

    return recovery

##### 백트래킹 시간초과 ######
    
#     options = []
#     # if picks[0] > 0:
#     for a in range(picks[0]):
#         options.append('d')
#     for a in range(picks[1]):
#         options.append('i')
#     for a in range(picks[2]):
#         options.append('s')
#     # options = ['d','i','i','i','s','s']
    
#     results = []
#     tmp = []
#     visited = [False]*(len(options))
#     def combination(start):
#         if start == len(options):
#             results.append(tmp[:])
#             return
#         for a in range(len(options)):
#             if visited[a] != True:
#                 tmp.append(options[a])
#                 visited[a] = True
#                 combination(start + 1)
#                 tmp.pop()
#                 visited[a] = False
#     combination(0)
    
#     current_min = 1e8
#     for a in results:
#         count = 0
#         recovery = 0
#         i = 0
#         for b in minerals:
#             if count == 5:
#                 if i+1 == len(a):
#                     break
#                 count = 0
#                 i += 1
#             if b == "diamond" and a[i] == 'd':            
#                 recovery += 1
#             elif b == "diamond" and a[i] == 'i':            
#                 recovery += 5
#             elif b == "diamond" and a[i] == 's':            
#                 recovery += 25
#             elif b == "iron" and a[i] == 'd':            
#                 recovery += 1
#             elif b == "iron" and a[i] == 'i':            
#                 recovery += 1
#             elif b == "iron" and a[i] == 's':            
#                 recovery += 5
#             elif b == "stone" and a[i] == 'd':            
#                 recovery += 1
#             elif b == "stone" and a[i] == 'i':            
#                 recovery += 1
#             elif b == "stone" and a[i] == 's':            
#                 recovery += 1
#             count += 1
        
#         current_min = min(current_min, recovery)
#     return current_min




        # # ["i","s"]
        # count = 0
        # recovery = 0
        # i,j = 0,0
        # while i < len(a) or j < len(minerals):
        #     # 0 < 2      or 0 < 11
        #     if count == 5:
        #         count = 0
        #         i += 1
        #     if minerals[j] == "diamond" and a[i] == 'd':            
        #         recovery += 1
            # elif minerals[j] == "diamond" and a[i] == 'i':            
            #     recovery += 5
            # elif minerals[j] == "diamond" and a[i] == 's':            
            #     recovery += 25
            # elif minerals[j] == "iron" and a[i] == 'd':            
            #     recovery += 1
            # elif minerals[j] == "iron" and a[i] == 'i':            
            #     recovery += 1
            # elif minerals[j] == "iron" and a[i] == 's':            
            #     recovery += 5
            # elif minerals[j] == "stone" and a[i] == 'd':            
            #     recovery += 1
            # elif minerals[j] == "stone" and a[i] == 'i':            
            #     recovery += 1
            # elif minerals[j] == "stone" and a[i] == 's':            
            #     recovery += 1
#             j += 1
#             count += 1
    
    