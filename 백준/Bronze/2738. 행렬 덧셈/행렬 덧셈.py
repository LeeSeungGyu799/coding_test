from sys import stdin
n, m = map(int, stdin.readline().split())
a = [list(map(int, stdin.readline().split())) for i in range(n)]
b = [list(map(int, stdin.readline().split())) for j in range(n)]

for i in range(n):
    for j in range(m):
        a[i][j] += b[i][j]
for i in range(n):
    for j in range(m):
        print(a[i][j], end=' ')
    print('')