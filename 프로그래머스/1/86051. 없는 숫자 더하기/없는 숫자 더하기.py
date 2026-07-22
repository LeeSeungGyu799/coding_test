def solution(numbers):
    answer = -1
    n = 0
    for i in range(len(numbers)):
        n += int(numbers[i])
    answer = 45 - n
    return answer



