def solution(s):
    answer = 0
    case = len(s)
    temp = ''
    
    for i in range(case):
        s = s[1:] + s[0]
        temp = s
        while True:
            if '[]' in temp:
                temp = temp.replace('[]', '')
            elif '{}' in temp:
                temp = temp.replace('{}', '')
            elif '()' in temp:
                temp = temp.replace('()', '')
            else:
                break
        if len(temp) == 0:
            answer += 1
            
    
    
    
    return answer