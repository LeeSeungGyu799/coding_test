def solution(today, terms, privacies):
    answer = []
    terms_dict = dict()
    
    t_y, t_m, t_d = map(int,today.split('.'))
    
    for i in range(len(terms)):
        term_name, term_len = terms[i].split()
        terms_dict[term_name] = int(term_len)
    
    for j in range(len(privacies)):
        for k in range(len(terms)):
            if terms[k][0] in privacies[j]:
                
                privacies[j] = privacies[j][:-2]
                p_y, p_m, p_d = map(int, privacies[j].split('.'))
                p_m += terms_dict[terms[k][0]]
                
                while p_m > 12:
                    p_m -= 12
                    p_y += 1
                    
                if t_y > p_y:
                    answer.append(j + 1)
                elif t_y < p_y: 
                    break
                else: 
                    if t_m > p_m:
                        answer.append(j + 1)
                    elif t_m < p_m: 
                        break
                    else:
                        if t_d >= p_d:
                            answer.append(j + 1)
                        else:
                            break

    return answer




# n = 개인정보 수 // 모든 달 = 28일 // 
# today = 오늘 날짜 // terms = 유효기간 // privacies = 개인정보 (날짜 약관)