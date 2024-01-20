import java.util.*;
import java.io.*;

public class Main {

    static int N,M;

    static boolean[] visit;

    static ArrayList<Integer>[] list;

    static void dfs(int tmp) {
        if(visit[tmp]) {
            return;
        }

        visit[tmp] = true;

        for(int i=0,size=list[tmp].size();i<size;i++) {
            int next = list[tmp].get(i);

            if(visit[next]) continue;

            dfs(next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
        } //end input

        visit = new boolean[N+1];
        dfs(1);

        int ans = 0;
        for(boolean v: visit) {
            if(v) ans++;
        }

        System.out.println(ans-1);
    }
}