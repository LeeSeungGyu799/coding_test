def solution(k, t):
    answer, temp, j = 0, 0, 0
    t_dict = {}
    amount =[]
    
    for i in t:
        if i in t_dict:
            t_dict[i] += 1
        else:
            t_dict[i] = 1
    for i in list(set(t)):
        amount.append(t_dict[i])
    amount.sort(reverse = True)
    
    while k > temp:
        temp += amount[j]
        j+= 1
        answer += 1
    
    
    return answer

# k = 개수 t = 귤
