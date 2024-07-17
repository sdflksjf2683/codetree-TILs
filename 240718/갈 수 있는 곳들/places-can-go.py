from collections import deque

n,k = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
visit = [list(False for _ in range(n)) for _ in range(n)]

ans = 0
q = deque()
for _ in range(k):
    i,j = map(int, input().split())
    q.append([i-1,j-1])
    ans+=1
    visit[i-1][j-1] = True

def isPossible(i,j):
    if 0<=i<n and 0<=j<n and visit[i][j]==False and board[i][j]==0:
        return True
    return False

def dfs():
    global ans
    di = [-1,1,0,0]
    dj = [0,0,-1,1]

    while q:
        tmp = q.popleft()
        ti=tmp[0]
        tj=tmp[1]
        
        for d in range(4):
            ni = ti+di[d]
            nj = tj+dj[d]

            if isPossible(ni,nj):
                visit[ni][nj] = True
                ans+=1
                q.append([ni, nj])

dfs()
print(ans)