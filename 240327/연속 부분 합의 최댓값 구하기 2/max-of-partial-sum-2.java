import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int max=-1001;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]); //배열에서 가장 큰 숫자를 초기값으로 설정
        } //end input

        //모든 수열이 음수로만 이루어져 있다면 아무것도 더하지 않는 경우가 합이 최대가 됨.
        if(max<0) {
            System.out.println(max);
            return;
        }

        int sum=0;
        for(int i=0;i<N;i++) {
            sum += arr[i];

            if(sum<0)
                sum=0;
            
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}