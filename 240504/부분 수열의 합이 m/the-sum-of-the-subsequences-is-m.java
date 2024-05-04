import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 10_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } //end input

        int[] dp = new int[M+1];
        Arrays.fill(dp, INF);
        dp[0]= 0; //각 원소는 자연수이므로 0을 만들 수 있는 경우 = 0

        for(int tmp: arr) {
            for(int j=M;j>=tmp;j--) { //만들 수 있는 수를 큰 수부터 탐색
                dp[j] = Math.min(dp[j], dp[j-tmp]+1);
            }
        }
        
        System.out.println(dp[M]==INF?-1:dp[M]);
    }
}