import java.io.*;
import java.util.*;

public class Main {

    static int N,K,ans;

    static int[] bombchoice;
    static int[][] map;

    static List<int[]> bomblist;

    static int[][][] pos = {{{-1,0},{-2,0},{1,0},{2,0}},{{-1,0},{0,1},{1,0},{0,-1}},{{-1,-1},{-1,1},{1,-1},{1,1}}};

    static void bomb() {
        boolean[][] check = new boolean[N][N];
        int cnt=0;

        for(int i=0;i<K;i++) {
            int[] tmp = bomblist.get(i);

            int ti = tmp[0];
            int tj = tmp[1];
            int bnum = bombchoice[i];

            for(int d=0;d<4;d++) {
                int ni = ti+pos[bnum][d][0];
                int nj = tj+pos[bnum][d][1];

                if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
                if(map[ni][nj]==1 || check[ni][nj]) continue;

                check[ni][nj] = true;
                cnt++;
            }
        }

        ans = Math.max(cnt,ans);
    }

    static void comb(int cnt, int idx) {
        if(cnt==K) {
            bomb();
            return;
        }

        for(int i=idx;i<3;i++) {
            bombchoice[cnt] = i;
            comb(cnt+1, idx);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        bomblist = new ArrayList<>();

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) {
                    bomblist.add(new int[] {i,j});
                }
            }
        } //end input

        K = bomblist.size();
        bombchoice = new int[K];
        ans = 0;

        comb(0,0);
        System.out.println(ans+K);
    }
}