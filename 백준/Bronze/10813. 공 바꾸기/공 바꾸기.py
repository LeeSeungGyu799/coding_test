import sys
N, M = map(int, sys.stdin.readline().split())
List = list(range(1, N+1))
for i in range(M):
    A, B = map(int, sys.stdin.readline().split())
    List[A-1], List[B-1] = List[B-1], List[A-1]
for i in range(N):
    print(List[i], end=" ")
