import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String init = sc.next();
        String target = sc.next();

        int ans=0;
        boolean flag = true;
        for(int i=0;i<N;i++) {
            if(init.charAt(i)==target.charAt(i)) {
                if(!flag) {
                    ans++;
                }
                flag = true;
            } else {
                flag = false;
            }
        }

        if(!flag) ans++; //마지막 구간

        System.out.println(ans);
    }
}