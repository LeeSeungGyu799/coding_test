def solution(name, yearning, photo):
    answer = []
    point = dict()
    for n, p in enumerate(name):
        point[p] = yearning[n]

    for i in range(len(photo)):
        temp = 0
        for j in range(len(photo[i])):
            if photo[i][j] in point:
                temp += point[photo[i][j]]
        answer.append(temp)  
    return answer

# 그리움점수 합 이름 / 점수 / 