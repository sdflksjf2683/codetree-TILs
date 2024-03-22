import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static int[] nums;

    static boolean isPossible(int k) {
        int cnt=0;
        for(int n: nums) {
            cnt += n/k;
        }
        return cnt>=M?true:false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        int r=0;
        for(int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(br.readLine());
            r = Math.max(nums[i],r);
        } //end input

        int k=0,l=0;
        while(l<=r) {
            int mid = (l+r)/2;
            if(mid>0 && isPossible(mid)) {
                k = mid;
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        System.out.println(k);
    }
}