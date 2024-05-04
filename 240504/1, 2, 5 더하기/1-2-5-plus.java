import java.util.*;

public class Main {

    static final int MOD = 10_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N+1];
        int[] nums = {1,2,5};

        dp[0] = 1;

        for(int i=1;i<=N;i++) {
            for(int n: nums) {
                if(i-n<0) continue;

                dp[i] = (dp[i]+dp[i-n]) % MOD;
            }
        }

        System.out.println(dp[N]);
    }
}