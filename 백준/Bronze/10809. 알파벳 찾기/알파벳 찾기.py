inp = input()
arr = [-1] * 26
count = 0
for word in inp:
    if(arr[ord(word)-97] != -1):
        count+=1
        continue
    arr[ord(word)-97] = count
    count+=1
for i in range(len(arr)):
    print(arr[i], end=' ')