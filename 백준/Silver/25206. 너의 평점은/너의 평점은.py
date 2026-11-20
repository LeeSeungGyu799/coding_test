from sys import stdin
p = {'A+': 4.5, 'A0': 4.0, 'B+': 3.5, 'B0': 3.0, 'C+': 2.5, 'C0': 2.0, 'D+': 1.5, 'D0': 1.0, 'F': 0.0}
t = a = 0
for i in range(20):
    s, h, g = stdin.readline().split()
    if g == 'P':
        continue
    t += float(h) * p[g]
    a += float(h)
print(t/a)