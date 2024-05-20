n = int(input())
temp = 0
arr = []
for _ in range(n):
    a, b = map(int, input().split())
    arr.append((a, b))
# for i in range(n):
#     temp = i
#     for j in range(i+1, n):
#         if arr[j][0] < arr[temp][0]:
#             temp = j
#         elif arr[j][0] == arr[temp][0]:
#             if arr[j][1] <= arr[temp][1]:
#                 temp = j
#     arr[i], arr[temp] = arr[temp], arr[i]
arr.sort(key = lambda x : (x[0],x[1]))

for i in range(n):
    print(arr[i][0], arr[i][1])