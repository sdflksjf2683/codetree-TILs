import java.util.*;
import java.io.*;

public class Main {

    static int N, cnt;

    static int[][] map;

    static ArrayList<Integer> villages; //각 마을 내 사람 수를 저장할 리스트

    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    static void dfs(int ti, int tj) {
        map[ti][tj] = 0; //방문표시
        cnt++; //인원 수 추가

        for(int d=0;d<4;d++) {
            int ni = ti+di[d];
            int nj = tj+dj[d];

            if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
            if(map[ni][nj]==0) continue;

            //4방향 탐색 중 사람을 발견하면 추가 탐색
            dfs(ni,nj);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } //end input

        villages = new ArrayList<>();

        //모든 마을을 탐색하며 사람을 발견하면 해당 사람이 있는 마을 내 사람 수 탐색
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j]==1) {
                    cnt=0; //현재 마을의 사람 수를 저장할 변수
                    dfs(i,j);
                    villages.add(cnt); //탐색을 완료했다면 현재 마을 내 사람 수를 리스트에 저장
                }
            }
        }

        Collections.sort(villages); //오름차순 정렬
        System.out.println(villages.size()); //마을 개수 출력
        for(int v: villages) { //마을 내 사람 수 출력
            System.out.println(v);
        }
    }
}