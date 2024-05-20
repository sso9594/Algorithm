n, k = map(int, input().split())

arr = list(range(1, n+1))
result = []

current = 0

for _ in range(n):
    current = (current + k - 1) % len(arr)
    result.append(arr.pop(current))
    
print("<", end="")
output = ', '.join(map(str, result))
print(output, end="")
print(">")