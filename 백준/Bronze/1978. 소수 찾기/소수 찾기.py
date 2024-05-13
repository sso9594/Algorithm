import math

def is_prime(num):
    if num<2:
        return False
    for j in range(2, int(math.sqrt(target))+1):
        if target % j == 0:
            return False
    return True

n = int(input())
arr = list(map(int,input().split()))
count = 0

for i in range(n):
    target = arr[i]
    if is_prime(target) == True:
        count += 1

print(count)

