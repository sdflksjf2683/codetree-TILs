import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] nums = new int[N][2]; //0: 숫자, 1: 개수

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            nums[i][0] = num;
            nums[i][1] = cnt;
        } //end input

        //숫자를 기준으로 오름차순 정렬
        Arrays.sort(nums, (n1, n2)-> {
            return n1[0]-n2[0];
        });

        long C=0;
        int l=0,r=N-1;
        //두 자연수의 합을 가장 적게 만드는 법 = 가장 큰 수와 가장 작은 수를 더하기(중간 수에 도달할 때까지 반복)
        while(l<=r) {
            //해당 숫자를 모두 소진했다면 다른 숫자 이용
            if(nums[l][1]==0) {
                l++;
                continue;
            }
            if(nums[r][1]==0) {
                r--;
                continue;
            }

            C = Math.max(C, nums[l][0]+nums[r][0]);
            //숫자를 사용했으므로 개수 감소
            nums[l][1]--;
            nums[r][1]--;
        }
        System.out.println(C);
    }
}