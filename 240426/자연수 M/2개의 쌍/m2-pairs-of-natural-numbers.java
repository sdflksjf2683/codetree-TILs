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

            C = Math.max(C, nums[l][0]+nums[r][0]);

            //두 숫자의 남은 개수에 차이가 있는 경우
            //더 적은 숫자의 개수를 더 많은 숫자의 개수에서 빼주고 더 적은 쪽 포인터를 옮김(어차피 같은 값이므로 스킵 가능)
            if(nums[l][1]<nums[r][1]) {
                nums[r][1]-=nums[l][1]; 
                l++;
            } else if(nums[l][1]>nums[r][1]) {
                nums[l][1]-=nums[r][1];
                r--;
            } else { //개수가 동일하다면 포인터 둘 다 이동
                l++;
                r--;
            }
        }
        System.out.println(C);
    }
}