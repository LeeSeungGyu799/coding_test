def solution(num):
    answer = 0
    cnt = 0
    while num != 1 and cnt <= 500:
        if num % 2 == 0:
            num /= 2
            cnt+=1
            continue
        else:
            num = (num * 3) + 1
            cnt+=1
    if cnt == 501:
        cnt = -1
    
    
    
    return cnt