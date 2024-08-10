import sys, heapq

input = lambda: sys.stdin.readline().rstrip()

N,M = map(int, input().split())
heap = [] #보석의 무게당 가치가 큰 순서대로 저장될 힙

for _ in range(N):
    w,v = map(int, input().split())
    tmp = (-v/w, w, v)
    heapq.heappush(heap, tmp)
#end input

vsum, wsum = 0,0 #vsum은 가치의 합, wsum은 무게의 합

#가방을 가득채울때까지 보석을 담기
while heap and wsum<M:
    tup = heapq.heappop(heap)
    w = min(M-wsum, tup[1]) #현재 보석을 모두 담거나, 가방에 여유 공간이 없는 경우 가능한 무게 만큼 잘라 담기
    vsum += -w*tup[0]
    wsum += w

print(f"{vsum:.3f}")