def solution(s):
    answer = 0
    x = s[0]
    same = 0
    diff = 0
    set_x = 1

    for i in s:
        if set_x == 1:
            x = i
            set_x = 0
            
        if x == i:
            same += 1
        else :
            diff += 1
        
        if same == diff:
            answer += 1
            same = 0
            diff = 0
            set_x = 1
    
    if set_x == 0:
        answer += 1

    return answer


# x 첫글자 x와 x가 아닌 횟수 세고, 같아지면 분리.
# 분리한거 빼고, 다시. 몇번이나 분리했어요?