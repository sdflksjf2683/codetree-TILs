import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static int[] parent;
    static boolean[] visit;

    static ArrayList<Integer>[] list;

    static void find(int tmp) {
        for(int node: list[tmp]) { //현재 노드와 연결된 모든 노드 탐색
            if(visit[node]) continue; //중복 탐색 방지

            visit[node] = true;
            parent[node] = tmp;

            find(node); //재귀호출을 통해 부모-자식 관계 탐색
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=1;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            //연결된 노드는 양방향으로 저장
            list[to].add(from);
            list[from].add(to);
        } //end input

        parent = new int[N+1];
        visit = new boolean[N+1];

        parent[1] = 1;//1번은 루트노드
        visit[1] = true; 

        find(1); //루트노드부터 탐색 시작

        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=N;i++) {
            sb.append(parent[i]+"\n");
        }

        System.out.println(sb.toString());
    }
}