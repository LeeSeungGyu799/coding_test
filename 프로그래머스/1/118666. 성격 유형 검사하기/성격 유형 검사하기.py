def solution(survey, choices):
    type = {'R' : 0, 'T': 0, 'C' : 0, 'F' : 0, 'J' : 0, 'M' : 0, 'A' : 0, 'N' : 0}    
    answer = ''
    n = len(survey)
    
    for i in range(n):
        if choices[i] == 4:
            continue
        elif choices[i] < 4:
            type[survey[i][0]] += 4 - choices[i]
        else:
            type[survey[i][1]] += choices[i] - 4
    print(type)
            
    if type['R'] >= type['T']:
        answer += 'R'
    else: 
        answer += 'T'
        
    if type['C'] >= type['F']:
        answer += 'C'
    else: 
        answer += 'F'
        
    if type['J'] >= type['M']:
        answer += 'J'
    else: 
        answer += 'M'
        
    if type['A'] >= type['N']:
        answer += 'A'
    else: 
        answer += 'N'

    return answer




# R-T C-F J-M A-N // survey 길이 = n  choice 1~7
# 비동의 = 앞 동의 = 뒤
 #["RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA"]