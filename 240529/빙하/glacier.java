import java.util.*;
import java.io.*;

public class Main {

    static int N,M,T,cnt;

    static int[][] map;
    static boolean[][] visit;

    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    static int remove() { //체크한 빙하 녹이기 + 녹인 빙하 개수 리턴
        int tmp = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j]==2) {
                    tmp++;
                    map[i][j]=0;
                }
            }
        }
        return tmp;
    }

    static void find() { //녹일 빙하 탐색 -> 녹일 빙하는 2로 표시
        Queue<int[]> q = new LinkedList<>();
        visit = new boolean[N][M];

        q.offer(new int[] {0,0});

        while(!q.isEmpty()) {
            int ti = q.peek()[0];
            int tj = q.poll()[1];

            visit[ti][tj] = true;

            for(int d=0;d<4;d++) {
                int ni = ti+di[d];
                int nj = tj+dj[d];

                if(ni<0 || ni>=N || nj<0 || nj>=M) continue;

                if(visit[ni][nj]) continue;

                if(map[ni][nj]==0) { //같은 테두리면 계속해서 탐색 진행
                    q.offer(new int[] {ni,nj});
                } else if(map[ni][nj]==1) { //녹일 빙하 발견
                    map[ni][nj] = 2;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = 0; //빙하가 모두 녹는데 걸리는 시간
        cnt = 0; //현재 빙하의 크기

        map = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) {
                    cnt++;
                }
            }
        } //end input

        while(true) {
            T++;

            find(); //녹일 빙하 찾기
            int tmp = remove();//체크해둔 빙하 한 번에 녹이기 + 녹인 빙하 개수 리턴

            tmp = cnt-tmp; //녹인 후 빙하 개수

            if(tmp==0) { //빙하가 모두 녹았다면 종료
                break;
            }
            
            cnt = tmp; //현재까지 진행했을 때 남은 빙하 개수 저장
        }

        System.out.println(T+" "+cnt);
    }
}