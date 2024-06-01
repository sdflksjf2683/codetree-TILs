import java.util.*;
import java.io.*;

public class Main {

    static int N,K,ans; //N,K,정답

    static int[][] map;

    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    static void bfs(int si, int sj, int ei, int ej) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[][][] visit = new boolean[N][N][K+1];

        pq.offer(new Point(si,sj,0,0));
        visit[si][sj][0] = true;

        while(!pq.isEmpty()) {
            Point tmp = pq.poll();
            int ti = tmp.i;
            int tj = tmp.j;
            int tk = tmp.k;

            if(ti==ei && tj==ej) { //도착점에 도달한 경우
                ans = Math.min(ans, tmp.time); //소요시간의 최솟값 갱신
                continue;
            }

            for(int d=0;d<4;d++) {
                int ni = ti+di[d];
                int nj = tj+dj[d];

                if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
                //똑같은 횟수로 벽을 없애고 같은 위치에 도달한 경우
                //소요시간이 적은 것부터 탐색을 시작하므로 이후 같은 횟수로 벽을 없앴다면 더 많은 시간을 소요한 것.
                if(visit[ni][nj][tk]) continue; 
                if(map[ni][nj]==1) {
                    if(tk==K) continue;//다음 위치가 벽인데 더 이상 없앨 수 없는 경우 진행 불가

                    visit[ni][nj][tk+1]=true; //벽을 없애고 진출
                    pq.offer(new Point(ni,nj,tk+1,tmp.time+1));
                } else {
                    visit[ni][nj][tk]=true; //벽을 없애지 않고 진출
                    pq.offer(new Point(ni,nj,tk,tmp.time+1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //시작 좌표
        st = new StringTokenizer(br.readLine());
        int si = Integer.parseInt(st.nextToken())-1;
        int sj = Integer.parseInt(st.nextToken())-1;
        //도착 좌표
        st = new StringTokenizer(br.readLine());
        int ei = Integer.parseInt(st.nextToken())-1;
        int ej = Integer.parseInt(st.nextToken())-1;

        ans = Integer.MAX_VALUE;
        bfs(si,sj,ei,ej);

        System.out.println(ans==Integer.MAX_VALUE?-1:ans); //도착을 못한 경우엔 -1 출력
    }

    static class Point implements Comparable<Point> {
        int i,j,k,time; //현재 좌표인 i,j와 현재까지 벽을 없앤 횟수 k, 이동 시간 time

        public Point(int i, int j, int k, int time) {
            this.i = i;
            this.j = j;
            this.k = k;
            this.time = time;
        }

        @Override
        public int compareTo(Point p) { //이동시간이 작은 Point 객체가 더 높은 우선순위를 가짐
            return this.time-p.time;
        }
    }
}