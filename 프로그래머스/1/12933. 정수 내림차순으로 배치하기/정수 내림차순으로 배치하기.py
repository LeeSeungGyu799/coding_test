def solution(n):
    answer = ''
    list = []
    for i in range(len(str(n))):
        list.append(int(str(n)[i]))
    list.sort(reverse = True)
    for i in range(len(list)):
        answer += str(list[i])
    
    return int(answer)