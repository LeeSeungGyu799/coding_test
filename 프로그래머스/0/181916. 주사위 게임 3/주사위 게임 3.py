def solution(a, b, c, d):
    answer = 0
    """
    1. a=b=c=d
    2. 1개만 다름
    3. 2개씩
    4. 2개 1개 1개
    5. 전부 다름
    
    오름차순정렬 > 비교
    """
    dice = [a,b,c,d]
    dice.sort()
    unique_dice = list(set(dice))
    
    if (len(unique_dice) == 1):
        answer = 1111 * dice[0]
        return answer
    
    elif (len(unique_dice) == 2):
        temp_dice = dice.copy()
        
        for x in unique_dice:
            temp_dice.remove(x)
        temp_dice = list(set(temp_dice))
        
        if(len(temp_dice) == 1):
            unique_dice.remove(temp_dice[0])
            answer = pow((10 * temp_dice[0] + unique_dice[0]),2)
            return answer
        else:
            answer = (temp_dice[0] + temp_dice[1]) * (temp_dice[0] - temp_dice[1])
            if answer < 0:
                answer *= -1
            return answer
        
    elif (len(unique_dice) == 3):
        temp_dice = dice.copy()
        
        for x in unique_dice:
            temp_dice.remove(x)
        unique_dice.remove(temp_dice[0])
        answer = (unique_dice[0] * unique_dice[1])
        return answer   
    
    elif(len(unique_dice) == len(dice)):
        answer = dice[0]
        return answer
    
    else:
        print("error")
        return 0
    