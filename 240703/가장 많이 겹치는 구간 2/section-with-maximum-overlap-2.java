import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[100_001]; 
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s]++;
            arr[e]--;
        }

        long ans=0, sum=0;
        for(int i=1;i<=100_000;i++) {
            sum+=arr[i];
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}