import java.io.*;
import java.util.*;

public class Main {

    static int max,N;
    static String s;

    static Map<Character, Integer> map;

    static int calc(int a, char op, int b) {
        if(op=='+') return a+b;
        if(op=='-') return a-b;

        return a*b;
    }

    static void func(int idx, int sum) {
        if(idx==N) {
            max = Math.max(max, sum);
            return;
        }

        char op = s.charAt(idx);
        char next = s.charAt(idx+1);
        int n = map.get(next);

        if(n>0) {
            func(idx+2, calc(sum,op,n));
        } else {
            for(int i=1;i<=4;i++) {
                map.put(next, i);
                func(idx+2, calc(sum,op,i));
                map.put(next, 0);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        N = s.length();

        if(N==1) {
            System.out.println(4);
            return;
        }

        map = new HashMap<>();
        for(int i=0;i<N;i+=2) {
            char c = s.charAt(i);
            map.put(c,0);
        }

        char init = s.charAt(0);
        max = Integer.MIN_VALUE;
        for(int i=1;i<=4;i++) {
            map.put(init, i);
            func(1,i);
        }

        System.out.println(max);
    }
}