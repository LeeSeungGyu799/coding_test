from sys import stdin
s = stdin.readline().strip()
ss = list(set(s.lower()))
c = 0
r = ''
for i in range(len(ss)):
    if s.lower().count(ss[i]) > c:
        c = s.lower().count(ss[i])
        r = ss[i].upper()
    elif s.lower().count(ss[i]) == c:
        c = s.lower().count(ss[i])
        r = '?'
print(r)
