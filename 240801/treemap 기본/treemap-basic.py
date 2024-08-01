import sys
from sortedcontainers import SortedDict

input = sys.stdin.readline

sd = SortedDict()
N = int(input())

for _ in range(N):
    cmd = list(input().split())

    if cmd[0]=='add':
        #(k,v) 추가, 동일한 k가 있다면 덮어씌우기
        sd[int(cmd[1])] = cmd[2]
    elif cmd[0]=='find':
        #있으면 value 출력, 없으면 None
        if int(cmd[1]) not in sd:
            print('None')
        else :
            print(sd[int(cmd[1])])
    elif cmd[0]=='remove':
        #제거
        sd.pop(int(cmd[1]))
    else:
        #key 기준으로 오름차순 정렬해서 각 value들만 공백을 두고 출력
        res=''
        for k, v in sd.items():
            res+=(v+' ')
        
        if res=='':
            print('None')
        else:
            print(res)