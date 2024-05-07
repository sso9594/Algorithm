n = int(input())
for _ in range(n):
    h, w, k = map(int,input().split())
    resultH = k % h
    resultW = k // h
    if resultH == 0:
        resultH = h
        resultW -= 1
    print(100 * resultH + resultW + 1)