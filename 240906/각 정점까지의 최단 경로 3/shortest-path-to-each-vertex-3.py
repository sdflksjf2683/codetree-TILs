import sys
import heapq

INF = int(1e9)

def dijkstra():
    pq = []
    heapq.heappush(pq, (0, 1))  # 1번 노드에서 시작 (거리, 노드)
    dist[1] = 0

    while pq:
        tmpw, tmpv = heapq.heappop(pq)

        if tmpw != dist[tmpv]:
            continue

        for nextv, nextw in graph[tmpv]:
            newdist = dist[tmpv] + nextw
            if dist[nextv] > newdist:
                dist[nextv] = newdist
                heapq.heappush(pq, (newdist, nextv))

if __name__ == "__main__":
    input = sys.stdin.read
    data = input().splitlines()
    
    N, M = map(int, data[0].split())

    graph = [[] for _ in range(N+1)]

    for i in range(1, M+1):
        from_, to, w = map(int, data[i].split())
        graph[from_].append((to, w))  # (목적지, 가중치)

    dist = [INF] * (N+1)

    dijkstra()

    result = []
    for i in range(2, N+1):
        if dist[i] == INF:
            result.append("-1")
        else:
            result.append(str(dist[i]))

    print("\n".join(result))