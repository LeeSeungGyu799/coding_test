def dist(pos, goal):
    goal_cor = [3 - (goal//3), 1]
    if goal == 0: 
        goal_cor = [0,1]
    x_dis = goal_cor[0] - pos[0]
    y_dis = goal_cor[1] - pos[1]
    
    return abs(x_dis) + abs(y_dis), goal_cor

def solution(numbers, hand):
    answer = ''
    left = [1, 4, 7]
    right = [3, 6, 9]
    lnow, rnow = [0,0], [0,2]
    goal_l, goal_r = [], []
    ldis, rdis = 0, 0
    
    for i in range(len(numbers)):
        if numbers[i] in left:
            lnow = [3 - (numbers[i]//3), 0]
            answer += 'L'
            continue
        if numbers[i] in right:
            rnow = [4 - (numbers[i]//3), 2]
            answer += 'R'
            continue
            
        ldis, goal_l = dist(lnow, numbers[i])
        rdis, goal_r = dist(rnow, numbers[i])
        
        if ldis == rdis:
            if hand == "right":
                rnow = goal_r
                answer+= 'R'
                continue
            else:
                lnow = goal_l
                answer += 'L'
                continue
        elif ldis < rdis:
            lnow = goal_l
            answer += 'L'
        else:
            rnow = goal_r
            answer += 'R'

    return answer



# 1 2 3 
# 4 5 6
# 7 8 9
# * 0 #   왼 시작 별 우 시작 샵 // 상하좌우 한칸이동 // 왼쪽= 왼손 오른쪽= 오른손 중앙 = 가까운거(같다면 왼손오른손잡이 확인