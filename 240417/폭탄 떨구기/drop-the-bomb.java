import java.util.*;

public class Main {

    static int N,K;

    static int[] dots;

    static boolean isPossible(long mid) { //현재 R값으로 폭탄을 몇 개 사용해야 하는지 카운팅해서 K개 이하인지 판별
        int cnt=1, idx=0;

        for(int i=0;i<N;i++) {
            if(dots[i]-dots[idx] <= mid*2) continue; //아직 범위 안에 있는 경우 

            //범위를 벗어난 경우
            cnt++;
            idx=i; //새로운 위치에 폭탄 두기
        } 

        return cnt<=K;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        dots = new int[N];
        for(int i=0;i<N;i++) {
            dots[i] = sc.nextInt();
        } //end input

        //오름차순으로 정렬
        Arrays.sort(dots);

        long l=0,r=(dots[N-1]-dots[0])/2;
        while(l<=r) {
            long mid = (l+r)/2;

            if(isPossible(mid)) { //폭탄을 더 사용할 수 있는 경우 -> 폭탄 범위 감소
                r = mid-1;
            } else { //폭탄을 너무 많이 사용한 경우 -> 폭탄 범위 증가
                l = mid+1;
            }
        }

        System.out.println(l);
    }
}