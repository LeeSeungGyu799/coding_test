def solution(a, b):
    answer = 0
    n = len(a)
    for i in range(n):
        answer += a[i] * b[i]
    
    
    return answer



# a, b 정수배열 // s내적구하기