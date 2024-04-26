import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][N];

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        } //end input

        //floyd-warshall
        for(int k=0;k<N;k++) {
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(i==j) {
                        matrix[i][j] = 1;
                        continue;
                    }

                    if(matrix[i][k]==1 && matrix[k][j]==1) {
                        matrix[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                sb.append(matrix[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}