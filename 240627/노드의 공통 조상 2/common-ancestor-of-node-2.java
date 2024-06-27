import java.util.*;
import java.io.*;

public class Main {

    static int N,H;

    static int[] depth;

    static int[][] parent;

    static ArrayList<Integer>[] graph;

    static int find(int a, int b) { //a,b노드의 LCA를 찾는 함수
        //계산 편의상 a가 더 깊은 노드가 되도록 조정
        if(depth[a]<depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        //a의 높이를 b까지 끌어올려주기
        for(int h=H-1;h>=0;h--) {
            if(depth[a]-depth[b]>=(1<<h)) {
                a = parent[a][h];
            }
        }

        if(a==b) return a; //두 노드 중 하나가 조상노드였을 경우

        //a,b 노드에서 하나씩 올라가며 일치하는 노드를 찾기
        for(int h=H-1;h>=0;h--) {
            if(parent[a][h]!=parent[b][h]) {
                a = parent[a][h];
                b = parent[b][h];
            }
        }

        //a,b노드가 같아지기 직전까지 왔으므로, lca는 a,b 중 한 노드의 부모노드가 된다.
        return parent[a][0];
    }

    static void fillParent() {
        //높이가 0일 때는 이미 구했으므로 해당 값을 이용해 조상 노드를 찾기
        for(int h=1;h<H;h++) {
            for(int n=1;n<=N;n++) {
                parent[n][h] = parent[parent[n][h-1]][h-1];
            }
        }
    }

    static void init(int tmp, int h, int p) {
        depth[tmp] = h; //현재 노드의 높이 기록

        for(int next: graph[tmp]) { //모든 자식노드에 대해
            if(next==p) continue; //양방향으로 관계를 저장하므로 부모노드는 건너뛰기

            init(next, h+1, tmp); //재귀적으로 탐색
            parent[next][0] = tmp; //자식노드의 부모는 현재노드
        }
    }

    static int getHeight() {
        return (int)Math.ceil(Math.log(N)/Math.log(2))+1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        H = getHeight(); //트리의 높이 구하기

        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=1;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            graph[from].add(to);
            graph[to].add(from);
        }

        depth = new int[N+1];
        parent = new int[N+1][H];

        init(1,1,0); //depth 배열 초기화+parent 배열 초기화
        fillParent(); //조상노드 모두 기록하기

        //두 노드의 LCA 찾기
        StringBuilder sb = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());
        for(int q=0;q<Q;q++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(find(a,b)+"\n");
        }

        System.out.println(sb.toString());
    }
}