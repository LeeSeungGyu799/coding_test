def solution(phone_number):
    answer = ''
    info = phone_number[-4:]
    for i in range(len(phone_number)-4):
        answer += '*'
    answer += info
    return answer