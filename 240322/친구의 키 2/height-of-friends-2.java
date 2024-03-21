import java.util.*;
import java.io.*;

public class Main {

    static int N,M;

    static int[] indegree;

    static ArrayList<Integer>[] graph;

    public static boolean sort() {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1;i<=N;i++) {
            if(indegree[i]==0) {
                q.offer(i);
            }
        }

        int cnt = q.size();
        while(!q.isEmpty()) {
            int tmp = q.poll();

            for(int next: graph[tmp]) {
                indegree[next]--;
                if(indegree[next]==0) {
                    q.offer(next);
                    cnt++;
                }
            }
        }

        if(cnt==N)
            return true;
        
        return false;
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
        }

        System.out.println(sort()?"Consistent":"Inconsistent");
    }
}