import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        TreeSet<Integer> removeNums = new TreeSet<>();
        TreeSet<Point> lis = new TreeSet<>();

        removeNums.add(-1);
        removeNums.add(N+1);

        lis.add(new Point(-1,N+1,N+1));
        
        for(int m=0;m<M;m++) {
            int n = sc.nextInt();

            removeNums.add(n);

            int backn = removeNums.higher(n); //바로 뒤 숫자
            int frontn = removeNums.lower(n); //바로 앞 숫자 

            lis.remove(new Point(frontn, backn, backn-frontn-1)); //n포함 구간 제거
            
            //n기준 왼쪽 오른쪽 구간 길이 넣기
            lis.add(new Point(frontn, n, n-frontn-1));
            lis.add(new Point(n, backn, backn-n-1));

            System.out.println(lis.first().len); //제일 긴 구간
        }
    }

    static class Point implements Comparable<Point> {
        int s,e,len;
        
        public Point(int s, int e, int len) {
            this.s = s;
            this.e = e;
            this.len = len;
        }

        @Override
        public int compareTo(Point o) {
            if(this.len!=o.len) return o.len-this.len;
            if(this.s!=o.s) return this.s-o.s;
            return this.e-o.e; 
        }
    }
}