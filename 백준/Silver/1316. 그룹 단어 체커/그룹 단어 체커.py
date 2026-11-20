from sys import stdin
n = int(input())
cnt = n
for i in range(n):
    s = stdin.readline().strip()
    for j in range(len(s)-1):
        if s[j] == s[j+1]:
            continue
        elif s[j] in s[j+1:]:
            cnt -= 1
            break
print(cnt)