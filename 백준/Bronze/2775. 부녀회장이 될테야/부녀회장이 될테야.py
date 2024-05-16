t = int(input())
for _ in range(t):
    k = int(input())
    n = int(input())
    
    arr = [i for i in range(1, n+1)]
    
    for _ in range(k):
        next_arr = []
        sum = 0
        for element in arr:
            sum += element
            next_arr.append(sum)
        arr = next_arr
    print(next_arr[-1])