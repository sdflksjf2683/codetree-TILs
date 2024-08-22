import sys

input = lambda: sys.stdin.readline().rstrip()

N,M = map(int, input().split())
inputs = [int(input()) for _ in range(M)]

def is_possible(mid):
    return sum(mid//tmp for tmp in inputs)>=N


def search():
    l,r=0,max(inputs)*N
    ans = r

    while l<=r:
        mid = (l+r)//2

        if is_possible(mid):
            ans = mid
            r = mid-1
        else:
            l = mid+1
    

    return ans


print(search())