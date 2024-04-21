import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static StringBuilder sb;

    static Node[] tree;

    static void postorder(int n) {
        if(n<0) return; //없는 노드

        postorder(tree[n].left);
        postorder(tree[n].right);
        sb.append((char)(n+'A'));
    }

    static void inorder(int n) {
        if(n<0) return; //없는 노드

        inorder(tree[n].left);
        sb.append((char)(n+'A'));
        inorder(tree[n].right);
    }

    static void preorder(int n) {
        if(n<0) return; //없는 노드

        sb.append((char)(n+'A'));
        preorder(tree[n].left);
        preorder(tree[n].right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new Node[N];

        for(int n=0;n<N;n++) {
            //각 알파벳을 int로 대체해서 저장: A-0, B-1, ...
            String tmp = br.readLine();
            int root = tmp.charAt(0)-'A';
            int left = tmp.charAt(2)-'A';
            int right = tmp.charAt(4)-'A';

            tree[root] = new Node(left, right);
        } //end input

        sb = new StringBuilder();
        
        preorder(0);
        sb.append("\n");

        inorder(0);
        sb.append("\n");

        postorder(0);
        System.out.println(sb.toString());
    }

    static class Node {
        int left, right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}