n = int(input())

lst = list()

for _ in range(n):
    cmd = input()
    if cmd.startswith("size"):
        print(len(lst))
    elif cmd.startswith("pop_back"):
        lst.pop()
    else:
        op,num = cmd.split()
        if op == 'push_back':
            lst.append(int(num))
        else:
            print(lst[int(num)-1])