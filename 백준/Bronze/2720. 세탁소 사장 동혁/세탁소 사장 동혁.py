from sys import stdin
t = int(stdin.readline())
for i in range(t):
    m = int(stdin.readline())
    for j in [25, 10, 5, 1]:
        print(m//j, end=' ')
        m = m % j
    print('')
