k,n = map(int, input().split())
ans = []

def perm(cnt):
    if cnt == n:
        print(*ans)
        return
    
    for i in range(1, k+1):
        ans.append(i)
        perm(cnt+1)
        ans.pop()

    return

perm(0)