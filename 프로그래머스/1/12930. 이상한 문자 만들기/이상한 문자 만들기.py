def solution(s):
    answer = ''
    cnt = 0
    while len(s) != 0:
        if s[0] == ' ':
            cnt = 0
            s = s[1:]
            answer += ' '
            continue
            
        if cnt %2 == 0:
            answer += s[0].upper()
        else:
            answer += s[0].lower()
        cnt += 1
        s = s[1:]
    
    
    
    return answer