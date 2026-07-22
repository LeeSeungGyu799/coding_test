def solution(s):
    answer = 0
    ntow = ['zero','one','two','three','four','five','six','seven','eight','nine']
    
    for i in range(len(ntow)):
        if ntow[i] in s:
            s = s.replace(ntow[i], str(i))
    return int(s)



# 숫자의 일부 자리수를 영어로 바꿔었음. s에용
