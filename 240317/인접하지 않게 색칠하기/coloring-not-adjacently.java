import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_K = 10;
    public static final int MAX_N = 100000;
    
    public static int n, k;
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] a = new int[MAX_N + 1];
    public static int[][][] dp = new int[MAX_N + 1][MAX_K + 1][2];
    public static int ans;
    
    public static void dfs(int x) {
        dp[x][1][1] = a[x];
        dp[x][0][0] = 0;
    
        for(int l = 0; l < edges[x].size(); l++) {
            int y = edges[x].get(l);
    
            if(visited[y]) 
                continue;
    
            visited[y] = true;
            dfs(y);

            for(int i = k; i >= 1; i--)
                for(int j = 1; j <= i; j++)
                    dp[x][i][1] = Math.max(dp[x][i][1], dp[x][i - j][1] + dp[y][j][0]);

            for(int i = k; i >= 0; i--)
                for(int j = 0; j <= i; j++)
                    dp[x][i][0] = Math.max(dp[x][i][0], 
                                           dp[x][i - j][0] + 
                                           Math.max(dp[y][j][0], dp[y][j][1]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();

        for(int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            edges[x].add(y);
            edges[y].add(x);
        }

        for(int i = 1; i <= n; i++)
            a[i] = sc.nextInt();

        k = sc.nextInt();

        visited[1] = true;
        dfs(1);


        for(int i = 1; i <= k; i++) {
            ans = Math.max(ans, dp[1][i][0]);
            ans = Math.max(ans, dp[1][i][1]);
        }

        System.out.print(ans);
    }
}