def solution(s):
    answer = []
    for i in range(len(s)):
        target = s[i]
        temp_s = s[:i]

        if target in temp_s:
            answer.append(i - temp_s.rfind(s[i]))
        else:
            answer.append(-1)
    
    
    
    return answer

# s - 문자열 // 자신보다 먼저 나온 같은 글자중에 가장 가까운 놈은 어디?
