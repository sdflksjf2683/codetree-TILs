def roll(command):
    global c,r
    if command=="U":
        if r==0:
            return
        r-=1

        tmp = dice[5]
        dice[5] = dice[4]
        dice[4] = dice[0]
        dice[0] = dice[1]
        dice[1] = tmp

        board[r][c] = dice[5]

    elif command=="D":
        if r==n-1:
            return
        r+=1

        tmp = dice[5]
        dice[5] = dice[1]
        dice[1] = dice[0]
        dice[0] = dice[4]
        dice[4] = tmp

        board[r][c] = dice[5]

    elif command=="L":
        if c==0:
            return
        c-=1

        tmp = dice[5]
        dice[5] = dice[3]
        dice[3] = dice[0]
        dice[0] = dice[2]
        dice[2] = tmp

        board[r][c] = dice[5]

    else:
        if c==n-1:
            return
        c+=1

        tmp = dice[5]
        dice[5] = dice[2]
        dice[2] = dice[0]
        dice[0] = dice[3]
        dice[3] = tmp

        board[r][c] = dice[5]


n,m,r,c = map(int, input().split())
r-=1
c-=1

cmd = list(input().split())

board = [[0]*n for _ in range(n)]
dice = list(range(1,7))

#초기 상태
board[r][c] = 6 

for i in range(m):
    roll(cmd[i])



ans=0
for i in range(n):
    for j in range(n):
        ans+=board[i][j]

print(ans)