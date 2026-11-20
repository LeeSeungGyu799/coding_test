from sys import stdin
d = ['ABC','DEF','GHI','JKL','MNO','PQRS','TUV','WXYZ']
s = stdin.readline().rstrip()
r = 0
for i in range(len(s)):
    for j in range(len(d)):
        if s[i] in d[j]:
            r += j + 3
print(r)