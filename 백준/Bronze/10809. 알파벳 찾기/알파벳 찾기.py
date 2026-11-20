from sys import stdin
S = stdin.readline()
alpha = [S.find(chr(i)) for i in range(ord('a'), ord('a')+26)]
for i in range(26):
    print(alpha[i], end=" ")
