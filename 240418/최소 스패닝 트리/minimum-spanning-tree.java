import java.util.*;
import java.io.*;

public class Main {

    static int N,M;

    static int[] parent;

    static int find(int x) {
        if(parent[x]==x)
            return x;
        
        return find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a!=b) {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=1;i<=N;i++) { //init
            parent[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int m=0;m<M;m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.offer(new Node(a, b, w));
        }

        int ans=0, cnt=0;
        while(!pq.isEmpty()) {
            Node tmp = pq.poll();

            if(find(tmp.a)!=find(tmp.b)) {
                ans += tmp.w;
                union(tmp.a, tmp.b);
                cnt++;
            }

            if(cnt==N-1) break;
        }

        System.out.println(ans);
    }

    static class Node implements Comparable<Node> {
        int a, b, w;

        public Node(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Node n) {
            return this.w-n.w;
        }
    }
}