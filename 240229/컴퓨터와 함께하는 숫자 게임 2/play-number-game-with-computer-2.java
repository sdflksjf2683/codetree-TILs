import java.util.*;

public class Main {

    static long M;

    static long search(long target) {
        long l=1,r=M,cnt=1,mid=-1;

        while(l<=r) {
            mid = (l+r)/2;

            if(mid==target) {
                break;
            } else if(mid<target) {
                l = mid+1;
            } else {
                r = mid-1;
            }

            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextLong();

        long a = sc.nextLong();
        long b = sc.nextLong();

        long min=Long.MAX_VALUE, max=Long.MIN_VALUE;
        for(long i=a;i<=b;i++) {
            long tmp = search(i);
            min = Math.min(tmp, min);
            max = Math.max(tmp, max);
        }

        System.out.println(min+" "+max);
    }
}