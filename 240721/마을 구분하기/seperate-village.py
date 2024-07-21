from collections import deque

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

villages = [] #마을 내 사람 수를 저장할 리스트

di = [-1,1,0,0]
dj = [0,0,-1,1]

def bfs(si,sj):
    q=deque()
    q.append([si,sj])

    board[si][sj] = 0 #방문표시
    cnt=1 #마을 내 사람 수

    while q:
        tmp = q.popleft()
        ti = tmp[0]
        tj = tmp[1]

        for d in range(4):
            ni = ti+di[d]
            nj = tj+dj[d]

            if 0<=ni<n and 0<=nj<n and board[ni][nj]==1:
                board[ni][nj] = 0
                q.append([ni,nj])
                cnt+=1
    
    #마을 탐색을 완료했다면 사람 수 저장
    villages.append(cnt)
        


for i in range(n):
    for j in range(n):
        if board[i][j]==1:
            bfs(i,j)

villages.sort(reverse=True)
print(len(villages))

while villages:
    print(villages.pop())