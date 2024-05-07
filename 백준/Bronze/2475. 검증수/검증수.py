arr = list(map(int, input().split()))
arr = [x**2 for x in arr]
result = sum(arr)
print(result%10)