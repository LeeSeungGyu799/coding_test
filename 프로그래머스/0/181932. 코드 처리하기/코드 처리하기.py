def solution(code):
    answer = ''
    mode = 0
    check = 1
    idx = 0
    
    for x in code:
        if x == '1':
            mode = mode + check
            check *= -1
            idx += 1
        else:
            if idx % 2 == mode:
                answer += x
                idx += 1
            else:
                idx += 1
                
    if len(answer) == 0:
        return "EMPTY"
    
    return answer