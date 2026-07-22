def solution(number, limit, power):
    answer = 0
    knight = [1 for i in range(number)]
    
    for i in range(2, len(knight)+1):
        for j in range(i - 1, number , i):
            knight[j] += 1
    
    for k in range(len(knight)):
        if knight[k] > limit:
            knight[k] = power
        answer += knight[k]
    
    
    
    
    
    
    return answer



# 기사번호의 약수 개수 = 공격력 but 제한수치보다 넘으면 정해진 공격력.
# 철의 무게 = 공격력의 합
#  number = 기사 단원 수, limit = 제한, power = 제한일때 공격력