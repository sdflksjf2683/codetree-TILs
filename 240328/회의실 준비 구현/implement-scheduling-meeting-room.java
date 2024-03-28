import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            pq.offer(new Meeting(s,e));
        } //end input

        //끝나는 시간이 가장 빠른 회의부터 회의실 배정
        int ans=0, lastEndTime=0;
        while(!pq.isEmpty()) {
            Meeting tmp = pq.poll(); //다음 회의

            if(tmp.s>=lastEndTime) { //이전 회의 시간과 겹치지 않는 경우
                lastEndTime = tmp.e;
                ans++;
            }
        }

        System.out.println(ans);
    }

    static class Meeting implements Comparable<Meeting> {
        int s,e;
        
        public Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }

        //끝나는 시간 기준 오름차순 정렬
        @Override
        public int compareTo(Meeting m) {
            return this.e-m.e;
        }
    }
}