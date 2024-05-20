n = int(input())
arr = []

for _ in range(n):
    age, name = map(str, input().split())
    age = int(age)
    arr.append((age, name))
arr = sorted(arr, key = lambda x : x[0])

for i in range(n):
    print(arr[i][0], arr[i][1])