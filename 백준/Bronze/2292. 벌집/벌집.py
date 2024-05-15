n = int(input())
sum = 1
if (n == 1):
    print(1)
else:
    for i in range(n+1):
        if n <= sum:
            break
        sum += 6 * i
    print(i)
