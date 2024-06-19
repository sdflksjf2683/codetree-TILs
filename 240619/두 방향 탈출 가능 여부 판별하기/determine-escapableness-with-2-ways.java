import java.util.*;
import java.io.*;

public class Main {

    static int N,M,ans;

    static int[][] map;
    static boolean[][] visit;

    static int[] di = {1,0};
    static int[] dj = {0,1};

    static void dfs(int ti, int tj) {
        if(ti==N-1 && tj==M-1) {
            ans = 1;
            return;
        }


        for(int d=0;d<2;d++) {
            int ni = ti+di[d];
            int nj = tj+dj[d];

            if(ni<0 || ni>=N || nj<0 || nj>=M) continue;
            if(map[ni][nj]==0 || visit[ni][nj]) continue;

            visit[ni][nj] = true;
            dfs(ni,nj);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } //end input

        ans = 0;

        visit[0][0] = true;
        dfs(0,0);

        System.out.println(ans);
    }
}