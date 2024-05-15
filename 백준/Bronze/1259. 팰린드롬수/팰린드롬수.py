while(1):
    n = input()
    if n == '0':
        break
    temp = n[::-1]
    if temp == n:
        print("yes")
    else:
        print("no")