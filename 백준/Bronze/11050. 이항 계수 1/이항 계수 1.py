n, k = map(int, input().split())

a = 1
b = 1
c = 1

for i in range(n, 1, -1):
    a *= i
for i in range(n-k, 1, -1):
    c *= i  
for i in range(k, 1, -1):
    b *= i
    
print(int(a // (c * b)))