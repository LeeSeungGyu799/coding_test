def solution(t, p):
    answer = 0
    p_t = []
    for i in range(len(t) - len(p) + 1):
        temp = t[i:i + len(p)]
        p_t.append(int(temp))
    for j in range(len(p_t)):
        if p_t[j] <= int(p):
            answer += 1
    
    
    
    
    
    
    
    return answer



# t p = 숫자 문자열   p와 길이가 같은 t의 부분문자열 중에서 p보다 작거나 같은것을 return