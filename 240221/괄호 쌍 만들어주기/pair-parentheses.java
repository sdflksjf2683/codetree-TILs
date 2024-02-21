import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = br.readLine().toCharArray();
        int N = inputs.length;

        int[] dp = new int[N];
        for(int i=1;i<N;i++) {
            dp[i] = dp[i-1];

            if(inputs[i-1]=='(' && inputs[i]=='(')
                dp[i]++;
        }

        long ans=0;
        for(int i=N-1;i>=1;i--) {
            if(inputs[i]==')' && inputs[i-1]==')') {
                ans += dp[i-2];
            }
        }
        
        System.out.println(ans);
    }
}