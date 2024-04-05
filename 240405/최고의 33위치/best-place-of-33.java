import java.util.*;
import java.io.*;

public class Main {

    static int N;

    static int[][] map;

    static int countCoin(int si, int sj) {
        int ei=si+2, ej=sj+2;

        int cnt=0;
        for(int i=si;i<=ei;i++) {
            for(int j=sj;j<=ej;j++) {
                if(map[i][j]==1) cnt++;
            }
        }
        return cnt;
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

        int max=0;
        for(int i=0;i<N;i++) {
            if(i+2>=N) break; //격자가 범위를 벗어나는 경우

            for(int j=0;j<N;j++) {
                if(j+2>=N) break; //격자가 범위를 벗어나는 경우

                max = Math.max(max, countCoin(i,j)); //(i,j)에서 3*3격자를 만들어 동전의 개수를 센 후 최댓값 갱신
            }
        }

        System.out.println(max);
    }
}