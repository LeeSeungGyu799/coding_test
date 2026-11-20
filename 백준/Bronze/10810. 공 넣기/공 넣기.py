import sys
N, M = map(int, sys.stdin.readline().split())
List = [0] * N
for i in range(M):
    S, E, B = map(int, sys.stdin.readline().split())
    for j in range(S-1, E):
        List[j] = B
for i in range(N):
    print(List[i], end=" ")
