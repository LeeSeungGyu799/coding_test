def solution(n):
    answer = []
    strn = str(n)
    for i in range(len(strn)):
        answer.append(int(strn[len(strn)-i-1]))
    return answer