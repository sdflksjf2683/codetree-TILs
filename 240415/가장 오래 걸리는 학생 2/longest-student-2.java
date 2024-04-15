import java.util.*;
import java.io.*;

public class Main {

    static final int INF=(int)1e9;

    static int N,M;

    static int[] dist;

    static ArrayList<Node>[] graph;

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        //N번 노드(학교)에서 시작
        pq.offer(new Node(N, 0));
        dist[N] = 0;

        while(!pq.isEmpty()) {
            int tmpv = pq.peek().v;
            int tmpw = pq.poll().w;

            if(dist[tmpv]!=tmpw) continue;

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
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int m=0;m<M;m++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            //간선 정보를 뒤집어서 저장
            graph[to].add(new Node(from, d));
        } //end input

        dist = new int[N+1];
        Arrays.fill(dist, INF);

        //학교가 있는 N번 노드에서 모든 노드로의 최단거리 구하기
        dijkstra();

        //가장 오래 걸리는 거리 구하기
        int ans=0;
        for(int i=1;i<N;i++) {
            if(dist[i]==INF) continue;
            ans = Math.max(ans, dist[i]);
        }

        System.out.println(ans);
    }

    static class Node implements Comparable<Node> {
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node n) {
            return this.w-n.w;
        }
    }
}