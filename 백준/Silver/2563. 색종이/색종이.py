from sys import stdin
w = [[0 for _ in range(100)]for _ in range(100)]
n = int(stdin.readline())
for i in range(n):
    p, q = map(int, stdin.readline().split())
    for j in range(10):
        for k in range(10):
            w[p+j][q+k] = 1
s = [sum(w[i]) for i in range(100)]
print(sum(s))