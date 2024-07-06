import java.io.*;
import java.util.*;

public class Main {

    static int N,Q;

    static TreeSet<Integer> set;

    static HashMap<Integer, Integer> map;

    static int getKey(int tmp) {
        Integer res = set.floor(tmp);
        return res==null?0:res;
    }

    static void gridCompression() { //좌표 압축을 진행하는 메소드
        int cnt=1;

        for(int tmp: set) {
            //key=좌표위치, value=순서
            map.put(tmp, cnt++);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        set = new TreeSet<>(); //입력된 좌표를 오름차순으로 저장
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int tmp = Integer.parseInt(st.nextToken());
            set.add(tmp);
        }

        map = new HashMap<>(); //좌표 위치를 압축해서 저장할 map
        gridCompression();

        StringBuilder sb = new StringBuilder();
        for(int q=0;q<Q;q++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            s = getKey(s-1);
            e = getKey(e);

            s = s==0?0:map.get(getKey(s));
            e = e==0?0:map.get(getKey(e));

            sb.append((e-s)+"\n");
        }

        System.out.println(sb.toString());
    }
}