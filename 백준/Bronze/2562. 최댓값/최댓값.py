arr = [int(input()) for _ in range(9)]

count = 0
max = 0

for i in range(len(arr)):
    if arr[i]>max:
        max = arr[i]
        count = i

print(max)
print(count+1)