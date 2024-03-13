import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static int[] dp;

    static ArrayList<Integer>[] tree;

    static void dfs(int tmp) {
        
        for(int next: tree[tmp]) { //자식노드 모두 순회
            dfs(next);
        }

        for(int next: tree[tmp]) {
            if(dp[next]>0) {
                dp[tmp] += dp[next];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        dp = new int[N+1];
        tree = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int n=2;n<=N;n++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if(t==0) a*=-1;

            dp[n]=a;

            tree[p].add(n);
        } //end input

        dfs(1);
        System.out.println(dp[1]);

    }
}