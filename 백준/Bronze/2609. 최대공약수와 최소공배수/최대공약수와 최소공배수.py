n, m = map(int, input().split())

gcd_val = 0
lcm_val = 0

def gcd(n, m):
    for i in range(1, n+1):
        if n % i==0 and m % i ==0:
            gcd_val = i
    return gcd_val

def lcm(n, m):
    for i in range(1, n*m):
        if i % n == 0 and i % m == 0:
            return i
    return n * m

print(gcd(n, m))   
print(lcm(n, m)) 