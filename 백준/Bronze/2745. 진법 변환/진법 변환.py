from sys import stdin
n, b = stdin.readline().strip().split()
a = 0
for i in range(len(n)):
    if n[i].isdigit():
        a += pow(int(b), len(n) - i - 1) * int(n[i])
    else:
        a += pow(int(b), len(n) - i - 1) * (ord(n[i]) - 55)
print(a)
