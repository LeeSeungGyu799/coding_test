def solution(absolutes, signs):
    answer = 0
    
    for i in range(len(signs)):
        if signs[i] is True:
            answer += absolutes[i]
        else:
            answer -= absolutes[i]

    
    
    
    
    return answer