def solution(n):
    answer = 0
    strn = str(n)
    for i in range(len(strn)):
        answer += int(strn[i])

    return answer