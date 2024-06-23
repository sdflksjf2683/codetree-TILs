import java.util.*;
import java.io.*;

public class Main {

    static final int INF = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } //end input

        int[][] dp = new int[N+1][K+1];
        for(int i=1;i<=N;i++) {
            Arrays.fill(dp[i], INF);
        }

        int ans = INF;
        for(int i=1;i<=N;i++) {
            if(arr[i]>=0) {
                for(int j=0;j<=K;j++) {
                    dp[i][j] = Math.max(dp[i-1][j]+arr[i], arr[i]);
                    ans = Math.max(ans, dp[i][j]);
                }
            } else {
                for(int j=0;j<K;j++) {
                    dp[i][j+1] = Math.max(dp[i-1][j]+arr[i], arr[i]);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        System.out.println(ans);
    }
}