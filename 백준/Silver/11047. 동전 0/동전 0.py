n, k = map(int, input().split())

result = 0
data = []

for i in range (n):
    element = int(input())
    data.append(element)
    
data.sort(reverse = True)

for j in data:
    result += k // j
    k %= j

print(result)