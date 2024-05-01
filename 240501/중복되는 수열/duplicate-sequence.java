import java.io.*;

public class Main {

    static int N;

    static String[] words;

    static TrieNode root; //루트노드

    static boolean search(String s) {
        TrieNode tmp = root;

        for(int i=0,size=s.length();i<size;i++) {
            //완성된 단어를 발견한 경우
            if(tmp.isEnd) {
                return true;
            }

            int idx = s.charAt(i)-'0';
            if(tmp.child[idx]==null) { //해당 문자로 시작하는 단어가 없는 경우
                return false;
            }

            tmp = tmp.child[idx]; //자식노드로 이동
        }

        return false;
    }

    static void insert(String s) {
        TrieNode tmp = root; //루트에서 시작

        //문자열의 모든 문자에 대해
        for(int i=0,size=s.length();i<size;i++) {
            //해당 문자를 0~9의 인덱스로 변환
            int idx = s.charAt(i)-'0';

            //노드가 없을 경우 새로 만들어줌
            if(tmp.child[idx]==null) {
                tmp.child[idx] = new TrieNode();
            }

            //해당 노드로 이동
            tmp = tmp.child[idx];
        }

        tmp.isEnd = true; //가장 마지막 문자 위치에선 단어가 완성됐음을 표시
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        words = new String[N];
        root = new TrieNode();

        for(int i=0;i<N;i++) {
            words[i] = br.readLine();
            insert(words[i]);
        } //end input

        int ans=1;
        for(int i=0;i<N;i++) {
            if(search(words[i])) {
                ans=0;
                break;
            }
        }

        System.out.println(ans);
    }

    static class TrieNode {
        //각 노드에 문자열의 문자에 대응되는 노드 정보 관리
        TrieNode[] child = new TrieNode[10];
        boolean isEnd; //단어 완성 여부, T:하나의 단어를 이룸, F:단어 아님X

        //생성자 - 필드 초기화
        public TrieNode() {
            this.isEnd = false;

            for(int i=0;i<10;i++) {
                child[i] = null;
            }
        }
    }
}