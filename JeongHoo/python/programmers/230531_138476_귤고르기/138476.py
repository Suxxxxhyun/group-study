def solution(k, tangerine):
    track = [0]*(max(tangerine)+1)
    
    for a in range(len(tangerine)):
        track[tangerine[a]] += 1
    
    track.sort(reverse = True)
    
    count = 0
    start = 0
    while k > 0:
        k = k - track[start]
        count += 1
        if start == len(tangerine)-1:
            break
        start += 1

    return count
    
    
#     tmp = dict()
#     for a in range(len(tangerine)):
#         if tangerine[a] not in tmp:
#             tmp[tangerine[a]] = 1
#         else:
#             tmp[tangerine[a]] += 1
#     l = list(tmp.values())
#     l.sort(reverse = True)
#     count = 0 
#     start = 0
#     while k > 0:
#         k = k - l[start]
#         count += 1
#         if start == len(l)-1:
#             break
#     return count