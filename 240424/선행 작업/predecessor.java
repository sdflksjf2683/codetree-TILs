import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static int[] indegree, dp, task;

    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }

        indegree = new int[N+1]; //진입차수 저장
        dp = new int[N+1]; //n번째 작업을 끝내기 위한 최소 시간 저장
        task = new int[N+1]; //n번째 작업 소요시간 저장
        Queue<Integer> q = new LinkedList<>(); //위상정렬을 위한 큐
        
        StringTokenizer st;
        for(int n=1;n<=N;n++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            task[n] = w;

            int T = Integer.parseInt(st.nextToken());
            if(T==0)  {
                q.offer(n); //가장 먼저 시작될 작업은 큐에 넣기
                dp[n] = w;
            }

            for(int t=0;t<T;t++) {
                int prev = Integer.parseInt(st.nextToken());
                graph[prev].add(n);
            }
            indegree[n] = T;
        }

        while(!q.isEmpty()) {
            int tmp = q.poll();

            for(int next: graph[tmp]) {
                dp[next] = Math.max(dp[next], dp[tmp]+task[next]);
                indegree[next]--;

                if(indegree[next]==0)
                    q.offer(next);
            }
        }

        int ans = 0;
        for(int i=1;i<=N;i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}