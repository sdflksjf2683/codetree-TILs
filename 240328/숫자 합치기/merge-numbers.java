import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        } //end input

        int sum=0;
        while(pq.size()>1) {
            int tmp = pq.poll() + pq.poll();
            sum += tmp;
            pq.offer(tmp);
        }

        System.out.println(sum);
    }
}