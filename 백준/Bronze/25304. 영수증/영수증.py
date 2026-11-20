Total = int(input())
Num = int(input())
Temp = 0

for i in range(Num):
    P, Q = map(int, input().split())
    Temp += P * Q

if Total == Temp:
    print("Yes")
else:
    print("No")