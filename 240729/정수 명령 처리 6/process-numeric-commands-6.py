import heapq
import sys

input = sys.stdin.readline
print = sys.stdout.write

#PriorityQueue 클래스 생성
class PriorityQueue:
    def __init__(self):
        self.items = []
    
    #최댓값이 높은 우선순위를 갖도록 부호 반전 후 저장
    def push(self, item):
        heapq.heappush(self.items, -item)

    def pop(self):
        if self.isEmpty():
            raise Exception("PriorityQueue is empty.")
        
        return -heapq.heappop(self.items)
    
    def size(self):
        return len(self.items)
    
    def top(self):
        if self.isEmpty():
            raise Exception("PriorityQueue is empty.")
        
        return -self.items[0]

    def isEmpty(self):
        return not self.items
    

N = int(input())
pq = PriorityQueue()

for _ in range(N):
    parts = input().rstrip().split()
    cmd = parts[0]

    if cmd=='size':
        print(str(pq.size()))
    
    elif cmd=='pop':
        print(str(pq.pop()))
    
    elif cmd=='empty':
        print('1' if pq.isEmpty() else '0')
    
    elif cmd=='top':
        print(str(pq.top()))
    
    else:
        pq.push(int(parts[1]))
        continue
    
    print('\n')