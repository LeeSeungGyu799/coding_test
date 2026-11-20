from sys import stdin
a = [list(stdin.readline().strip()) for i in range(5)]
j = 0
for i in range(15):
    for j in range(5):
        if i >= len(a[j]):
            continue
        else:
            print(a[j][i], end='')
