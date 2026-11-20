a = int(input())
num = 1

while a > num:
    a -= num
    num += 1

add = num + 1

if num % 2 == 1:
    up = add - a
    down = a
else:
    up = a
    down = add - a


print(str(up) + "/" + str(down))