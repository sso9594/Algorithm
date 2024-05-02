data = list(map(int, input().split()))
data_sort = sorted(data)
data_reverse = sorted(data,reverse=True)

if data == data_sort:
    print("ascending")
elif data == data_reverse:
    print("descending")
else:
    print("mixed")
