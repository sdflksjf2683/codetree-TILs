import java.util.*;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];

        dp[1] = 2;
        if(n==1) {
            System.out.println(dp[n]);
            return;
        }
        dp[2] = 7;
        for(int i=3;i<=n;i++) {
            dp[i] = dp[i-1]*3+1;
        }

        System.out.println(dp[n]);


    }
}