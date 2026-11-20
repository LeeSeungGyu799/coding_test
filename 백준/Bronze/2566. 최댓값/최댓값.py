from sys import stdin
a = [list(map(int, stdin.readline().split())) for i in range(9)]
ans = 0
p = q = 1
for i in range(9):
    if max(a[i]) > ans:
        ans = max(a[i])
        p = a[i].index(ans) + 1
        q = i + 1
print(ans)
print(q, p)