from collections import deque

dq = deque()

n = int(input())

for _ in range(n):
    cmd = input()
    if cmd.startswith("pop_front"):
        print(dq.popleft())
    elif cmd.startswith("front"):
        tmp = dq.popleft()
        dq.appendleft(tmp)
        print(tmp)
    elif cmd.startswith("pop_back"):
        print(dq.pop())
    elif cmd.startswith("back"):
        tmp = dq.pop()
        dq.append(tmp)
        print(tmp)
    elif cmd.startswith("size"):
        print(len(dq))
    elif cmd.startswith("empty"):
        if len(dq)>0:
            print(0)
        else:
            print(1)
    else:
        op,num = cmd.split()
        if op.startswith("push_back"):
            dq.append(num)
        else:
            dq.appendleft(num)