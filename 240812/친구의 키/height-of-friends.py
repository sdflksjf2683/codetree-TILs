import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()

N,M = map(int, input().split())
indegree = [0]*(N+1) #진입차수를 관리할 배열
graph = [[] for _ in range(N+1)] #노드 간 정보를 저장할 인접리스트

for _ in range(M):
    a,b = map(int, input().split())
    graph[a].append(b)

    indegree[b]+=1 #진입차수 증가

q = deque() #위상정렬을 위한 큐

#진입차수가 0인 노드부터 탐색 시작
for i in range(1,N+1):
    if not indegree[i]:
        q.append(i)

while q:
    tmp = q.popleft()
    print(tmp, end=' ')

    #현재 노드와 연결된 모든 노드 탐색
    for nxt in graph[tmp]:
        indegree[nxt]-=1 #진입차수 1 감소

        #진입차수가 0이 되었다면 큐에 넣기
        if not indegree[nxt]:
            q.append(nxt)