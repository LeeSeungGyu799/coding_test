def moveDog(park, dog, move_dir, move_dis): # 0,0 0,1 2
    ix, iy = dog
    x, y = dog
    
    
    for i in range(move_dis):
        x += move_dir[0]
        y += move_dir[1]
        if x >= len(park) or x < 0:
            return [ix,iy]
        if y >= len(park[0]) or y < 0:
            return[ix,iy]
        if park[x][y] == "X":
            return [ix,iy]
        
    return [x,y]

def solution(park, routes):
    for i in range(len(park)):
         if "S" in park[i]:
            dog = [i, park[i].index("S")]
            
    dir = {'N':[-1,0], 'S':[1,0], 'E':[0,1], 'W':[0,-1]}

    for j in range(len(routes)):
        move_dir = dir[routes[j][0]]
        move_dis = int(routes[j][2])
        
        dog = moveDog(park, dog, move_dir, move_dis) 
    return dog

# 방향 거리 방향 거리
# 가로 W 세로 H 길 O 장애물 X 시작 S 
# park = 공원을 나타내는 문자열 배열, routes = 명령이 담긴 문자열 배열
