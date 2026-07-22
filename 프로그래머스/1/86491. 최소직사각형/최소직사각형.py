def solution(sizes):
    answer = 0
    x_top, y_top, temp_x, temp_y = 0, 0, 0, 0

    for i in range(len(sizes)):
        temp_x = list(sizes[i])[0]
        temp_y = list(sizes[i])[1]
        
        if temp_x < temp_y:
            temp_x, temp_y =  temp_y, temp_x
    
        if temp_x > x_top:
            x_top = temp_x
        if temp_y > y_top:
            y_top = temp_y
            
    answer = x_top * y_top
    
    return answer



# sizes [가로w 세로h]