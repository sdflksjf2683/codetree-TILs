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

        StringBuilder sb = new StringBuilder(); //연산 결과를 저장한 뒤 한 번에 출력
        for(int m=0;m<M;m++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(cmd.equals("0"))
                union(a,b);
            else {
                if(find(a)==find(b))
                    sb.append("1\n");
                else
                    sb.append("0\n");
            }
        }

        System.out.println(sb.toString());
    }
}