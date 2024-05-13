while(1):
    arr = list(map(int, input().split()))
    arr.sort()
    if arr[0]==0 and arr[1]==0 and arr[2]==0:
        break
    else:
        if arr[0]**2 + arr[1]**2 == arr[2]**2:
            print("right")
        else:
            print("wrong")
    