def solution(food):
    answer = ''
    result = []
    h_answer = ''
    for i in range(1, len(food)):
        if food[i] % 2 == 1:
            food[i] -= 1
        for j in range(food[i] // 2):
            result.append(i)
    
    for i in range(len(result)):
        h_answer += str(result[i])
    answer = h_answer + '0' + h_answer[::-1]
    
    
    
    
    
    
    
    return answer



# 선수갑 좌->우 // 선수을 우->좌 // 중앙에 우승물
# 종류 양 같아야함 == 0 기준 좌우대칭, 낮은것부터 // 111 2222 333333  1223330333221  1은버림
# food = 0 1 2 3 ...