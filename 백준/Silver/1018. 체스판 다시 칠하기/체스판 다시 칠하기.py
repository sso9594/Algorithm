## 완전탐색 - 브루트포스 알고리즘
n, m = map(int, input().split())

arr = [input() for _ in range(n)]

min_paint = float('inf')

for i in range(n-7):
    for j in range(m-7):
        count_w = 0
        for x in range(i, i+8):
            for y in range(j, j+8):
                if (x+y)%2 ==0:
                    if arr[x][y] != 'W':
                        count_w += 1
                else:
                    if arr[x][y] != 'B':
                        count_w += 1
        count_b = 0
        for x in range(i, i+8):
            for y in range(j, j+8):
                if (x+y)%2 == 0:
                    if arr[x][y] != 'B':
                        count_b += 1
                else:
                    if arr[x][y] != 'W':
                        count_b += 1
        min_paint = min(min_paint, count_w, count_b)

print(min_paint)