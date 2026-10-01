def solution(money):
    def rob(start, end):
        prev2 = 0
        prev1 = 0

        for i in range(start, end):
            current = max(prev1, prev2 + money[i])
            prev2 = prev1
            prev1 = current

        return prev1

    # 1. 첫 번째 집 ~ 마지막 집 직전
    case1 = rob(0, len(money) - 1)

    # 2. 두 번째 집 ~ 마지막 집
    case2 = rob(1, len(money))

    return max(case1, case2)
    