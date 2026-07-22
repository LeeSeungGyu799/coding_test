def solution(number):
    answer = 0
    twoList = []
    for i in range(len(number)):
        for j in range(i + 1, len(number)):
            for k in range(j + 1,len(number)):
                if number[i] + number[j] + number[k] == 0:
                    answer +=1
                    
    
    
    
    
    
    
    
    
    return answer 





# 정수번호 3명 합 0 = 삼총사
# 삼총사 가지수 return 하기 13 6 for 