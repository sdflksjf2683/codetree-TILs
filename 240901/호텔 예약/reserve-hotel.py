import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
guest = []

for _ in range(N):
    s,e = map(int, input().split())
    guest.append((s, 1))
    guest.append((e+1, -1))

guest.sort()

tmp_sum = 0
ans = 0
for g in guest:
    tmp_sum += g[1]
    ans = max(ans, tmp_sum)

print(ans)