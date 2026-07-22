def solution(n):
    answer = -1
    i = 0
    while pow(i,2) <= n:
        if n == pow(i,2):
            answer = pow(i+1,2)
            break
        i += 1
        
    
    
    
    return answer