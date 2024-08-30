import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().rstrip()
map = defaultdict(lambda: 0)

N = int(input())
for _ in range(N):
    tmp = ''.join(sorted(input())) #문자 단위로 잘라 정렬 후, 이어붙여 새로운 문자열 만들기 e.g)bca->abc
    map[tmp] += 1

#가장 많은 그룹의 단어 개수 출력
ans = 0
for v in map.values():
    ans = max(ans, v)

print(ans)