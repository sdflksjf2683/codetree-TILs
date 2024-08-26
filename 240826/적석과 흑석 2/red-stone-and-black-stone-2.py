import sys,heapq
from sortedcontainers import SortedSet

input = lambda: sys.stdin.readline().rstrip()

def main(): 
    C,N = map(int, input().split())
    red_stones = SortedSet() #빨간돌 저장

    for _ in range(C):
        red_stones.add(int(input()))
    
    black_stones = [] #검정돌 저장할 힙
    for _ in range(N):
        a,b = map(int, input().split())
        heapq.heappush(black_stones, (b-a,a,b)) #a,b의 차이를 기준으로 오름차순 정렬
    
    ans = 0
    while black_stones and red_stones: #적석 or 흑석을 모두 소진할 때까지 매칭
        _,a,b = heapq.heappop(black_stones)
        red = red_stones.bisect_right(b)-1

        if red_stones[red]>=a and red>=0:
            red_stones.pop(red)
            ans+=1
    
    print(ans)




if __name__=="__main__":
    main()