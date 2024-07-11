import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] costs = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        } //end input

        int minCost=costs[0], profit=0; //minCost=가장 적은 가격, profit=최대 수익
        for(int i=1;i<N;i++) {
            int tmp = costs[i]-minCost; //i번째 팔았을 때 예상 이익 계산

            if(tmp>profit) { //최대 수익보다 큰 경우 최대 수익 갱신
                profit = tmp;
            }

            if(costs[i]<minCost) { //현재 가격이 더 적다면 이후 더 높은 수익을 낼 가능성이 있으므로 minCost 갱신 후 탐색
                minCost = costs[i];
            }
        }

        System.out.println(profit);
    }
}