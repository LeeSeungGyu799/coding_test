def solution(n):
    answer = 0
    i = 0
    answer_list = []
    while len(answer_list) != 100:
        i += 1
        if i % 3 == 0 or '3' in str(i):
            continue
        else:
            answer_list.append(i)    
        
    
    return answer_list[n-1]

