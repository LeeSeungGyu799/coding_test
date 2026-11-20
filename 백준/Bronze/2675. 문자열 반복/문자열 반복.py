from sys import stdin
t = int(input())
for i in range(t):
    r, s = stdin.readline().split()
    for j in range(len(s)):
        print(s[j] * int(r), end='')
    print('')