import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int[][] dp = new int[N][N];

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } //end input

        dp[0][0] = map[0][0];

        for(int n=1;n<N;n++) {
            dp[n][0] = Math.min(dp[n-1][0], map[n][0]);
            dp[0][n] = Math.min(dp[0][n-1], map[0][n]);
        } //end init

        for(int i=1;i<N;i++) {
            for(int j=1;j<N;j++) {
                dp[i][j] = Math.min(Math.max(dp[i-1][j], dp[i][j-1]), map[i][j]);
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}