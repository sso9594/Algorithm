n = int(input())

for i in range(n+1):
    val = sum(map(int, str(i)))
    val_sum = i + val
    if val_sum==n:
        print(i)
        break
    if i == n:
        print(0)