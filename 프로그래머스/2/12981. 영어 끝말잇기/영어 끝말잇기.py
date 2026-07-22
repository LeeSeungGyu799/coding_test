def solution(n, words):
    answer = []
    for i in range(1, len(words)):
        if words[i] in words[:i] or words[i][0] != words[i-1][-1]:
            answer.append(i%n+1)
            answer.append(i//n+1)
            return answer
    if answer == []:
        answer = [0,0]
    return answer