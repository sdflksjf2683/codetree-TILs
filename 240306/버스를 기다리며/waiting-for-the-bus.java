import java.io.*;
import java.util.*;

public class Main {

    static int N,M,C;

    static int[] arr;

    static boolean isPossible(int tmp) {
        int buscnt = 1;
        int before=arr[0], idx=0;

        for(int i=1;i<N;i++) {
            if(arr[i]-before>tmp || i+1-idx>C) {
                buscnt++;
                before = arr[i];
                idx = i;
            }
        }

        if(buscnt<=M) return true;

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } //end input

        Arrays.sort(arr);

        int l=0,r=1_000_00;
        int ans = Integer.MAX_VALUE;

        while(l<=r) {
            int mid = (l+r)/2;
            if(isPossible(mid)) {
                r = mid-1;
                ans = Math.min(ans, mid);
            } else {
                l = mid+1;
            }
        }

        System.out.println(ans);
    }
}