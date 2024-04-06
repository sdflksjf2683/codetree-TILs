import java.io.*;
import java.util.*;

public class Main {

    static int N,M,ans;

    static int[][] map;

    static void checkCal(int j) {
        int tmp = map[0][j]; //연속되는 숫자 저장
        int cnt=1;//연속되는 횟수 카운트

        for(int i=1;i<N;i++) {
            if(map[i][j]==tmp) { //연속되는 숫자인 경우
                cnt++;
            } else {
                tmp = map[i][j];
                cnt=1;
            }

            if(cnt>=M) { //행복한 수열의 조건을 만족한 경우
                ans++;
                break;
            }
        }
    }

    static void checkRow(int i) {
        int tmp = map[i][0]; //연속되는 숫자 저장
        int cnt=1;//연속되는 횟수 카운트

        for(int j=1;j<N;j++) {
            if(map[i][j]==tmp) { //연속되는 숫자인 경우
                cnt++;
            } else {
                tmp = map[i][j];
                cnt=1;
            }

            if(cnt>=M) { //행복한 수열의 조건을 만족한 경우
                ans++;
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } //end input

        ans=0;
        for(int i=0;i<N;i++) {
            checkRow(i); //0~N-1의 행 검사
            checkCal(i); //0~N-1의 열 검사
        }

        System.out.println(ans);
    }
}