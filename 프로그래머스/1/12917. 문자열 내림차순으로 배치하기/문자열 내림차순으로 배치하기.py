def solution(s):
    answer = ''
    s = sorted(s)
    temp = ''
    for i in range(1, len(s) + 1):
        answer += s[len(s) - i]
        

    return answer