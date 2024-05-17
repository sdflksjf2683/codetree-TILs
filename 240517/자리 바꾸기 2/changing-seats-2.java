import java.util.*;
import java.io.*;

public class Main {

    static int N,K;

    static int[] tmpSeat;

    static int[][] commands;

    static HashSet<Integer>[] seatList;

    static void simulate() {
        for(int k=0;k<K;k++) {
            int a = commands[k][0];
            int b = commands[k][1];

            int tmpa = tmpSeat[a];
            int tmpb = tmpSeat[b];

            seatList[tmpa].add(b); //현재 a번 위치에 있는 사람은 b번 위치에 앉게 됨
            seatList[tmpb].add(a); //현재 b번 위치에 있는 사람은 a번 위치에 앉게 됨

            //실제 a와 b의 위치 업데이트
            tmpSeat[a] = tmpb;
            tmpSeat[b] = tmpa;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        tmpSeat = new int[N+1]; //현재 자리 배치 상태를 저장할 배열
        commands = new int[K][2]; //명령어를 저장할 배열
        seatList = new HashSet[N+1];//번호별 앉았던 자리 번호를 저장할 set

        //init
        for(int i=1;i<=N;i++) {
            tmpSeat[i] = i;
            seatList[i] = new HashSet<>();
            seatList[i].add(i); //초기 자리
        }

        for(int k=0;k<K;k++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            commands[k][0] = a;
            commands[k][1] = b;
        } //end input

        for(int i=0;i<3;i++) {
            simulate();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            sb.append(seatList[i].size()+"\n");
        }
        System.out.println(sb.toString());
    }
}