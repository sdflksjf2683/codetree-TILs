import java.util.*;
import java.io.*;

public class Main {

    static int N,bomb,max;

    static int[][] map;
    static boolean[][] visit;

    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    static void bfs(int si, int sj, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {si,sj});

        visit[si][sj] = true;

        int cnt=1;
        while(!q.isEmpty()) {
            int ti = q.peek()[0];
            int tj = q.poll()[1];

            for(int d=0;d<4;d++) {
                int ni = ti+di[d];
                int nj = tj+dj[d];

                if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
                if(visit[ni][nj] || map[ni][nj]!=n) continue;

                visit[ni][nj] = true;
                q.offer(new int[] {ni,nj});
                cnt++;
            }
        }

        if(cnt>=4) {
            bomb++;
        }

        max = Math.max(max, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } //end input

        max=0;
        bomb=0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(!visit[i][j]) {
                    bfs(i,j,map[i][j]);
                }
            }
        }

        System.out.println(bomb+" "+max);
    }
}