n = int(input())

for _ in range(n):
    check = 0
    sum = 0
    inp = input()
    for i in range(len(inp)):
        if inp[i]=='O':
            check+=1
            sum+=check
        else:
            check = 0
    print(sum)