def solution(id_list, report, k):
    answer = [0 for i in range(len(id_list))]
    id_dict = {}
    ban = []
    report_use = list(set(report))
    
    for i in range(len(id_list)):
        id_dict[id_list[i]]= 0
    
    for i in range(len(report_use)):
        reporter, reported = report_use[i].split()
        id_dict[reported] += 1
        
    for i in range(len(id_list)):
        if id_dict[id_list[i]] >= k:
            ban.append(id_list[i])
            
    for i in range(len(report_use)):
        reporter, reported = report_use[i].split()
        if reported in ban:
            answer[id_list.index(reporter)] += 1
    
    
    
    
    
    
    
    
    
    return answer



# 신고시스템. 동일 유저 반복 신고 = 1회 // k회 이상 신고 == 정지 
#