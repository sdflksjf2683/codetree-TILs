import java.util.*;
import java.io.*;

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
        for(int i=0;i<N;i++) {
            int tmp = arr[i];

            for(int j=1;j<=tmp;j++) {
                int next = i+j;
                if(next>=N) break;
                if(i!=0 && dp[i]==0) break;

                dp[next] = Math.max(dp[next], dp[i]+1);
            }
        }

        int max=0;
        for(int i=0;i<N;i++) {
            max = Math.max(max, dp[i]);
        }   

        System.out.println(max);
    }
}