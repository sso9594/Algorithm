n = int(input())

for _ in range(n):
    q, w = input().split(' ')
    q = int(q)
    
    result = ''.join([char * q for char in w])
    
    print(result)