def solution(line):
    answer = []
    dot = []
    temp = ""
    down = 0
    x, y = 0, 0
    lx, ly, rx, ry = 0,0,0,0
    xlen, ylen = 0,0
    indextemp = 0
    
    for i in range(len(line)-1):
        for j in range(i+1, len(line)):
            down = line[i][0]*line[j][1] - line[i][1]*line[j][0]
            if down == 0:
                continue
            else:
                x = (line[i][1]*line[j][2] - line[i][2]*line[j][1]) / down
                y = (line[i][2]*line[j][0] - line[i][0]*line[j][2]) / down
                if x.is_integer() and y.is_integer():
                    x, y = int(x), int(y)
                    dot.append([x,y])
    dot = list(set(map(tuple, dot)))
    
    if len(dot) == 1:
        answer.append("*")
        return answer
    else:
        lx, ly = min(dot[0][0],dot[1][0]), min(dot[0][1], dot[1][1]) # leftmost, down
        rx, ry = max(dot[0][0],dot[1][0]), max(dot[0][1], dot[1][1]) # rightmost, up
    
    for i in range(1, len(dot)):
        if lx > dot[i][0] : lx = dot[i][0]
        if ly > dot[i][1] : ly = dot[i][1]
        if rx < dot[i][0] : rx = dot[i][0]
        if ry < dot[i][1] : ry = dot[i][1]
    
    print(lx, ly, rx, ry)
    print(dot)
    xlen = rx - lx + 1
    ylen = ry - ly + 1
    
    for i in range(ylen):
        for j in range(xlen):
            temp += '.'
        answer.append(temp)
        temp = ''
        
    for i in range(len(dot)):
        indextemp = dot[i][0]-lx
        answer[ry-dot[i][1]] = answer[ry-dot[i][1]][:indextemp] +'*'+ answer[ry-dot[i][1]][indextemp+1:]
        
        
        
    
    return answer