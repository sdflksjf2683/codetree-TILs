import java.util.*;
import java.io.*;

public class Main {

    static int N,M,X;

    static ArrayList<Node>[] graph;

    static int[] dijkstra(int start) {
        //init
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            int tv = pq.peek().v;
            int tw = pq.poll().w;

            if(dist[tv]!=tw) continue;

            for(Node next: graph[tv]) {
                int nv = next.v;
                int nw = tw+next.w;

                if(nw<dist[nv]) {
                    dist[nv] = nw;
                    pq.offer(new Node(nv,nw));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        } //init

        for(int m=0;m<M;m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, w));
        } //end input

        int max = -1;
        int[] returnDist = dijkstra(X); //돌아오는 경로
        for(int i=1;i<=N;i++) {
            System.out.print(returnDist[i]+" ");
        }
        for(int n=1;n<=N;n++) { //N개의 노드에서 X번 노드까지 최단거리를 모두 구해본 후 최댓값 찾기
            int[] dist = dijkstra(n);
            max = Math.max(dist[X]+returnDist[n], max);
        }

        System.out.println(max);
    }

    static class Node implements Comparable<Node> {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node n) { //소요 시간을 기준으로 오름차순 정렬
            return this.w-n.w;
        }
    }
}