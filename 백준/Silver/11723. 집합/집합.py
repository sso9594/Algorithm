# 백준 11723 - 구현 문제
## 이 문제는 시관초과 이슈로 List가 아닌 set으로 문제를 해결해야함
import sys

n = int(input())
input = sys.stdin.readline

arr = set()
result = []

for i in range(n):
    command = input().split()
    if command[0] == 'add':
        arr.add(int(command[1]))
    elif command[0] == 'remove':
        if int(command[1]) in arr:
            arr.remove(int(command[1]))
    elif command[0] == 'check':
        if int(command[1]) in arr:
            print(1)
        else:
            print(0)
    elif command[0] == 'toggle':
        if int(command[1]) in arr:
            arr.remove(int(command[1]))
        else:
            arr.add(int(command[1]))
    elif command[0] == 'all':
        arr = set([k+1 for k in range(20)])
    elif command[0] == 'empty':
        arr = set()