import java.util.*;

public class Main {

    static int N,K;

    static int[] arr;

    static void comb(int cnt, int idx) {
        if(cnt == N) {
            for(int i=0;i<N;i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int k=idx;k<=K;k++) {
            arr[cnt] = k;
            comb(cnt+1, idx);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();

        arr = new int[N];
        comb(0,1);
    }
}