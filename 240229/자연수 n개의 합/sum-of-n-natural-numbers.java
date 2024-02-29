import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();

        long l=1, mid=0, max=0;
        long r = (long)Math.sqrt(S*2)+1;

        while(l<=r) {
            mid = (l+r)/2;
            
            if(mid*(mid+1)/2 <= S) {
                max = Math.max(max, mid);
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        System.out.println(max);
    }
}