def solution(cards1, cards2, goal):
    answer = ''
    cnt = 0
    for i in range(len(goal)):
        if len(cards1) == 0:
            cards1 = [0]
        if len(cards2) == 0:
            cards2 = [0]
        
        if goal[i] == cards1[0]:
            cards1.pop(0)
            cnt += 1
        elif goal[i] == cards2[0]:
            cards2.pop(0)
            cnt += 1
        else:
            answer = 'No'
            break
    print(cnt)
    if cnt == len(goal):
        answer = 'Yes'
            
    return answer