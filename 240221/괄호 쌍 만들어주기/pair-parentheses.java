import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = br.readLine().toCharArray();
        int N = inputs.length;

        int[] dp = new int[100000];
        for(int i=N-2;i>=0;i--) {
            dp[i] = dp[i+1];

            if(inputs[i]==')' && inputs[i+1]==')')
                dp[i]++;
        }

        long ans=0;
        for(int i=0;i<N-2;i++) {
            if(inputs[i]=='(' && inputs[i+1]=='(') {
                ans += dp[i+2];
            }
        }
        
        System.out.println(ans);
    }
}