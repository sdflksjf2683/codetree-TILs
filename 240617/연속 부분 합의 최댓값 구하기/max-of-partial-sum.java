import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } //end input

        int[] dp = new int[N+1];
        for(int i=1;i<=N;i++) {
            dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
        }

        System.out.println(dp[N]);
    }
}