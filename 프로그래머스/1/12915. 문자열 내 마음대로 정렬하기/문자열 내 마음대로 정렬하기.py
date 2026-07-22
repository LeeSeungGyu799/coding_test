def solution(strings, n):
    answer = []
    word_arr = []

    strings.sort()
    
    for i in range(len(strings)):
        word_arr.append(strings[i][n])
    word_arr.sort()

    for i in word_arr:
        for j in strings:
            if i == j[n]:
                answer.append(j)
                strings.remove(j)
                break    
    

    return answer