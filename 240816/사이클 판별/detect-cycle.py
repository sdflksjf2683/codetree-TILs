import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()

N,M = map(int, input().split())

graph = [[] for _ in range(N+1)]
indegree = [0]*(N+1)

for _ in range(M):
    a,b = map(int, input().split())

    graph[a].append(b)
    indegree[b]+=1

q = deque()

for i in range(1, N+1):
    if not indegree[i]:
        q.append(i)

cnt=0#진입차수가 0인 노드 개수를 카운팅하는 변수
while q:
    tmp = q.popleft()
    cnt+=1

    for nxt in graph[tmp]:
        indegree[nxt]-=1
        if not indegree[nxt]:
            q.append(nxt)

if cnt==N:
    print('Not Exists')
else:
    print('Exists')