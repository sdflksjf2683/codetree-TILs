import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] coins = new int[N];
        for(int i=0;i<N;i++) {
            coins[i] = sc.nextInt();
        } //end input

        int cnt=0;
        for(int i=N-1;i>=0;i--) {

            if(K==0) break;

            if(K<coins[i]) continue;

            cnt+=(K/coins[i]);
            K=K%coins[i];
        }

        System.out.println(cnt);
    }
}