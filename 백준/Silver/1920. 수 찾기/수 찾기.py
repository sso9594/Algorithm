import sys
input = sys.stdin.readline

n = int(input())
arr = set(map(int, input().split()))
m = int(input())
targets = list(map(int, input().split()))

for target in targets:
    if target in arr:
        print(1)
    else:
        print(0)
