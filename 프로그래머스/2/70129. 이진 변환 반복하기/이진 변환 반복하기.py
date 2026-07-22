def solution(s):
    cnt = 0
    z_cnt = 0
    
    temp = s.count('1')
       
    while True:
        if len(s) == 1:
            break
        z_cnt += len(s) - temp
        cnt += 1
        s = format(temp, 'b')
        temp = s.count('1')
        
    return [cnt, z_cnt]