def solution(n, m):
    answer = []
    if n <= m:
        n,m = m, n
        
    check = n * m
    
    while m != 0:
        n, m = m , n%m
        
    answer.append(n)
    
    i = check // n
    answer.append(i)
    
    
    
    
    return answer