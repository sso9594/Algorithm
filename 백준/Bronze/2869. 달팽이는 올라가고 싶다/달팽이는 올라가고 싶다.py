a, b, v = map(int, input().split())

result = 0

if a >= v:
    print(1)
elif (v - a) % (a - b) == 0:
    result = ((v - a) // (a - b)) + 1
    print(int(result))
else:
    result = ((v - a) // (a - b)) + 2
    print(int(result))