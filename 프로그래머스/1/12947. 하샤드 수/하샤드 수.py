def solution(x):
    answer = True
    div = 0
    strx = str(x)
    for i in range(len(strx)):
        div += int(strx[i])
    if x % div != 0:
        answer = False
    
    
    
    
    
    return answer


