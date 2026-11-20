import sys
N, M = map(int, sys.stdin.readline().split())
List = list(range(1, N+1))
for q in range(M):
    i, j = map(int, sys.stdin.readline().split())
    List = List[:i-1] + list(reversed(List[i-1:j])) + List[j:]
for i in range(N):
    print(List[i], end=" ")
