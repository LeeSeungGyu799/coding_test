def solution(numbers):
    answer = []
    temp = []
    for i in range(len(numbers)):
        for j in range(i + 1, len(numbers)):
            temp.append(numbers[i] + numbers[j])
    answer = sorted(list(set(temp)))
    
    
    
    
    return answer


#numbers 정수배열 