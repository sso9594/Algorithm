a, b = map(int, input().split())
if b<45:
    a-=1
    b = 60 - 45 + b
else:
    b -= 45
if a<0:
    a = a + 24
print(a, b)
