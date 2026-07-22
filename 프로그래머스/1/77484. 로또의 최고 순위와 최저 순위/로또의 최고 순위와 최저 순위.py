def solution(lottos, win_nums):
    answer = []
    right = 0
    for i in range(len(lottos)):
        if lottos[i] != 0 and lottos[i] in win_nums:
            right += 1
    possible = lottos.count(0)
    print(right, possible)
    
    pos_top = 7 - (possible + right)
    if  pos_top > 5:
        pos_top = 6
    pos_low = 7 - right
    if pos_low > 5:
        pos_low = 6
    answer = [pos_top, pos_low]
    

    return answer


# 모르는거 0 // lottos 내 로또 win  당첨