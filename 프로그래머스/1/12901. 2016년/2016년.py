def solution(a, b):
    answer = ''
    yoil = ['FRI','SAT','SUN','MON','TUE','WED','THU']
    day = [31,29,31,30,31,30,31,31,30,31,30,31]
    total = 0
    for i in range(a-1):
        total += day[i]
    total += b - 1
    answer = yoil[total%7]
    
    
    return answer