A, B, C = map(int, input().split())

if A != B:
    if A != C:
        if B != C:  # x
            P = max(A, B, C) * 100
        else:  # bc
            P = B * 100 + 1000
    else:  # ac
        P = A * 100 + 1000
else:
    if A != C:  # ab
        P = A * 100 + 1000
    else:  # abc
        P = A * 1000 + 10000

print(P)
