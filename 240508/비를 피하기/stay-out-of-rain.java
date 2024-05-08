import java.util.*;
import java.io.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    static int N, H, M;

    static int[][] map,result;

    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    static void bfs(int si, int sj) {
        Queue<Human> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];

        q.offer(new Human(si, sj, 0));//시작: 0초 경과
        visit[si][sj] = true;

        int min = INF; //최소 이동시간 저장

        while(!q.isEmpty()) {
            Human tmp = q.poll();
            int ti = tmp.i;
            int tj = tmp.j;

            if(map[ti][tj]==3) { //지붕에 도착
                min = Math.min(tmp.cnt, min);
                continue;
            }

            for(int d=0;d<4;d++) {
                int ni = ti+di[d];
                int nj = tj+dj[d];

                if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
                if(visit[ni][nj] || map[ni][nj]==1) continue;

                q.offer(new Human(ni,nj,tmp.cnt+1));
                visit[ni][nj] = true;
            }
        }

        result[si][sj] = min==INF?-1:min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        result = new int[N][N]; //결과를 저장할 배열

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } //end input

        //맵에 있는 사람을 발견하면 bfs를 통해 지붕 찾기
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j]==2) {
                    bfs(i,j);
                }
            }
        }

        //print
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                sb.append(result[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static class Human {
        int i,j,cnt;
        public Human(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }
}