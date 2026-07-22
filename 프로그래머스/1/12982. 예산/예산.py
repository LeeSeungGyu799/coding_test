def solution(d, budget):
    answer = 0
    now = 0
    d.sort()
    while now < budget:
        now += d[answer]
        answer += 1
        if now > budget:
            answer -=1
            break
        if answer == len(d):
            break
    return answer


# d = 신청애 ㄱbudghet = 예산 //최대 몇개 부서?