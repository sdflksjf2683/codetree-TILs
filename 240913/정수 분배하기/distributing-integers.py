import sys

input = lambda: sys.stdin.readline().rstrip()

#분배가 가능한지 판별하는 함수
def is_possible(m,arr,k):
    cnt=0
    for num in arr:
        cnt += (num//k)
    
    if cnt>=m:
        return True

    return False

def main():
    n,m = map(int, input().split())
    
    arr = []
    r = 0
    for _ in range(n):
        tmp = int(input())
        arr.append(tmp)
        r = max(r,tmp)
    
    #[0~배열내 가장 큰 수] 범위에서 가장 큰 k값 찾기
    k,l = 0,0
    while l<=r:
        mid = (l+r)//2

        if mid>0 and is_possible(m,arr,mid):
            #k=mid일 때 m개를 만드는 분배가 가능한 경우
            k = mid
            l = mid+1
        else:
            r = mid-1
    
    print(k)

    

if __name__ == "__main__":
    main()