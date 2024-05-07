n = int(input())
num = int(input())
arr = []

for _ in range(n):
    temp = num % 10
    arr.append(temp)
    num = num // 10

print(sum(arr))