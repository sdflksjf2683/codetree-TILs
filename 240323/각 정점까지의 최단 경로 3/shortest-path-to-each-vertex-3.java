import java.util.*;
import java.io.*;

public class Main {

    static final int INF=(int)1e9;

    static int N,M;

    static int[] dist;

    static ArrayList<Node>[] graph;

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(1,0)); //1번 노드에서 시작
        dist[1] = 0;

        while(!pq.isEmpty()) {
            int tmpv = pq.peek().v;
            int tmpw = pq.poll().w;

            if(tmpw!=dist[tmpv]) continue;

            for(Node next: graph[tmpv]) {
                int nextv = next.v;
                int nextw = next.w;

                int newdist = dist[tmpv]+nextw;
                if(dist[nextv]>newdist) {
                    dist[nextv] = newdist;
                    pq.offer(new Node(nextv, newdist));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, w));
        } //end input

        dist = new int[N+1];
        Arrays.fill(dist, INF);

        dijkstra();

        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=N;i++) {
            if(dist[i]==INF) sb.append("-1\n");
            else sb.append(dist[i]+"\n");
        }

        System.out.println(sb.toString());
    }

    static class Node implements Comparable<Node> {
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w-o.w;
        }
    }
}