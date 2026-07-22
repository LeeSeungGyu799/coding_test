def solution(r1, r2):
    answer = 0
    cnt = 0
    # 1사분면 구하기 + r2-r1 *4
    for i in range(1, r2):
        if pow(r1,2) - pow(i,2) <= 0:
            minimum = 0
        else:
            minimum = pow(pow(r1,2) - pow(i,2), 1/2)   
        maximum = pow(pow(r2,2) - pow(i,2), 1/2)
        
        if minimum == int(minimum) and minimum != 0:
            cnt += 1
    
        if minimum != 0:
            cnt += int(maximum) - int(minimum)
        else:
            cnt += int(maximum)
    cnt += r2 - r1 + 1
    
    answer = 4 * cnt
    
    
    return answer