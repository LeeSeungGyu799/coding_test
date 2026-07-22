def solution(answers):
    answer = []
    a_score, b_score, c_score = 0, 0, 0
    b_test, c_test = 0, 0
    
    for i in range(len(answers)):
        if answers[i] == (i % 5) + 1:
            a_score += 1
            
        b_test = i % 8
        if i % 2 == 0:
            if answers[i] == 2:
                b_score += 1
        else:
            if b_test == 1:
                if answers[i] == 1:
                    b_score += 1
            if b_test == 3:
                if answers[i] == 3:
                    b_score += 1
            if b_test == 5:
                if answers[i] == 4:
                    b_score += 1
            if b_test == 7:
                if answers[i] == 5:
                    b_score += 1
                    
        c_test = i % 10
        if c_test == 0 or c_test == 1:
            if answers[i] == 3:
                c_score += 1
        if c_test == 2 or c_test == 3:
            if answers[i] == 1:
                c_score += 1
        if c_test == 4 or c_test == 5:
            if answers[i] == 2:
                c_score +=  1
        if c_test == 6 or c_test == 7:
            if answers[i] == 4:
                c_score += 1
        if c_test == 8 or c_test == 9:
            if answers[i] == 5:
                c_score += 1
            
    score_list = [a_score, b_score, c_score]
    
    for i in range(3):
        if max(a_score, b_score, c_score) == score_list[i]:
            answer.append(i+1)
    
    
    return answer
# 1번 12345 반복 2번 21232425 반복 3번 3311224455 반복