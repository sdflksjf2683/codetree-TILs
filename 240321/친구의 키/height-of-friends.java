import java.util.*;
import java.io.*;

public class Main {

    static int N,M;

    static int[] indegree;

    static ArrayList<Integer>[] graph;

    public static String sort() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        //초기세팅
        for(int i=1;i<=N;i++) {
            if(indegree[i]==0)
                q.offer(i);
        }

        //위상정렬 진행
        while(!q.isEmpty()) {
            int tmp = q.poll();

            sb.append(tmp+" ");

            for(int next: graph[tmp]) {
                indegree[next]--; //방문한 노드는 indegree 감소시키기
                if(indegree[next]==0)
                    q.offer(next);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];

        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            indegree[b]++;
        } //end input

        System.out.println(sort());
    }
}