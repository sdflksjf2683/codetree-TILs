import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Bomb[] blist = new Bomb[N];

        for(int i=0;i<N;i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();

            blist[i] = new Bomb(time, score);
        } //end input

        Arrays.sort(blist, 0, N); //시간을 기준으로 오름차순 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>();//해체 가능한 폭탄 중 점수가 큰 폭탄 선택
        int bidx=N-1, ans=0;
        for(int T=10000;T>=1;T--) { //최대 시간부터 역순으로 폭탄 해체
            //해체 가능한 폭탄을 모두 큐에 담기
            while(bidx>=0 && blist[bidx].time>=T) {
                pq.offer(-blist[bidx].score);
                bidx--;
            }

            if(!pq.isEmpty()) {
                ans += -pq.poll();
            }
        }

        System.out.println(ans);
    }

    static class Bomb implements Comparable<Bomb> {
        int time, score;

        public Bomb(int time, int score) {
            this.time = time;
            this.score = score;
        }

        @Override
        public int compareTo(Bomb o) { 
            if(this.time==o.time) {
                return this.score-o.score;
            }

            return this.time-o.time;
        }
    }
}