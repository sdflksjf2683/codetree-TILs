import java.util.*;
import java.io.*;

public class Main {

    static int N;

    static boolean[] visit;
    
    static int[][] dp;

    static ArrayList<Integer>[] tree;

    static void dfs(int tmp) {
        for(int next: tree[tmp]) {
            if(visit[next]) continue;

            visit[next] = true;
            dfs(next);
        }

        dp[tmp][0] = 0; //물건을 두지 않는 경우 기본값은 0
        dp[tmp][1] = 1; //물건을 두는 경우 기본값은 1

        for(int next: tree[tmp]) {

            dp[tmp][0] += dp[next][1]; //간선을 이루는 두 노드 중 한 노드엔 반드시 물건을 두어야 함.
            dp[tmp][1] += Math.min(dp[next][0], dp[next][1]); //현재 노드에 물건이 있다면 연결된 노드의 물건 여부는 중요X
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=1;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            tree[from].add(to);
            tree[to].add(from);
        } //end input

        dp = new int[N+1][2];
        visit = new boolean[N+1];

        visit[1] = true;
        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
}