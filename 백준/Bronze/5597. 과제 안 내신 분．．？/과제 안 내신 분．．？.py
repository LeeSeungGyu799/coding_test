import sys
Student = [0 for i in range(30)]
for j in range(28):
    Num = int(sys.stdin.readline())
    Student[Num-1] = -1
for k in range(30):
    if Student[k] != -1:
        print(k+1)