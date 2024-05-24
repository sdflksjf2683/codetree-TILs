import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] weight = new int[N+1]; //각 보석의 무게 저장 
        int[] value = new int[N+1]; //각 보석의 가치 저장

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        } //end input

        int[][] dp = new int[N+1][M+1];
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                if(weight[i]>j) { //i번째 보석이 무게 j보다 크다면 해당 보석을 담을 수 없음
                    dp[i][j] = dp[i-1][j];
                } else { //담을 수 있다면 가치가 더 큰 경우를 선택
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
                }
            }
        }

        System.out.println(dp[N][M]);

    }
}