import java.io.*;
import java.util.*;

public class Main {

    static int N,M,max;

    static int[][] map;

    static int[] di = {-1,1,0,0}; 
    static int[] dj = {0,0,-1,1};

    static int[][] block = {{0,1}, {2,3}, {0,2}, {0,3}, {1,2}, {1,3}}; //0,1=일자모양, 2~5=ㄱ모양

    static void makeBlock(int ti, int tj) {
        int sum;//블록 뒀을 때 값의 합
        boolean flag; //블록이 범위를 벗어났을 경우 true
        for(int b=0;b<6;b++) {
            sum = map[ti][tj]; //초기값 = 가운데 블록 값
            flag = false;
            for(int d=0;d<2;d++) {
                int ni = ti+di[block[b][d]];
                int nj = tj+dj[block[b][d]];

                if(ni<0 || ni>=N || nj<0 || nj>=M) {
                    flag = true;
                    break;
                }
                sum += map[ni][nj];
            }
            if(flag) continue; //블록이 경계 넘어가면 최댓값 갱신X

            max = Math.max(max, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } //end input

        max = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                makeBlock(i,j); //(i,j)를 중심으로 블록 둬보기
            }
        }

        System.out.println(max);
    }
}