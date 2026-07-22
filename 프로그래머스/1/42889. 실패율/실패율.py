def solution(N, stages):
    answer = []
    stages.sort()
    stage_dict = {}
    clear, no_clear = len(stages), 0
    
    for i in range(1, N+2):
        stage_dict[i] = 0
    
    for i in range(len(stages)):
        stage_dict[stages[i]] += 1
    for i in range(len(stage_dict)):
        no_clear = stage_dict[i+1]
        if no_clear == 0 or clear == 0:
            stage_dict[i+1] = 0
            continue
        stage_dict[i+1] /= clear
        clear -= no_clear
    del stage_dict[len(stage_dict)]
    answer = sorted(stage_dict, key=lambda x:stage_dict[x], reverse=True)
    
    
    
    return answer


# 실패율 = 도달했는데 아직 못클리어 한 사람 / 도달한 사람
# n = 전체 스테이지 수 // stage = 사용자가 멈춘 레벨