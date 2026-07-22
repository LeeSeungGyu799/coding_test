def solution(array, commands):
    answer = []
    n_array = []
    for i in range(len(commands)):
        n_array = array[commands[i][0]-1:commands[i][1]]
        n_array.sort()
        answer.append(n_array[commands[i][2]-1])
    return answer


#