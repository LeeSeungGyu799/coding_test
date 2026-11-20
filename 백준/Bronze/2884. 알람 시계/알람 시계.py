Hour, Minute = map(int, input().split())

if Minute >= 45:
    Minute -= 45
else:
    Minute += 15
    if Hour == 0:
        Hour = 23
    else:
        Hour -= 1

print (Hour, Minute)
