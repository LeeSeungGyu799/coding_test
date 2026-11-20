from sys import stdin
s = stdin.readline().strip()
if list(s) == list(reversed(s)):
    print(1)
else:
    print(0)
    