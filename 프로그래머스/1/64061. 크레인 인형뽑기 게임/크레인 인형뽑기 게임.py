def solution(board, moves):
    answer = 0
    n = len(board)
    new_board = []
    temp = []
    basket = []
    
    for i in range(n):
        for j in range(n):
            if board[j][i] != 0:
                temp.insert(0, board[j][i])
        if temp == []:
            temp = [0]
        new_board.append(temp)
        temp = []
        
    for i in range(len(moves)):
        if new_board[moves[i] - 1] == [0]:
            continue
        else:
            if len(new_board[moves[i]-1]) == 1:
                basket.append(new_board[moves[i] - 1][0])
                new_board[moves[i] - 1] = [0]
            else:
                t = new_board[moves[i] - 1].pop()
                basket.append(t)
        if len(basket) >= 2:
            if basket[-1] == basket[-2]:
                basket = basket[:-2]
                answer += 2
                
        
                
    
    

            
    return answer


# nxn 격자 // 바게쓰 안의 두 인형은 터짐 // board == 보드 배열 0은 빈거래 // move == 가장 위에서 뽑아서 빠께스로 // 인형 몇개 터짐?
