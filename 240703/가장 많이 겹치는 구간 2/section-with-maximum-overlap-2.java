import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Point> pq = new PriorityQueue<>();
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            pq.offer(new Point(s, 1)); //시작점
            pq.offer(new Point(e, -1)); //끝점
        }

        int ans=0, sum=0;
        while(!pq.isEmpty()) {
            Point tmp = pq.poll();

            sum += tmp.w;

            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }

    static class Point implements Comparable<Point> {
        int idx, w;

        public Point(int idx, int w) {
            this.idx = idx;
            this.w = w;
        }

        @Override
        public int compareTo(Point p) {
            if(this.idx == p.idx) {
                return this.w-p.w;
            }

            return this.idx-p.idx;
        }
    }
}