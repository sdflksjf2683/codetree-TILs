import sys

input = sys.stdin.readline

N,K = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
#end input

#누적합 배열 만들기
prefix = [[0 for _ in range(N+1)] for _ in range(N+1)]
for i in range(1, N+1):
    for j in range(1, N+1):
        prefix[i][j] = prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1]+board[i-1][j-1]


#K*K 크기의 사각형으로 만드는 값 중 가장 큰 값 찾기
ans = 0
for i in range(K, N+1):
    for j in range(K, N+1):
        tmp = prefix[i][j] - prefix[i-K][j] - prefix[i][j-K] + prefix[i-K][j-K]
        ans = max(ans, tmp)

print(ans)