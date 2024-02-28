import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<User> ulist = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            ulist.add(new User(i, s, false));
            ulist.add(new User(i, e, true));
        }

        Collections.sort(ulist);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=1;i<=100_000;i++)
            q.offer(i);
        
        int[] ans = new int[N];
        for(User u: ulist) {
            if(!u.isEnd) { //컴퓨터 사용
                ans[u.num] = q.poll();
            } else { //컴퓨터 반납
                q.offer(ans[u.num]);
            }
        }

        for(int i: ans) {
            System.out.print(i+" ");
        }

    }

    static class User implements Comparable<User> {
        int time, num;
        boolean isEnd;

        public User(int num, int time, boolean isEnd) {
            this.num = num;
            this.time = time;
            this.isEnd = isEnd;
        }

        @Override
        public int compareTo(User o) {
            return this.time - o.time;
        }
    }
}