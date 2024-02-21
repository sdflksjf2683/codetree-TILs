import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = br.readLine().toCharArray();

        int lcnt=0,rcnt=0;
        char tmp = inputs[0];
        for(int i=1,size=inputs.length;i<size;i++) {
            if(tmp==inputs[i]) {
                if(tmp=='(') lcnt++;
                else rcnt++;
            } else {
                tmp = inputs[i];
            }

        }

        System.out.println(lcnt*rcnt);
    }
}