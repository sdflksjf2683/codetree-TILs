import java.util.*;
import java.io.*;

public class Main {

    static final int INF = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        K*=2; //(c-K)~(c+K) 이므로 범위 크기는 K*2

        int[] candy = new int[INF+1];
        int l=INF; //왼쪽 경계 끝 좌표
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            candy[idx]+=cnt; //한 위치에 여러 바구니가 놓일 수 있으므로 누적해서 더해야 함
            l = Math.min(l, idx);
        } //end input

        int r=l+K>INF?INF:l+K; //오른쪽 경계 끝 좌표(INF를 넘어가는 경우 INF로 보정)
        int ans = 0; //최대 사탕 개수
        for(int i=l;i<=r;i++) {//초기 사탕 개수
            ans += candy[i];
         } 

        int tmp=ans; //현재 사탕의 개수 저장
        while(r<=INF) {
            //왼쪽 포인터 증가
            tmp -= candy[l];
            l++;
            r++; //K범위를 맞추기 위해 r도 한 칸 증가

            if(r>INF) continue;

            tmp+=candy[r];
            ans = Math.max(ans, tmp);
        }

        System.out.println(ans);
    }
}