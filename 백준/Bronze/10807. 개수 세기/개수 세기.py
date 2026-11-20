N = int(input())
List = list(map(int, input().split()))
T = int(input())
Result = 0

for i in range(N):
    if List[i] == T:
        Result += 1
print(Result)