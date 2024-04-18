import java.util.*;
import java.io.*;

public class Main {

    static final int INF = (int)1e9;

    static int N,M;

    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1][N+1];
        for(int i=1;i<=N;i++) { //init
            for(int j=1;j<=N;j++) {
                dist[i][j] = INF;
            }

            dist[i][i] = 0;
        } 

        for(int m=0;m<M;m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist[from][to] = Math.min(dist[from][to], w); //간선이 중복일 경우 더 적은 가중치 저장
        } //end input

        for(int k=1;k<=N;k++) {
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(dist[i][j]==INF) sb.append("-1 ");
                else sb.append(dist[i][j]+" ");
            }
            sb.append("\n");
        } 

        System.out.println(sb.toString());
    }
}