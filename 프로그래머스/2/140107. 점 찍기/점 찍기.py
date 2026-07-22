def solution(k, d):
    answer = 0
    dot = d // k + 1
    sol = pow(d,2)//pow(k,2)
    for i in range(dot):
        answer += int((sol - pow(i, 2))**0.5) + 1
    return answer

# d^2 // k^2 <= a^2 + i^2