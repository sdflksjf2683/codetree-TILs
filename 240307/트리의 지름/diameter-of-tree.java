import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static Node target; //v에는 도착점 노드, w에는 지름 저장

    static boolean[] visit;

    static PriorityQueue<Node>[] tree;

    static void find(int tmp, int dist) {

        if(dist>target.w) {
            target = new Node(tmp, dist);
        }

        for(Node next: tree[tmp]) {
            if(visit[next.v]) continue;

            visit[next.v] = true;
            find(next.v, dist+next.w);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new PriorityQueue[N+1];
        for(int i=1;i<=N;i++) {
            tree[i] = new PriorityQueue<>();
        }

        StringTokenizer st;
        for(int i=1;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[from].offer(new Node(to, w));
            tree[to].offer(new Node(from, w));
        } //end input

        target = new Node(0,0);

        //1. 아무 정점에서 가장 먼 정점 찾기
        visit = new boolean[N+1];
        visit[2] = true;
        find(2, 0);

        //2. 트리의 지름 찾기
        visit = new boolean[N+1];
        visit[target.v] = true;
        find(target.v, 0);

        System.out.println(target.w);
    }

    static class Node implements Comparable<Node> {
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) { //내림차순 정렬(먼 정점을 먼저 선택)
            return o.w-this.w;
        }
    }
}