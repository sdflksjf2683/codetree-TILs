import sys

input = sys.stdin.readline

N,K = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
#end input

#누적합 배열 만들기
prefix = [[0 for _ in range(N+1)] for _ in range(N+1)]
# prefix[1][1] = board[0][0]
# for i in range(1, N):
#     prefix[i][0] = prefix[i-1][0] + board[i][0]

# for j in range(1, N):
#     prefix[0][j] = prefix[0][j-1] + board[0][j-1]

for i in range(1, N+1):
    for j in range(1, N+1):
        prefix[i][j] = prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1]+board[i-1][j-1]

def calc(i, j):
    return prefix[i][j]-prefix[i-K][j]-prefix[i][j-K]+prefix[i-K][j-K]

ans = 0
for i in range(1, N-K+2):
    for j in range(1, N-K+2):
        ans = max(ans,calc(i,j))

print(ans)