import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> tset = new TreeSet<>();
        for(int i=0;i<N;i++) {
            int tmp = Integer.parseInt(st.nextToken());
            tset.add(tmp);
        }

        //좌표 압축
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx=1;
        for(int n: tset) {
            map.put(n, idx);
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        for(int q=0;q<Q;q++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            s = map.get(s);
            e = map.get(e);
            sb.append((e-s+1)+"\n");
        }

        System.out.println(sb.toString());
    }
}