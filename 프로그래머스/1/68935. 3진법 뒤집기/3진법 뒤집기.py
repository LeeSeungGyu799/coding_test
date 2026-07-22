def solution(n):
    answer = 0
    answer_t = ''
    while n >= 3:
        answer_t = answer_t + str(n%3)
        n = n // 3
    answer_t = answer_t + str(n)
    print(answer_t)
    for i in range(len(answer_t)):
        answer += pow(3,len(answer_t)-i-1) * int(answer_t[i])
    
    
    return answer