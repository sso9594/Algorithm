dic = dict()

for _ in range(10):
    k = int(input())
    diff = k % 42
    if diff in dic:
        dic[diff] += 1
    else:
        dic[diff] = 1

print(len(dic))