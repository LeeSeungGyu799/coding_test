Hour, Minute = map(int, input().split())
Time = int(input())

CookHour = int((Minute + Time) / 60)
CookMinute = (Minute + Time) % 60
if Hour + CookHour >= 24:
    Hour -= 24

print(Hour + CookHour, CookMinute)