import java.util.*;

public class Main {

    static int N,M;

    static boolean[] check;

    static void comb(int idx, int cnt) {
        if(cnt==M) {
            for(int i=1;i<=N;i++) {
                if(check[i]) 
                    System.out.print(i+" ");
            }
            System.out.println();

            return;
        }

        for(int i=idx;i<=N;i++) {
            check[i] = true;
            comb(i+1, cnt+1);
            check[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        check = new boolean[N+1];
        comb(1,0);
    }
}