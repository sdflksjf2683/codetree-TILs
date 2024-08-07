import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
arr = list(map(int, input().split()))

check = [0] * 100001 #구간 내 존재하는 숫자 개수를 저장하는 배열

l,r = 0,0
ans = 1 #최소 구간 크기=1

while r<N:
    if check[arr[r]]==0:
        check[arr[r]]+=1
        ans = max(ans, r-l+1)
        r+=1
    else:
        check[arr[l]]-=1
        l+=1
    
print(ans)