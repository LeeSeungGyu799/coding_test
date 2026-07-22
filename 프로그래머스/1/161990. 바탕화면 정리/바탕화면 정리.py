def solution(wallpaper):
    answer = [50, 50, 0, 0]
    
    for i in range(len(wallpaper)):
        if "#" in wallpaper[i]:
            answer = [min(answer[0],i), min(answer[1], wallpaper[i].index("#")),
                      max(answer[2],i + 1), max(answer[3], wallpaper[i].rfind("#")+ 1)]
    
                
            
            
    
    
    
    
    
    
    return answer





# wallpaper = 바탕화면의 상태 (정사각형 격자) 빈칸 . 파일 #
# 거리 = x축거리 + y축거리
#