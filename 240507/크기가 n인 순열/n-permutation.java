import java.util.*;

public class Main {

    static int N;

    static StringBuilder sb;

    static int[] ans;
    static boolean[] visit;

    static void print() {
        for(int i=1;i<=N;i++) {
            sb.append(ans[i]+" ");
        }
        sb.append("\n");
    }

    static void perm(int cnt) {
        if(cnt==N+1) {
            print();
            return;
        }

        for(int i=1;i<=N;i++) {
            if(visit[i]) continue; //이미 선택한 숫자는 패스

            visit[i] = true;
            ans[cnt] = i;

            perm(cnt+1);

            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();//end input

        ans = new int[N+1];
        visit = new boolean[N+1];

        sb = new StringBuilder(); //출력을 저장할 StringBuilder

        perm(1);

        System.out.println(sb.toString());
    }
}