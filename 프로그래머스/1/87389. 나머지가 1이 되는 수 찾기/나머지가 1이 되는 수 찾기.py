def solution(n):
    answer = 0
    n -= 1
    for i in range(2, n//2):
        if n % i == 0:
            answer = i
            break
        else:
            answer = n
    
    
    return answer

# 자연수 n // x == 나머지가 1이 되는 제일 작은 자연수