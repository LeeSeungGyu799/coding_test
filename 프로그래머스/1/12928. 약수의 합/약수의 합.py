def solution(n):
    answer = 0
    
    i = 1
    while  i <= n//i:
        if n % i == 0:
            answer += i
            answer += n//i
        
        if i == n/i:
            answer -= i
        
        i += 1
    
    
    
    return answer