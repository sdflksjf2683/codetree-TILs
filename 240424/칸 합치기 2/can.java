import java.io.*;
import java.util.*;

public class Main {

    static int N,M;

    static int[] parent;

    static int find(int x) {
        if(parent[x]==x) {
            return x;
        }

        int root = find(parent[x]);
        parent[x] = root;

        return root; 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=1;i<=N;i++) {
            parent[i] = i;
        } //init

        StringBuilder sb = new StringBuilder();
        for(int m=0;m<M;m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            while(true) {
                a = find(a);

                if(a>=b) break;

                parent[a] = a+1;
                a++;
                N--;
            }
            sb.append(N+"\n");
        }

        System.out.println(sb.toString());
    }
}