def solution(price, money, count):
    answer = -1
    num = (count * (count+1))/ 2
    use = price * num
    if money >= use:
        answer = 0
    else:
        answer = use - money
    
    return answer


# 이용료 price, n번째는 n*price 