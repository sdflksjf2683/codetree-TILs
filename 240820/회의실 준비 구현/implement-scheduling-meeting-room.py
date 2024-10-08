import sys, heapq

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
heap = []

for _ in range(N):
    s,e = map(int, input().split())

    #회의 종료 시간 기준 오름차순 정렬
    #끝나는 시간이 동일할 경우 시작 시간이 늦은 것이 높은 우선순위를 가짐(더 많은 회의를 수락하기 위함)
    heapq.heappush(heap, (e,-s))

prev=0 #이전 회의 종료 시간
cnt=0
while heap:
    tmp = heapq.heappop(heap)

    #이전 회의 종료 시간보다 현재 회의 시작 시간이 빠른 경우: 현재 회의는 수락할 수 없음
    if -tmp[1] < prev:
        continue
    
    cnt+=1 #수락한 회의 수 카운팅
    prev = tmp[0] #회의 시작시간 갱신

print(cnt)