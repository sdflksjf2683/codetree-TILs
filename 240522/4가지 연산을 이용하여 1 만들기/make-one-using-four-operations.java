import java.util.*;

public class Main {

    static int bfs(int N) {
        PriorityQueue<Number> pq = new PriorityQueue<>(); //최소 연산 횟수를 빠르게 구하기 위해 우선순위 큐 사용
        HashSet<Integer> visit = new HashSet<>(); //중복체크를 할 hashset
        
        pq.offer(new Number(N, 0)); //N에서 연산 시작

        while(!pq.isEmpty()) {
            Number tmp = pq.poll();

            if(tmp.n==1) { 
                //1을 만들었다면 연산 횟수를 리턴
                //연산 횟수 오름차순 정렬을 수행하므로 가장 처음 만든 1 = 최소 연산 횟수로 만든 1
                return tmp.cnt;
            }

            if(visit.contains(tmp.n)) continue; //중복 연산 수행 및 메모리 초과 방지
            
            visit.add(tmp.n);

            //4가지 연산 사용하기
            if(tmp.n%2==0) {
                pq.offer(new Number(tmp.n/2, tmp.cnt+1));
            }

            if(tmp.n%3==0) {
                pq.offer(new Number(tmp.n/3, tmp.cnt+1));
            }

            pq.offer(new Number(tmp.n+1, tmp.cnt+1));
            pq.offer(new Number(tmp.n-1, tmp.cnt+1));
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(bfs(N));
    }

    static class Number implements Comparable<Number> { //bfs 탐색에 사용할 객체 클래스
        int n, cnt; //현재 만든 숫자와 연산 횟수를 필드로 가짐

        public Number(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Number o) { //정렬 조건은 연산 횟수가 적은 순서대로
            if(this.cnt==o.cnt) { //연산 횟수가 동일하다면 더 작은 숫자를 기준으로 정렬
                return this.n-o.n;
            }

            return this.cnt-o.cnt;
        }
    }
}