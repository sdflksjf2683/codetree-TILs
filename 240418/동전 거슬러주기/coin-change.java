import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] coins = new int[N];
        for(int i=0;i<N;i++) {
            coins[i] = sc.nextInt();
        } //end input

        int[] dp = new int[M+1]; //금액 i를 만드는 데 필요한 동전의 개수
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int i=1;i<=M;i++) { 
            for(int coin: coins) { //모든 동전을 사용하는 경우 체크
                if(i<coin) continue; //현재 동전을 사용해도 i를 만들지 못하는 경우
                if(dp[i-coin]==INF) continue; //현재 동전을 사용할 수 없는 경우

                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }

        System.out.println(dp[M]==INF?-1:dp[M]);
    }
}