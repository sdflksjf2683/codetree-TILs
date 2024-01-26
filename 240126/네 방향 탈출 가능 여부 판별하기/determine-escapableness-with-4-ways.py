import sys
from collections import deque
input = sys.stdin.readline

def bfs(i,j) :
    q = deque([(i,j)])
    visit = [[0]*m for _ in range(n)]
    visit[i][j] = 1

    while q:
        ti,tj = q.popleft()

        if ti==(n-1) and tj==(m-1):
            return 1
        
        for d in range(4):
            ni = ti+di[d]
            nj = tj+dj[d]

            if 0<=ni<n and 0<=nj<m:
                if board[ni][nj]==1 and visit[ni][nj]==0:
                    q.append((ni,nj))
                    visit[ni][nj] = 1
    
    return 0





n,m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

di = [-1,1,0,0]
dj = [0,0,-1,1]


print(bfs(0,0))