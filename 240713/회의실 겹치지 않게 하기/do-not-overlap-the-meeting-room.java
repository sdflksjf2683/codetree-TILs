import java.util.*;
import java.io.*;

public class Main {

    static int N;

    static PriorityQueue<Meeting> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>();
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            pq.offer(new Meeting(s,e));
        } //end input

        int cnt=0,prev=pq.poll().e; //cnt=제외할 회의 개수, prev=직전 회의 종료 시간
        while(!pq.isEmpty()) {
            Meeting tmp = pq.poll();

            //직전 회의 종료 시간이 현재 회의 시작시간보다 늦는 경우
            //현재 회의는 포기해야 한다(회의 진행 불가능)
            if(tmp.s<prev) {
                cnt++;
                continue;
            }

            //회의 진행이 가능할 경우
            //회의 종료 시간 갱신
            prev = tmp.e;
        }

        System.out.println(cnt);
    }

    static class Meeting implements Comparable<Meeting> {
        int s,e;

        public Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Meeting m) {
            if(this.e==m.e) { //종료 시간이 같다면 시작 시간이 빠른 회의가 높은 우선순위를 가짐
                return this.s-m.s;
            }

            return this.e-m.e; //종료 시간이 더 빠른 회의가 높은 우선순위를 가짐
        }
    }
}