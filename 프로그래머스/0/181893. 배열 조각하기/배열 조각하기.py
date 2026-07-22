def solution(arr, query):
    answer = []
    cnt = 0
    for x in query:
        if cnt % 2 == 0: #짝
            arr = arr[0:query[cnt]+1]
            cnt += 1
        else: 
            arr = arr[query[cnt]:]
            cnt += 1
    return arr