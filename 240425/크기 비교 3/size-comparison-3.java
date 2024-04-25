import java.io.*;
import java.util.*;

public class Main {

    static int N,M;

    static int[] indegree;

    static ArrayList<Integer>[] graph;

    static String sort() {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //작은 수부터 출력하기 위함. 
        //가장 작은 수부터 정렬 시작
        for(int i=1;i<=N;i++) {
            if(indegree[i]==0) 
                pq.offer(i);
        }

        while(!pq.isEmpty()) {
            int tmp = pq.poll();
            sb.append(tmp+" ");

            for(int next: graph[tmp]) {
                indegree[next]--;
                if(indegree[next]==0) {
                    pq.offer(next);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        } //init

        indegree = new int[N+1];
        for(int m=0;m<M;m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            indegree[b]++;
        }

        System.out.println(sort());
    }
}