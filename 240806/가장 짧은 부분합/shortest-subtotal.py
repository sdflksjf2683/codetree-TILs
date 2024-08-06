import sys

input = sys.stdin.readline

N,S = map(int, input().split())
arr = [0]+list(map(int, input().split()))
#end input

tmp,r,ans = 0,0,N
for l in range(1, N+1):
    while r+1<=N and tmp<S:
        tmp += arr[r+1]
        r+=1
    
    if tmp<S:
        break

    # print('완성:',l,' ',r,' ',tmp)
    ans = min(ans, r-l+1)
    
    tmp-=arr[l]


if ans==N:
    print('-1')
else:
    print(ans)