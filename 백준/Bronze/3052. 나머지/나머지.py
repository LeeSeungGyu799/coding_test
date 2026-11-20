import sys
List = [int(sys.stdin.readline()) for i in range(10)]
Set = set([List[i] % 42 for i in range(10)])
print(len(Set))