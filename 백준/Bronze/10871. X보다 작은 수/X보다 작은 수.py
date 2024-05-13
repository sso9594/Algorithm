n, x = map(int, input().split())
arr = list(map(int, input().split()))

for num in arr:
    if(num<x):
        print(num, end=' ')