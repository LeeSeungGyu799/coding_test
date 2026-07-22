from sys import stdin
def solution(record):
    answer = []
    name = {l.split()[1] : l.split()[2] for l in record if l.split()[0] != 'Leave'}
    for i in range(len(record)):
        if record[i].split()[0] == 'Enter':
            answer.append(name[record[i].split()[1]]+'님이 들어왔습니다.')
        elif record[i].split()[0] == 'Leave':
            answer.append(name[record[i].split()[1]]+'님이 나갔습니다.')
    return answer