# 09:55 ~ 10:42
# 입력 최대 : n =40
# 
# <반례>
# ::
# 0000::0000:b
# ::0000:b
# 1:2:3:4:5::
# ::2:3:4:4
# 1::2:3:4:4
# 123::
# 처음에는 semicolon_count 기준으로 함
# 0000:0000:0000:0000:0000:0000:0003::
# ::0000:0000:0000:0000:0000:0000:0003 -> 반예 60%

l = list(input())

results = ""
tmp = ""
previous = ":"
count = 0
semicolon_count = 0
double_semicolon = False

for b,a in enumerate(l):
    # double semicolon 일떄는 semicolon count 안함
    if a == ":" and previous == ":":
        # double semicolon이 있다면 끝난 이후에 split해서 0000 추가
        double_semicolon = True
        results += ":"
        continue
    
    # 2) semicolon (double semicolon 제외)이면 count빠진만큼 0추가하고 previous = ":"
    elif a == ":":
        if count != 4:
            results += "0"*(4-count)
        results += tmp
        count = 0
        results += ":"
        previous = ":"
        tmp = ""
        semicolon_count += 1
        
    # 3) 배열 마지막일때 semicolon 없어도 추가
    elif b == len(l)-1:
        count += 1
        tmp += a
        if count != 4:
            results += "0"*(4-count)
        results += tmp
        previous = ""
    # 1) 단순 tmp 추가 + 몇개 문자인지 계산 (previous는 double semicolon 일때만 표기)
    elif a != ":":
        count += 1
        tmp += a
        previous = ""
       
# semicolon Count가 7일때가 아닌 True일때
if double_semicolon:
    x = results.split("::")
    # 단순 "::"
    if x[0] == '' and x[1] == '':
        results = "0000:0000:0000:0000:0000:0000:0000:0000"
    # "4::"
    elif x[1] == '' :
        results = x[0] + ":0000"*(7-semicolon_count+1) + x[1]  
           
    # "::2"
    elif x[0] == '':
        results = x[0] + "0000:"*(7-semicolon_count) + x[1] 
        
    # "1::2"    
    else:
        results = x[0] + ":" + "0000:"*(7-semicolon_count) + x[1]     
                
print(results)

        






