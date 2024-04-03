# ## 백준 1931번 문제 - 그리디 알고리즘

n = int(input())
data = []
count = 0

for i in range(n):
    e1, e2 = map(int, input().split())
    data.append([e1,e2])

data.sort(key = lambda x: (x[1], x[0]))
prev_end = 0

for start, end in data:
    if start >= prev_end:
        count+=1
        prev_end = end

print(count)