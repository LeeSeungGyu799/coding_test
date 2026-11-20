a = int(input())
result = 1

for i in range(a):
    result += i*6
    if a <= result:
        print(i+1)
        break

    