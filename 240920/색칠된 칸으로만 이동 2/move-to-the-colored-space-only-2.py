import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()

m,n=0,0
MAX = 10**9
board = []
visit = []
colored_board = []
blocks = list() #색칠된 블록 위치를 저장할 리스트
dir = [[0,-1],[0,1],[-1,0],[1,0]]

def can_move(ti,tj,ni,nj,mid):
    if 0<=ni<m and 0<=nj<n and not visit[ni][nj]:
        if abs(board[ni][nj]-board[ti][tj]) <= mid:
            return True
    
    return False

def bfs(si,sj,mid):

    global visit

    q = deque([(si,sj)])
    visit[si][sj] = True

    while q:
        ti,tj = q.popleft()

        for di,dj in dir:
            ni,nj = ti+di, tj+dj
            
            if can_move(ti,tj,ni,nj,mid):
                visit[ni][nj] = True
                q.append((ni,nj))


def is_possible(mid):

    global visit
    #방문 배열 초기화
    visit = [[False]*n for _ in range(m)]

    #색칠된 곳 중 한 곳에서 출발 -> 색칠된 모든 블록을 방문했으면 가능한 경우
    si,sj = blocks[0][0], blocks[0][1]
    bfs(si,sj,mid)

    for (bi,bj) in blocks:
        if not visit[bi][bj]:
            return False
    
    return True

def main():
    global m,n,board
    
    #input
    m,n = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(m)]
    colored_board = [list(map(int, input().split())) for _ in range(m)]

    for i in range(m):
        for j in range(n):
            if colored_board[i][j]==1:
                blocks.append((i,j))
    
    #이분탐색으로 D값을 가정한 후, 가능한지 테스트 -> 최솟값 찾을 때까지 반복
    l,r = 0,MAX
    ans = MAX
    while l<=r:
        mid = (l+r)//2

        if is_possible(mid):
            ans = min(ans, mid)
            r = mid-1
        else:
            l = mid+1
    
    print(ans)


    





if __name__=="__main__":
    main()