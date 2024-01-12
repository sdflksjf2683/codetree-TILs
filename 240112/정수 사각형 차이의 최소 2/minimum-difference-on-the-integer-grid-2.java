import java.util.*;
import java.io.*;

public class Main {

    static int N;

    static int[][] map,dp;

    static int solve(int n) {
        for(int i=1;i<N;i++) {
            for(int j=1;j<N;j++) {
                if(map[i][j]<n) continue;
                dp[i][j] = Math.max(Math.min(dp[i-1][j], dp[i][j-1]), map[i][j]);
            }
        }

        return dp[N-1][N-1];
    }

    static void init() {
        for(int i=0;i<N;i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = map[0][0];

        for(int n=1;n<N;n++) {
            dp[n][0] = Math.max(dp[n-1][0], map[n][0]);
            dp[0][n] = Math.max(dp[0][n-1], map[0][n]);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N];

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } //end input

        int ans = Integer.MAX_VALUE;
        //최소값을 정해두고 dp 채워보기
        for(int n=1;n<=100;n++) {
            init();
            int tmp = solve(n);

            ans = Math.min(ans, tmp-n);
        }

        System.out.print(ans);
    }
}