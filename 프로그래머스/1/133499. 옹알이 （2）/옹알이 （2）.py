def solution(babbling):
    answer = 0
    token = ['aya','ye','woo','ma']
    
    for i in range(len(babbling)):
        for j in token:
            d_j = j + j
            if j in babbling[i] and d_j not in babbling[i]:
                babbling[i] = babbling[i].replace(j, '!')
                
        babbling[i] = babbling[i].replace('!', '')
        if len(babbling[i]) == 0 :
            answer += 1
        
    return answer


#  aya ye woo ma 4개 // 연속은 안돼요 // babbling = 문자열 발음 // 몇개나 됨?
