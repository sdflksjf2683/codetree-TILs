import java.util.*;
import java.io.*;

public class Main {

    static int N,M,T,K;

    static ArrayList<Marble>[][] map;

    static int[] di = {-1,0,1,0}; //U-R-D-L 순서
    static int[] dj = {0,1,0,-1};

    static void crash(int i, int j) {

        Collections.sort(map[i][j]); //미리 정의한 비교조건대로 정렬

        for(int m=map[i][j].size()-1;m>=K;m--) { //K개가 넘는 구슬 중 우선순위가 낮은 구술 모두 삭제
            map[i][j].remove(m);
            M--; //구슬 개수도 삭제 
        }
    }

    static void move(int si, int sj) {
        int cnt=0; //다른 위치로 이동한 구슬 수
        for(int m=0,size=map[si][sj].size();m<size;m++) { //해당 위치에 있는 구슬 이동시키기
            Marble tmp = map[si][sj].get(m);
            
            if(tmp.moveTurn==T) continue; //이미 이번 턴에 움직여서 이 위치에 온 구슬(중복이동X)

            int ni=si,nj=sj,td=tmp.d;
            for(int v=0,vsize=tmp.v;v<vsize;v++) {
                ni+=di[td];
                nj+=dj[td];

                if(ni<0 || ni>=N || nj<0 || nj>=N) { //방향보정
                    td = (td+2)%4;
                    tmp.d = td; //바뀐 방향 갱신
                    ni+=di[td]*2;
                    nj+=dj[td]*2;
                }
            }
            tmp.moveTurn = T; //현재 이동한 턴 갱신

            if(si!=ni || sj!=nj) { //시작 위치와 다르면 다른 위치로 이동한 것
                map[ni][nj].add(tmp); //새로운 위치에 구슬 추가
                cnt++;
            }
        }

        //구슬 일괄 삭제
        while(cnt>0) {
            map[si][sj].remove(0);
            cnt--;
        }
    }

    static int getDir(String d) { //입력받은 방향을 delta 배열 인덱스로 변환
        if(d.equals("U")) return 0;
        if(d.equals("R")) return 1;
        if(d.equals("D")) return 2;
        return 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new ArrayList[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for(int m=1;m<=M;m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            int d = getDir(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map[i][j].add(new Marble(m,d,v,-1)); //맵의 각 위치에 구슬 위치시키기
        } //end input

        while(T>0) {
            //1. 모든 구슬 이동시키기
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(map[i][j].size()==0) continue;
                    move(i,j);
                }
            }

            //2. 충돌 검사
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(map[i][j].size()>K) { //현재 위치에 구슬이 K개 넘게 있다면 충돌 발생
                        crash(i,j);
                    }
                }
            }

            T--;

            if(M==0) break; //모든 구슬이 사라졌다면 즉시 종료
        }

        System.out.println(M);
    }

    static class Marble implements Comparable<Marble> {
        int n,d,v,moveTurn;

        public Marble(int n, int d, int v, int moveTurn) {
            this.n = n;
            this.d = d;
            this.v = v;
            this.moveTurn = moveTurn; //현재 구슬이 몇 번째 턴에 이동한 구슬인지를 나타내는 변수(동시 이동 처리)
        }

        @Override
        public int compareTo(Marble m) {
            if(this.v==m.v)
                return m.n-this.n; //속도가 같을 경우 번호 내림차순 정렬
            
            return m.v-this.v; //속도 기준 내림차순 정렬
        }
    }
}