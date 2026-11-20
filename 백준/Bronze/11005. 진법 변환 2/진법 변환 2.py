from sys import stdin
n, b = map(int, stdin.readline().split())
i = 0
a = []
while True:
    if b > n:
        a.append(n)
        break
    a.append(n % b)
    n = int(n/b)
for j in range(len(a)-1, -1, -1):
    if a[j] > 9:
        print(chr(a[j]+55), end='')
    else:
        print(a[j], end='')