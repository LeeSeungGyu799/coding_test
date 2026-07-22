def solution(n):
    answer = n-1
    list = [i+1 for i in range(n)]
    for i in range(2, n//2 + 1):
        if list[i-1] != '!':
            j = 2
            while i * j <= n:
                if list[i*j-1] != '!':
                    list[i*j -1] = '!'
                    answer -= 1
                j += 1

    return answer