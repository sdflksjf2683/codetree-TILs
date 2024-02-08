import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static int[][] arr;

    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[4][N];

        StringTokenizer st;
        for(int i=0;i<4;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } //end input

        map = new HashMap<>();

        int num;
        //등록
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                num = arr[0][i]+arr[1][j];
                map.put(num, map.getOrDefault(num, 0)+1);
            }
        }

        int cnt=0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                num = (arr[2][i]+arr[3][j])*-1;
                cnt += map.getOrDefault(num, 0);
            }
        }

        System.out.println(cnt);

    }
}