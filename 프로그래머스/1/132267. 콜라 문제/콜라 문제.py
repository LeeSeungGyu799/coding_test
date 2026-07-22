def solution(a, b, n):
    answer = 0
    temp = 0
    
    while n >= a:
        temp = n // a
        answer += temp * b
        n += temp * (b - a)
    return answer


#빈병 a = 콜라 b n 병이면 몇개?