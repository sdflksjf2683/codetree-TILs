import java.util.*;
import java.io.*;

public class Main {

    static int N,K;

    static Queue<int[]> q; //bfs에 사용할 큐

    static int[][] map, result;

    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    static void bfs() {
        int time = 1; //귤이 상하는데 걸리는 시간

        while(!q.isEmpty()) {
            for(int i=0,size=q.size();i<size;i++) { //현재 큐 크기만큼 반복 후 시간 증가
                int ti = q.peek()[0];
                int tj = q.poll()[1];

                for(int d=0;d<4;d++) {
                    int ni = ti+di[d];
                    int nj = tj+dj[d];

                    if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
                    if(map[ni][nj]!=1) continue; //빈칸이나 처음부터 상한 귤인 경우 탐색X
                    if(result[ni][nj]!=0) continue; //이전에 이미 상한 귤도 탐색X

                    result[ni][nj] = time; //상한 시간 기록
                    q.offer(new int[] {ni,nj}); //다음 시간엔 이 위치와 인접한 토마토가 상함
                }
            }
            time++; //시간 증가
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        result = new int[N][N]; //정답을 저장할 배열
        
        q = new LinkedList<>();

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) { //처음부터 비어있던 칸
                    result[i][j] = -1;
                } else if(map[i][j]==2) { //상한 귤 위치부터 탐색 시작
                    q.offer(new int[] {i,j});
                }
            }
        } //end input

        bfs();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(result[i][j]==0) {
                    sb.append(map[i][j]==2?"0 ":"-2 "); //처음부터 상했다면 0을, 끝까지 상하지 않았다면 -2 기록
                } else {
                    sb.append(result[i][j]+" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}