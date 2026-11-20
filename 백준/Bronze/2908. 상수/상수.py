from sys import stdin
A, B = stdin.readline().split()
A, B = A[::-1], B[::-1]
if(A>B):
    print(int(A))
else:
    print(int(B))