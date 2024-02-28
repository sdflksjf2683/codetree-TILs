import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[200_001];
        StringTokenizer st;
        int last=0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            nums[s]+=1;
            nums[e]-=1;
            last = Math.max(e, last);
        }

        int[] ans = new int[last+1];
        for(int i=1,size=last+1;i<size;i++) {
            ans[i] = nums[i]+ans[i-1];
        }

        Arrays.sort(ans);
        System.out.println(ans[last]);
    }
}