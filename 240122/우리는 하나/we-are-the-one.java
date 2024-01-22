import java.util.*;
import java.io.*;

public class Main {

    static int N,K,U,D;

    static int[] city;

    static int[][] map,visit;

    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    static void bfs(int si, int sj, int n, int idx) {
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[] {si,sj});
        visit[si][sj]=idx;

        int cnt=1;
        while(!q.isEmpty()) {
            int ti = q.peek()[0];
            int tj = q.poll()[1];

            for(int d=0;d<4;d++) {
                int ni = ti+di[d];
                int nj = tj+dj[d];

                if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
                if(visit[ni][nj]>0) continue;
                
                int height = Math.abs(map[ni][nj]-map[ti][tj]);
                if(height<U || height>D) continue;

                q.offer(new int[] {ni,nj});
                visit[ni][nj] = idx;
                cnt++;
            }
        }

        city[idx] = cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visit = new int[N][N];
        city = new int[N*N+1];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } //end input

        int idx=1;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(visit[i][j]==0) {
                    bfs(i,j,map[i][j],idx);
                    idx++;
                }
            }
        }

        Arrays.sort(city);
        int ans = 0;
        for(int i=N*N,size=i-K;i>size;i--) {
            ans += city[i];
        }

        System.out.println(ans);
    }
}