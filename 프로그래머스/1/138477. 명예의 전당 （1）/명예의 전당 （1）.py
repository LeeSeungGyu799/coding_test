def solution(k, score):
    answer = []
    h = [-1 for i in range(k)]
    
    for i in range(len(score)):
        if min(h) < score[i]:
            h.pop(h.index(min(h)))
            h.append(score[i])
        propose = set(h)
        if min(propose) == -1:
            propose.remove(-1)
        answer.append(min(propose))
    
    
    return answer

# 점수 상위 k번째 이내 = 점수는 명예의 전당으로
# score = 점수 