l = int(input())
arr = input()
matrix = 'abcdefghijklmnopqrstuvwxyz'
val = []
sum = 0

for i in arr:
    for j in range(len(matrix)):
        if i == matrix[j]:
            val.append(j+1)

for i in range(len(val)):
    sum += val[i] * (31 ** i)
print(sum)