def solution(k, m, score):
    answer = 0
    score.sort(reverse = True)
    for i in range(len(score)//m):
        answer += score[m*(i+1)-1] * m
    return answer


# 점수 1~k // 사과 1상자 = m개 * 가장 낮은 가격 p // 
# score을 sort(reverse=t) 한 후 3개로 끊는다? -> 최소값 *3
# 4 1 2 2 4 4 4 4 1 2 4 2 -> 4 4 4 / 4 4 4 / 2 2 2/ 2 1 1 - 12 12 6 3 - 33