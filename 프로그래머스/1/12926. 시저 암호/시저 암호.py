def solution(s, n):
    answer = ''
    temp = 0

    for i in range(len(s)):
        if ord(s[i]) >=97 and ord(s[i]) <=122:
            temp = ord(s[i]) + n
            if temp > 122:
                temp -= 26
            answer += chr(temp)
            continue
        if ord(s[i]) >=65 and ord(s[i]) <=90:
            temp = ord(s[i]) + n
            if temp > 90:
                temp -= 26
            answer += chr(temp)
            continue
        answer += s[i]
            
            
        
    
    
    return answer