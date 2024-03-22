import java.util.*;
import java.io.*;

public class Main {

    static int N,T;
    static int[] dlist;

    static boolean isPossible(int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //초기에 무대 세팅(k명 올리기)
        for(int i=0;i<k;i++) {
            pq.offer(dlist[i]);
        }

        for(int i=k;i<N;i++) {
            int tmp = pq.poll(); //빠진 사람
            pq.offer(tmp+dlist[i]); //빠진 사람 다음에 무대에 서게 됨
        }

        //마지막 사람만 남겨두고 모두 제거
        for(int i=0,size=pq.size();i<size-1;i++) {
            pq.poll();
        }
        
        return pq.poll()<=T; //마지막으로 꺼낸 시간이 T이하인지 결과 리턴
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        dlist = new int[N];
        for(int i=0;i<N;i++) {
            dlist[i] = Integer.parseInt(br.readLine());
        } //end input

        int l=1,r=N;
        int k=N;

        while(l<=r) {
            int mid = (l+r)/2;
            if(isPossible(mid)) {
                k = Math.min(k,mid);
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        System.out.println(k);
    }
}