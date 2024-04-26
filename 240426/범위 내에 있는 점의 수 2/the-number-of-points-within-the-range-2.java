import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] dots = new int[1_000_001];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int n = Integer.parseInt(st.nextToken());
            dots[n] = 1;
        } 

        //배열에 점 개수 누적합 구해두기
        for(int i=1;i<=1_000_000;i++) {
            dots[i] = dots[i]+dots[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for(int q=0;q<Q;q++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int cnt=0;
            if(a==0) { 
                if(dots[0]==1) { //0번째에 점이 있다면 포함시켜줘야 함.
                    cnt=dots[b]-dots[a]+1;
                } else {
                    cnt=dots[b]-dots[0];
                }
            } else {
                cnt=dots[b]-dots[a-1];
            }

            sb.append(cnt+"\n");
        }

        System.out.println(sb.toString());
    }
}