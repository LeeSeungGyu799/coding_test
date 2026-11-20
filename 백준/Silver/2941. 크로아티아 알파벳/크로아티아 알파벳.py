from sys import stdin
c = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
s = stdin.readline().strip()
cnt = 0
for i in range(len(c)):
    cnt += s.count(c[i])
    s = s.replace(c[i], " ")
print(cnt + len(s.replace(" ", "")))
