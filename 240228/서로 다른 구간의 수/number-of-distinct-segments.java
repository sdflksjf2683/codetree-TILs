import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Point> inputlist = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            inputlist.add(new Point(i, s, false));
            inputlist.add(new Point(i, e, true));
        } //end input

        Collections.sort(inputlist);

        int ans=0;
        HashSet<Integer> set = new HashSet<>();
        for(Point p: inputlist) {
            if(!p.isEnd) { //시작점

                if(set.isEmpty()) { //새로운 뭉치
                    ans++;
                }

                set.add(p.num);
            } else { //끝점
                set.remove(p.num);
            }
        }

        System.out.println(ans);
    }

    static class Point implements Comparable<Point> {
        int num,x;
        boolean isEnd;

        public Point(int num, int x, boolean isEnd) {
            this.num = num;
            this.x = x;
            this.isEnd = isEnd;
        }

        @Override
        public int compareTo(Point o) {
            return this.x-o.x;
        }
    }
}