import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean[] b = new boolean[N*2+1];
        for(int i=0;i<N;i++) {
            b[sc.nextInt()] = true;
        } //end input

        //a가 갖고 있는 카드를 treeset에 저장
        TreeSet<Integer> a = new TreeSet<>();
        for(int i=1;i<=N*2;i++) {
            if(!b[i]) {
                a.add(i);
            }
        }

        int ans=0;
        for(int i=1;i<=N*2;i++) {

            if(!b[i]) continue;

            Integer tmpa = a.higher(i);

            if(tmpa==null) { //더 높은 카드가 없는 경우 = b가 낸 것보다 작은 카드를 내야 함 
                a.remove(a.lower(i));
            } else {
                a.remove(tmpa);
                ans++;
            }
        }

        System.out.println(ans);
    }
}