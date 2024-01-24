import java.util.*;

public class Main {

    static int N,min;

    static int[] arr;

    static void move(int idx, int cnt) {
        if(idx==N-1) {
            min = Math.min(min, cnt);
            return;
        }

        if(cnt>min) {
            return;
        }

        int tmp = arr[idx];
        for(int i=1;i<=tmp;i++) {
            if(idx+i>N-1) continue;
            move(idx+i, cnt+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        } //end input

        min = Integer.MAX_VALUE;
        move(0,0);

        System.out.println(min==Integer.MAX_VALUE?-1:min);
    }
}