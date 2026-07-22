def solution(left, right):
    answer = 0
    for i in range(left, right+1):
        if pow(pow(i,0.5), 2) == i and int(pow(i,0.5)) == pow(i,0.5):
            answer -= i
        else:
            answer += i

    return answer

