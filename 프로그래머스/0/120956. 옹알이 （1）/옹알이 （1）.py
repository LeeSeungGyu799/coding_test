def solution(babbling):
    answer = 0
    token = ['aya', 'ye', 'woo', 'ma']
    for j in range(len(babbling)):
        for i in token:
            if i in babbling[j]:
                babbling[j] = babbling[j].replace(i, '!',1)
        babbling[j] = babbling[j].replace('!', '')
        if len(babbling[j]) == 0:
            answer += 1
    return answer



