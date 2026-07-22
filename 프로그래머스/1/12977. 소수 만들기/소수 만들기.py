def solution(nums):
    answer = 0
    cnt = 0
    result = []
    for i in range(len(nums)-2):
        for j in range(i+1,len(nums)-1):
            for k in range(j+1,len(nums)):
                result.append(nums[i] + nums[j] + nums[k])
    for i in range(len(result)):
        cnt = 0
        for j in range(1, result[i]):
            if result[i] % j == 0:
                cnt += 1
        if cnt == 1:
            answer += 1
    

    return answer