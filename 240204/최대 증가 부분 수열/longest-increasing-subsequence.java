import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } //end input

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for(int i=0;i<N;i++) {
            for(int j=0;j<i;j++) {
                if(dp[j]<0) continue;

                if(j+arr[j]>=i) 
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        int max=0;
        for(int i: dp) {
            max = Math.max(max, i);
        }

        System.out.println(max);
    }
}