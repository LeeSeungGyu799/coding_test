def solution(n, m, section):
    answer = 1
    start = section[0]  
    
    for i in range(n):
        if len(section) > 0:
            start = section[0] + m
        for j in range(len(section)):
            if section[0] < start:
                section.pop(0)
            else:
                answer += 1
                break
    
    return answer




# 페이트 길이 n 왼쪽부터 1~n번
# 롤러의 길이 m 