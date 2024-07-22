n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
dp = [[0 for _ in range(n)] for _ in range(n)]


#dp 배열을 초기화하는 함수
def initialiize():
    dp[0][0] = board[0][0]

    #아래로 이동해서만 접근 가능한 열(0열) 초기화
    for i in range(1, n):
        dp[i][0] = dp[i-1][0]+board[i][0]
    
    #오른쪽으로 이동해서만 접근 가능한 행(0행) 초기화
    for j in range(1, n):
        dp[0][j] = dp[0][j-1]+board[0][j]


initialiize()

#나머지 dp 배열 채우기
for i in range(1,n):
    for j in range(1,n):
        #위쪽 or 왼쪽에서 이동이 가능하므로 둘 중 최댓값을 선택한다
        dp[i][j] = max(dp[i-1][j], dp[i][j-1])+board[i][j]

print(dp[n-1][n-1])