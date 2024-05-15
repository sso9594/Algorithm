n = int(input())
arr = list(map(int, input().split()))
sum = 0
arr.sort(reverse = True)
max = arr[0]

for i in range(n):
    arr[i] = arr[i] / max * 100

for num in arr:
    sum += num

print(sum / n)